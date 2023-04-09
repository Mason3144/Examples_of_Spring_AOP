package com.aop.aop;

import com.aop.aop.order.*;
import com.aop.aop.order.Aspect5.LogAspect;
import com.aop.aop.order.Aspect5.TxAspect;
import com.aop.aop.order.Aspect6.Aspect6;
import com.aop.aop.order.Aspect6.TimeTracking;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Slf4j
@Import({Aspect6.class, TimeTracking.class})
public class AopTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo(){
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success(){
        orderService.orderItem("itemA");
    }

    @Test
    void exception(){
        assertThatThrownBy(()-> orderService.orderItem("ex")).isInstanceOf(IllegalStateException.class);
    }
}
