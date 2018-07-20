Forex Rate Service
=

Get forex rates from openexchangerates.org

Creating Docker Image
-

`docker build --build-arg JAR_FILE=target/forex-rate-service-0.0.1-SNAPSHOT.jar --file=Dockerfile --tag=spring-demo/forex-rate-service:latest .`

Run Docker Image
-

`docker run --network=spring-demo -i -t -d spring-demo/forex-rate-service`

Accessing The Web Service
-

`curl http://localhost:9000/forex-rate-service/rate/USD/ZAR | json_pp`
 