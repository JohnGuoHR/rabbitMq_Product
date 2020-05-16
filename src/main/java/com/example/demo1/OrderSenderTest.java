package com.example.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend1() throws Exception {
        for (int i=0;i<10000;i++){
                insertElement(i);

        }
    }

    private void insertElement(int n) {
        Order order = new Order();
        order.setId("201809062009010001"+n);
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString().replaceAll("-",""));
        this.orderSender.send(order);
    }
}
