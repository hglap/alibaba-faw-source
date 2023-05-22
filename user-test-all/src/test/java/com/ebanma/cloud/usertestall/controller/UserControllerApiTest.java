package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = post("/api/user")
                .contentType("application/json;charset=UTF-8")
                .content("{\n"
                        +"      \"username\":\"username\",\n"
                        +"      \"password\":\"password\",\n"
                        +"      \"email\":\"123661231@qq.com\",\n"
                        +"      \"age\":25,\n"
                        +"      \"phone\":\"13977078880\",\n"
                        +"      \"version\":1\n"
                        + "}");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = put("/api/user/123")
                .contentType("application/json;charset=UTF-8")
                .content("{\n"
                        +"      \"username\":\"username\",\n"
                        +"      \"password\":\"password\",\n"
                        +"      \"email\":\"123661231@qq.com\",\n"
                        +"      \"age\":25,\n"
                        +"      \"phone\":\"13977078880\",\n"
                        +"      \"version\":1\n"
                        + "}");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    @Test
    public void testDelete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = delete("/api/user/121321");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    public void testQuery() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = get("/api/user");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }
}