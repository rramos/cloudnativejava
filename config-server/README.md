# README.md

- Demo Project : Spring Config Server

The objective of this project is to quickly setup a Sprint Boot Configuration Service to aggregate config files for services

## Requirements

- This project was started with java 21 make sure you have that version use `sdkman` if not installed and follow the reference urls
- One should have a git repository for holding application configurations
- Use check the `config-client` project in order to test (Not mandatory)

## How to Build ?

```sh
./gradlew build
```

## How to Run ?

```sh
./gradlew bootRun
```

## How to test if this is working ?

- Go to <http://localhost:8888/user-service-dev.yml> and authenticate with the credentials in `application.yml`

## Applications repo demo config

The applications are obtain from the sample github repo but could be adjusted as you want.

```text
git@github.com:rramos/config-server.git
```

## Disclaimer

**NOTE:** Don't use this code in production this is mainly for testing purposes.

## Extended

> To enable push notifications on your config server, you need to include the spring-cloud-config-monitor library and enable the spring cloud bus in the configuration server. Upon doing this, you will have a monitor endpoint on your config server where you can configure this as a webhook for your GitHub.
> When the webhook is activated, the Config Server sends a RefreshRemoteApplicationEvent targeted at the applications it thinks might have changed.

This could be something interesting to test out :D

## References

- <https://sdkman.io/usage>
- <https://medium.com/cloud-native-daily/spring-cloud-config-externalizing-the-configurations-from-your-microservice-284e319f7056>
- <https://start.spring.io>
