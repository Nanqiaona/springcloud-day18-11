package com.bw.test;

import com.bw.dao.OrderRepository;
import com.bw.dao.PeopleRepository;
import com.bw.entity.Order;
import com.bw.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void getlist(){
        List<Order> all = orderRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void save(){
        People people = new People();
        people.setMname("张三");
        peopleRepository.save(people);

        Order order = new Order();
        order.setName("泡芙");
        order.setNum(2);
        order.setPeople(people);
        order.setCreatetime(new Date());
        order.setPrice(11.11);
        orderRepository.save(order);
    }
}
