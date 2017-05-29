# Predix-Hello-Scala

A basic attempt to develop on Predix.io using the Scala programming language and its ecosystem of awesome libraries.

This sample app leverages on:

- Scala v.2.12.2
- SBT v.013.15
- [SBT Native Packager](https://github.com/sbt/sbt-native-packager) to build application packages in native format and generate a start script for the project
- [Finagle](https://twitter.github.io/finagle/) as underlying http server and client
- [Circe](https://circe.github.io/circe/) as JSON library for Scala
- [heroku-buildpack-scala](https://github.com/heroku/heroku-buildpack-scala) for Cloud Foundry

Here is a [Live Demo](https://mv-predix-hello-scala.run.aws-usw02-pr.ice.predix.io/)

## What it does?

- Create a Finagle HTTP Server
- Create a Finagle HTTP Client (based on [this example](https://github.com/tattyamm/finagle-http-sample/blob/master/src/main/scala/jp/tattyamm/finagle/sample/HttpClient.scala)) to call the Predix API Endpoint and get info on the environment
- Show an extract from that info
`Cloud Foundry GE Open Sandbox: API version = 2.62.0`

## How to use it?

It can be used as baseline to create some more complex stuff on Predix using the Scala way.

1. Clone the repos
`
$ git clone https://github.com/indaco/predix-hello-scala
`

2. Open the `manifest.yml` file and edit the `name` for your own application

3. Push the app to you r Predix account `$cf push`

- - -

### Copyright and License

Licensed under the MIT License, see the LICENSE file.

- - -

#### DISCLAIMER

This is **not** an official development from the GE Digital's Predix Team
