package com.solera.rubiogoncalves.airlinesapp.webTestExamples;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solera.rubiogoncalves.airlinesapp.examples.GreetingController;
import com.solera.rubiogoncalves.airlinesapp.examples.GreetingService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Spring automatically injects the service dependency into the controller
 * (because of the constructor signature).
 * The following listing shows how to test this controller with @WebMvcTest:
 *
 * We use @MockBean to create and inject a mock
 * for the GreetingService (if you do not do so,
 * the application context cannot start),
 * and we set its expectations using Mockito.
 */
@WebMvcTest(GreetingController.class)
public class Test4WebMock {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/greetingController"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}
