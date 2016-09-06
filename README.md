# Play REST API
![alt-tag](/screenshoot.png)
This is the project that goes along with the article.

## Appendix

### Running

You need to download and install sbt for this application to run.

Once you have sbt installed, the following at the command prompt will start up Play in development mode:

```
sbt run
```

Play will start up on the HTTP port at http://localhost:9000/.   You don't need to reploy or reload anything -- changing any source code while the server is running will automatically recompile and hot-reload the application on the next HTTP request. 

If you want to make a package in the local and share this pakage to the other project .
```
$ sbt publishLocal
```
We will receive the new files
```
[info]  published scala-api-lib_2.11 to /Users/PhanVanTrung/.ivy2/local/vn.co.pvt.scala-api-lib/scala-api-lib_2.11/0.0.1/poms/scala-api-lib_2.11.pom
[info]  published scala-api-lib_2.11 to /Users/PhanVanTrung/.ivy2/local/vn.co.pvt.scala-api-lib/scala-api-lib_2.11/0.0.1/jars/scala-api-lib_2.11.jar
[info]  published scala-api-lib_2.11 to /Users/PhanVanTrung/.ivy2/local/vn.co.pvt.scala-api-lib/scala-api-lib_2.11/0.0.1/srcs/scala-api-lib_2.11-sources.jar
[info]  published scala-api-lib_2.11 to /Users/PhanVanTrung/.ivy2/local/vn.co.pvt.scala-api-lib/scala-api-lib_2.11/0.0.1/docs/scala-api-lib_2.11-javadoc.jar
[info]  published ivy to /Users/PhanVanTrung/.ivy2/local/vn.co.pvt.scala-api-lib/scala-api-lib_2.11/0.0.1/ivys/ivy.xml

```
At the new project, add the following code to build.sbt file
```
libraryDependencies := Seq(
  "vn.co.pvt"    %% "scala-api-lib"   % "0.0.1",
  )
```

### Usage

If you call the same URL from the command line, you’ll see JSON. Using httpie, we can execute the command:

```
http --verbose http://localhost:9000/v1/posts
```

and get back:

```
GET /v1/posts HTTP/1.1
```

Likewise, you can also send a POST directly as JSON:

```
http --verbose POST http://localhost:9000/v1/posts title="hello" body="world"
```

and get:

```
POST /v1/posts HTTP/1.1
```

### Load Testing

The best way to see what Play can do is to run a load test.  We've included Gatling in this test project for integrated load testing.

Start Play in production mode, by [staging the application](https://www.playframework.com/documentation/2.5.x/Deploying) and running the play script:s

```
sbt stage
cd target/universal/stage
bin/play-rest-api -Dplay.crypto.secret=testing
```

Then you'll start the Gatling load test up (it's already integrated into the project):

```
sbt gatling:test
```

For best results, start the gatling load test up on another machine so you do not have contending resources.  You can edit the [Gatling simulation](http://gatling.io/docs/2.2.2/general/simulation_structure.html#simulation-structure), and change the numbers as appropriate.

Once the test completes, you'll see an HTML file containing the load test chart:

```
 ./rest-api/target/gatling/gatlingspec-1472579540405/index.html
```

That will contain your load test results.
