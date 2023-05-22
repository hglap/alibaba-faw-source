package com.ebanma.cloud.demo.interactive.controller;

import com.ebanma.cloud.demo.domain.entity.Order;
import com.ebanma.cloud.demo.interactive.request.OrderCreateRequest;
import com.ebanma.cloud.demo.interactive.validator.OrderRequestValidator;
import com.ebanma.cloud.demo.service.OrderApplicationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerUnitTest {

    private OrderController orderController;

    @Mock
    private OrderApplicationService orderApplicationService;

    @Mock
    private OrderRequestValidator orderRequestValidator;

    @Before
    public void setUp() throws Exception {
         orderController = new OrderController(orderApplicationService,orderRequestValidator);
    }

    @Test
    public void should_invoke_order_service_to_create_order_given_validation_pass(){

        // given

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        // doNothing()是Mockito的方法，意思是什么都不做。
        // 即当调用OrderRequestValidator的validateCreate方法，入参为orderCreateRequest的时候什么都不做
        // 根据validateCreate方法可知，什么都不做即代表通过了。
        doNothing().when(orderRequestValidator).validateCreate(orderCreateRequest);

        // when
        orderController.create(orderCreateRequest);

        // then
        // 验证下执行OrderController的create方法时，有没有执行OrderApplicationService的create方法
        // OrderApplicationService的create方法方法的入参为任意，即不在意入参
        verify(orderApplicationService).create(any(Order.class));

    }


}