#!/usr/bin/env bash
docker ps -a -q --filter="name=forex-rate-service"
mvn clean install
docker build --build-arg JAR_FILE=target/forex-rate-service-0.0.1-SNAPSHOT.jar --file=Dockerfile --tag=spring-demo/forex-rate-service:latest .
docker run --network=spring-demo -i -t -d spring-demo/forex-rate-service
