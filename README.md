# nostr-kt-relay

## Overview
`nostr-kt-relay` is a Kotlin-based relay server for the Nostr protocol, focused on scalability and efficient traffic management.

> 🚧 It's in active development and may be unstable.

## NIPs
- [ ] NIP-01: [Basic protocol flow description](https://github.com/nostr-protocol/nips/blob/master/01.md)
- [ ] NIP-02: [Follow List](https://github.com/nostr-protocol/nips/blob/master/02.md)
- [ ] NIP-04: [Encrypted Direct Message](https://github.com/nostr-protocol/nips/blob/master/04.md)
- [ ] NIP-09: [Event Deletion](https://github.com/nostr-protocol/nips/blob/master/09.md)
- [ ] NIP-11: [Relay Information Document](https://github.com/nostr-protocol/nips/blob/master/11.md)
- [ ] NIP-12: [Generic Tag Queries](https://github.com/nostr-protocol/nips/blob/master/12.md)
- [ ] NIP-15: [Nostr Marketplace](https://github.com/nostr-protocol/nips/blob/master/15.md)
- [ ] NIP-28: [Public Chat](https://github.com/nostr-protocol/nips/blob/master/28.md)
- [ ] NIP-40: [Expiration Timestamp](https://github.com/nostr-protocol/nips/blob/master/40.md)
- [ ] NIP-42: [Authentication of clients to relays](https://github.com/nostr-protocol/nips/blob/master/42.md)
- [ ] NIP-45: [Event Counts](https://github.com/nostr-protocol/nips/blob/master/45.md)
- [ ] NIP-50: [Search Capability](https://github.com/nostr-protocol/nips/blob/master/50.md)

## Building and Running

### Build a fat JAR
```shell
./gradlew buildFatJar
```

### Run a fat JAR
```shell
DB_URL=${DB_URL} DB_USER=${DB_USER} DB_PASSWORD=${DB_PASSWORD} ./gradlew runFatJar
```
