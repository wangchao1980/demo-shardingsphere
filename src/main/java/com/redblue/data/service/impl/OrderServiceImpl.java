package com.redblue.data.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.redblue.data.entity.Order;
import com.redblue.data.repository.OrderRepository;
import com.redblue.data.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderRepository orderRepository;

	@Override
	public Integer getMaxOrderId() {
		//设置从主库查询
		HintManager hintManager = HintManager.getInstance();
		hintManager.setMasterRouteOnly();
		return orderRepository.getMaxOrderId();
	}

	@Override
	public Integer addOrder(Order order) {
		return orderRepository.insert(order);
	}

	@Override
	public List<Order> getOrders() {
		return orderRepository.selectList(new QueryWrapper<>());
	}

	@Override
	public Order getOrder(Integer id) {
		return orderRepository.selectById(id);
	}

	@Override
	public boolean deleteOne(Integer id) {
		return orderRepository.deleteById(id) > 0;
	}

}
