package com.ebanma.cloud.demo.interactive.validator;

import com.ebanma.cloud.demo.exception.BadRequestException;
import com.ebanma.cloud.demo.interactive.request.OrderCreateRequest;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


// 不加@RunWith(MockitoJUnitRunner.class) 注解，默认用junit的测试
// 测试的OrderRequestValidator类没有任何依赖，所以也不需要mock, 直接用junit即可
public class OrderRequestValidatorTest {

    private OrderRequestValidator orderRequestValidator;

    @Before
    public void setUp() throws Exception {
        orderRequestValidator = new OrderRequestValidator();
    }

    @Test
    public void testThrowException() {

        // given
        // 给定 订单金额大于产品金额
        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        orderCreateRequest.setOrderAmountTotal(new BigDecimal(100));
        orderCreateRequest.setProductAmountTotal(new BigDecimal(50));

        // when
        // Assertions是单测常用的断言框架
        // 上文给定 订单金额大于产品金额，故断言会抛异常
        AbstractThrowableAssert<?, ? extends Throwable> abstractThrowableAssert
                = Assertions.assertThatThrownBy(() -> orderRequestValidator.validateCreate(orderCreateRequest));

        // then
        // 看看异常是不是抛除了，如果抛出了，则测试通过了
        Assertions.assertThat(abstractThrowableAssert).isNotNull();
        // 比对异常类型
        abstractThrowableAssert.isInstanceOf(BadRequestException.class);
        abstractThrowableAssert.hasMessage("订单总价不能高于商品总价");
    }
}