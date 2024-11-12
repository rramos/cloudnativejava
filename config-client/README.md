# README.md

* SpringBoot Config Client demo application

# What is this ?

A demo SpringBoot application based which will retrieve configuration from a Spring Config Server
Just as simple web application 

# Requirements

* This application requires java 21
* You will need to have a Spring config Server working, if not check the references for the config-server project

# How to Build ?

```sh
./gradlew build
```
# How to Run ?

```sh
./gradlew bootRun
```

# How to test this

* Access http://localhost:8086 and get a nice HelloWorld, based on the configuration that exists in the server.
* Check the following file for reference https://github.com/rramos/config-server/blob/main/user-service-dev.yml
* The application is also bundled with actuator so reaching out http://localhost:8086/actuator/health should provide status of execution

# Disclaimer

This is just a demo project, don't run this in production
If you want to load a different profile just change the `application.properties` file

# Extended

> If you prefer to use DiscoveryClient to locate the Config Server, you can do so by setting spring.cloud.config.discovery.enabled=true. The default value is false.

It could be interesting to configure auto-discovery, but for this demo project is enough.
Also the Reference docs for SprintClient provide some insightful information

# References

* https://medium.com/cloud-native-daily/spring-cloud-config-externalizing-the-configurations-from-your-microservice-284e319f7056
* https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_client