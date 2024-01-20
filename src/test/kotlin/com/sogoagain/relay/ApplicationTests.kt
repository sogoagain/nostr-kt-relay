package com.sogoagain.relay

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.plugins.websocket.*
import io.ktor.server.testing.*
import io.ktor.websocket.*

class ApplicationTests : DescribeSpec({
    describe("Application") {
        describe("configureSockets()") {
            describe("/ws") {
                it("echo message") {
                    testApplication {
                        val client = createClient {
                            install(WebSockets)
                        }
                        client.webSocket("/ws") {
                            send(Frame.Text("Hello World!"))
                            (incoming.receive() as Frame.Text).readText() shouldBe "YOU SAID: Hello World!"
                            send(Frame.Text("bye"))
                            (incoming.receive() as Frame.Text).readText() shouldBe "YOU SAID: bye"
                        }
                    }
                }
            }
        }
    }
})
