package com.redblue.data;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.redblue.data.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@MapperScan("com.redblue.data.repository")
@Slf4j
class DemoShardingsphereApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
		log.info("orderService.getMaxOrderId(): " + orderService.getMaxOrderId());
	}

}
