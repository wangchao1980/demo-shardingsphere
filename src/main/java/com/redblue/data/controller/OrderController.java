package com.redblue.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redblue.data.entity.Order;
import com.redblue.data.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/getMaxOrderId")
	public Object getMaxOrderId() {
		Integer id = orderService.getMaxOrderId();
		return id;
	}
	
	@GetMapping("/getOrders")
	public Object getOrders() {
		List<Order> list = orderService.getOrders();
		return list;
	}

	@GetMapping("/getOrder")
	public Object getOrder(@RequestParam Integer id) {
		Order order = orderService.getOrder(id);
		return order;
	}

	@GetMapping("/addOrders")
	public Object add() {
		int start = orderService.getMaxOrderId();
		log.info("start: " + start);
		for (int i = start + 1; i <= start + 50; i++) {
			Order order = new Order();
			order.setId(i);
			order.setName("name-" + i);
			order.setType(i%3 + "");
			long resutl = orderService.addOrder(order);
			log.info("insert:" + order.toString() + " result:" + resutl);
		}
		return "添加成功";
	}

	@GetMapping("/deleteOne")
	public Object deleteOne(@RequestParam Integer id) {
		orderService.deleteOne(id);
		return "删除成功！";
	}
}
