# Predix-Hello-Scala

A basic attempt to develop on Predix.io using the Scala programming language and its ecosystem of awesome libraries.

This sample app leverages on:

- Scala v.2.12.2
- SBT v.013.15
- [SBT Native Packager](https://github.com/sbt/sbt-native-packager) to build application packages in native format and generate a start script for the project
- [Finagle](https://twitter.github.io/finagle/) as underlying http server and client
- [Circe](https://circe.github.io/circe/) as JSON library for Scala
- [heroku-buildpack-scala](https://github.com/heroku/heroku-buildpack-scala) for Cloud Foundry

## What does it do?

- Create a Finagle HTTP Server
- Create a Finagle HTTP Client (based on [this example](https://github.com/tattyamm/finagle-http-sample/blob/master/src/main/scala/jp/tattyamm/finagle/sample/HttpClient.scala)) to call the Predix API Endpoint and get info on the environment
- Show an extract from that info
`Cloud Foundry GE Open Sandbox: API version = 2.62.0`

## Getting Started

### Install tools
Be sure to have [SBT](http://www.scala-sbt.org/) installed on you machine

### Get the source code

Make a directory for your project. Clone or download and extract the starter in that directory.

```
git clone https://github.com/indaco/predix-hello-scala.git
cd predix-hello-scala
```

## Running the app locally

```
sbt

> run-main WebServer
```

## Running in Predix Cloud

1. Open the `manifest.yml` file and edit the `name` for your own application
2. Push the app to your Predix account `$cf push`

- - -

### Copyright and License

Licensed under the MIT License, see the LICENSE file.

- - -

#### DISCLAIMER

This is **not** an official development from the GE Digital's Predix Team
