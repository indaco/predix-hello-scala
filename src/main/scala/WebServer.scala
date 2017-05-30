// WebServer.Scala

import com.twitter.finagle.Http
import com.twitter.util.Await
import java.net.InetSocketAddress
import util.Properties

/*
 * A basic HTTP Server.
 *
 * version: 0.1
 * copyright: 2017 - Mirco Veltri
 * license: see LICENSE for more details
 */

object WebServer {
  def main(args: Array[String]): Unit = {
    val port = Properties.envOrElse("PORT", "8080").toInt
    val address = new InetSocketAddress(port)
    val server = Http.serve(address, new services.PredixAPIService )
    Await.ready(server)
  }
}
