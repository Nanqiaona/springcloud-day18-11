package com.bw.service;

import com.bw.dao.OrderRepository;
import com.bw.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService{
    List<Order> getlist(Map map);

    boolean save(Order order);

    boolean deleteById(Integer id);

    boolean deleteAll(Integer[] ids);

    Order get(Integer id);
}
