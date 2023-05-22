package com.ebanma.cloud.demo.interactive.controller;

import com.ebanma.cloud.demo.interactive.validator.OrderRequestValidator;
import com.ebanma.cloud.demo.service.OrderApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderApplicationService orderApplicationService;

    @MockBean
    private OrderRequestValidator orderRequestValidator;

    @Test
    public void should_return_success_result_when_create_order_given_order_service_create() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = post("/orders")
                .contentType("application/json;charset=UTF-8")
                .content("{\n"
                        +"      \"orderNo\":\"orderNo\",\n"
                        +"      \"supplierId\":1,\n"
                        +"      \"address\":\"address\",\n"
                        +"      \"productId\":1,\n"
                        +"      \"orderAmountTotal\":100,\n"
                        +"      \"productCount\":100,\n"
                        +"      \"productAmountTotal\":200,\n"
                        +"      \"memberId\":1\n"
                        + "}");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("OK"));
    }

    @Test
    public void should_return_no_result_when_create_order_given_order_service_create() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = post("/orders")
                .contentType("application/json;charset=UTF-8")
                .content("{\n"
                        +"      \"orderNo\":\"orderNo\",\n"
                        +"      \"supplierId\":1,\n"
                        +"      \"address\":\"\",\n"
                        +"      \"productId\":1,\n"
                        +"      \"orderAmountTotal\":100,\n"
                        +"      \"productCount\":100,\n"
                        +"      \"productAmountTotal\":200,\n"
                        + "}");
        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }




}