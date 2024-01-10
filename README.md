# nostr-kt-relay

> Note: This project is currently under development.

A high-performance Kotlin-based relay server for the Nostr protocol, designed for scalability and efficient handling of
large-scale traffic.

## How to build and run

### Build a fat JAR

```shell
./gradlew buildFatJar
```

### Run a fat JAR

```shell
DB_URL=${DB_URL} DB_USER=${DB_USER} DB_PASSWORD=${DB_PASSWORD} ./gradlew runFatJar
```
