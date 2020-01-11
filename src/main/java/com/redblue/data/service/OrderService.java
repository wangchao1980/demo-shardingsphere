package com.redblue.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.redblue.data.entity.Order;

@Service
public interface OrderService {

	public Integer getMaxOrderId();

	public Integer addOrder(Order order);

	public List<Order> getOrders();

	public Order getOrder(Integer id);

	public boolean deleteOne(Integer id);
}
