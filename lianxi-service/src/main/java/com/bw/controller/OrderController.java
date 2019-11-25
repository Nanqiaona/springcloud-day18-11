package com.bw.controller;

import com.bw.entity.Order;
import com.bw.entity.People;
import com.bw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getlist")
    public List<Order> getlist(Map map){
        List<Order> getlist = orderService.getlist(map);
        return getlist;
    }
    @RequestMapping("/save")
    public boolean save(@RequestBody Order order){
        People people = new People();
        people.setMid(2);
        order.setPeople(people);
        boolean b = orderService.save(order);
        return b;
    }
    @RequestMapping("/deleteById")
    public boolean save(Integer id){
        boolean b = orderService.deleteById(id);

        return b;
    }

    @RequestMapping("/deleteAll")
    public boolean save(Integer[] ids){
        boolean b = orderService.deleteAll(ids);
        return b;
    }

    @RequestMapping("/get")
    public Order get(Integer id){
        Order order = orderService.get(id);
        return order;
    }


}
