package com.sogoagain.relay

import com.sogoagain.relay.plugins.configureRouting
import io.kotest.assertions.ktor.client.shouldHaveStatus
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*

class ApplicationTests : DescribeSpec({
    describe("Application") {
        describe("configureRouting()") {
            describe("GET /") {
                it("should return 'Hello World!'") {
                    testApplication {
                        application {
                            configureRouting()
                        }
                        client.get("/").apply {
                            this shouldHaveStatus HttpStatusCode.OK
                            bodyAsText() shouldBe "Hello World!"
                        }
                    }
                }
            }
        }
    }
})
