package com.solera.rubiogoncalves.airlinesapp.webTestExamples;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * It is nice to have a sanity check, but you should also
 * write some tests that assert the behavior of your application.
 * To do that, you could start the application and listen for a connection
 * (as it would do in production) and then send an HTTP request and assert the response.
 * The following listing shows how to do so:
 *
 * Note the use of webEnvironment=RANDOM_PORT to start the server
 * with a random port (useful to avoid conflicts in test environments)
 * and the injection of the port with @LocalServerPort.
 * Also, note that Spring Boot
 * has automatically provided a TestRestTemplate for you.
 * All you have to do is add @Autowired to it.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Test1HttpRequest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/HomeController",
                        String.class)
        ).contains("Hello from HomeController");
    }
}
