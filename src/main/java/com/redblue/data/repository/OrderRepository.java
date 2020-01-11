package com.redblue.data.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.redblue.data.entity.Order;
 
 
@Mapper
public interface OrderRepository extends BaseMapper<Order> {
	@Select("select max(id) from t_order")
	public Integer getMaxOrderId();
}