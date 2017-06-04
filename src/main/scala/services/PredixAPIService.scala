// PredixAPIService.scala

package services

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.{Http, Service, SimpleFilter}
import com.twitter.finagle.http.{Request, Response, Status, Version, Method}
import com.twitter.util.Future
import io.circe._, io.circe.parser._


/*
 * A basic HTTP Client to call a REST endpoint on Predix.io
 *
 * version: 0.1
 * copyright: 2017 - Mirco Veltri
 * license: see LICENSE for more details
 */
class PredixAPIService extends Service[Request, Response]{

  val PredixAPIEndpointHost = "api.system.aws-usw02-pr.ice.predix.io"
  val PredixAPIEndpointPort = "443"
  val PathToCFInfo = "/v2/info"

  private[this] val client =
    new HandleErrors andThen
    ClientBuilder()
      .stack(Http.client)
      .hosts(s"$PredixAPIEndpointHost:$PredixAPIEndpointPort")
      .tls(PredixAPIEndpointHost)
      .hostConnectionLimit(1)
      .build()

  class InvalidRequest extends Exception

  /**
   * Convert HTTP 4xx and 5xx class responses into Exceptions.
   */
  class HandleErrors extends SimpleFilter[Request, Response] {
    def apply(request: Request, service: Service[Request, Response]) = {
      service(request) flatMap { response =>
        response.status match {
          case Status.Ok => Future.value(response)
          case Status.Forbidden => Future.exception(new InvalidRequest)
          case _ => Future.exception(new Exception(response.status.reason))
        }
      }
    }
  }

   def apply(req: Request): Future[Response] = {
     val authorizedRequest = Request(Version.Http11, Method.Get, PathToCFInfo)
     client(authorizedRequest) onSuccess { response =>
       val parsedJson: Json = parse(response.contentString).getOrElse(Json.Null)
       val cursor: HCursor = parsedJson.hcursor
       val cfDescription = cursor.downField("description").as[String].right.getOrElse("")
       val cfAPIVersion = cursor.downField("api_version").as[String].right.getOrElse("")

       response.setStatusCode(200)
       response.setContentString(s"$cfDescription: API version = $cfAPIVersion")
     }
  }

}
