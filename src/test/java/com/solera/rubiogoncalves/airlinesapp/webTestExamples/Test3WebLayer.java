package com.solera.rubiogoncalves.airlinesapp.webTestExamples;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solera.rubiogoncalves.airlinesapp.examples.HomeController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * We can narrow the tests to only the web layer by using @WebMvcTest,
 * as the following listing shows:
 *
 * The test assertion is the same as in Test2WebApplication.
 * However, in this test, Spring Boot instantiates only
 * the web layer rather than the whole context.
 * In an application with multiple controllers,
 * you can even ask for only one to be instantiated by using, for example:
 */
@WebMvcTest(HomeController.class)
//tag::test[]
public class Test3WebLayer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/HomeController"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello from HomeController")));
    }
}
//end::test[]
