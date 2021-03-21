# Simple RabbitMQ Producer

## Overview

This application simply produces `NUM_OF_MESSAGES` RabbitMQ messages to `hello` queue.

## Version

- Java 11
- Maven 3.6.3

## Run RabbitMQ Producer

### With local java and RabbitMQ

1. Run RabbitMQ

    Mac OS:

    ```
    brew install rabbitmq
    brew services start rabbitmq
    export PATH=$PATH:/usr/local/opt/rabbitmq/sbin # to add rabbitmq cli
    ```

    Other OS: TBD

1. Build

    ```
    mvn clean compile assembly:single
    ```
1. Run
    ```
    java -jar target/rabbitmq-producer-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```
