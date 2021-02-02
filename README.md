# Exchange service
A service that accesses the exchange rate service and gives back a gif in response if today's exchange rate is higher
than yesterday's, we give the gif, if lower - another gif.

## Build and start

For build run command:

```
gradle clean assemble
```

For start run command:

```
docker-compose up
```

## Using technology

* Java 11 
* Spring Boot 2
* Feign is used for interaction with external services.
* Gradle
* Docker 