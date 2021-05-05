## Micronaut Event Loop Issue

Example repository showing that @ExecuteOn is ignored for POST controllers

This seems to have been introduced between 2.3.4 and 2.4.0 and impacts all versions >= 2.4.0


---

## Replicating the issue:

- Start the application server using ./gradlew run  
- run the command `curl -v -X POST localhost:8080/loop -H "Content-Type: application/json" -d '{"test": "123" }'`
- Note log output of `default-nioEventLoopGroup-1-2` (or similar thread number)
- change the `micronautVersion` in gradle.properties to 2.3.4 and restart the app server
- run the above curl again and note log output of `io-executor-thread-1`

This example also includes a GET/PUT/DELETE controller as well showing that these are not impacted.

