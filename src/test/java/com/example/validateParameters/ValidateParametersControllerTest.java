package com.example.validateParameters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ValidateParametersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception{
        mvc.perform(get("/validatePathVariable/3"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenRequestParametersIsInvalid_thenReturnsStatus400() throws Exception{
        mvc.perform(get("/validateRequestParameter")
                .param("param", "3"))
                .andExpect(status().isBadRequest());
    }
}
