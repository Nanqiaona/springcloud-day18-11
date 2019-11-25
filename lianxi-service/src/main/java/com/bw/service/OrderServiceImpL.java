package com.bw.service;

import com.bw.dao.OrderRepository;
import com.bw.entity.Order;
import jdk.nashorn.internal.runtime.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Component
public class OrderServiceImpL implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getlist(Map map) {
        System.out.println("map查询"+map);
        List<Order> all = orderRepository.findAll();
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> predicates= new ArrayList<>();
                if(!StringUtils.isEmpty(map.get("name"))){
                    Predicate name = cb.equal(root.get("name"), map.get("name"));
                    predicates.add(name);
                }
                Predicate[] predicatesArr = new Predicate[predicates.size()];
                predicatesArr= predicates.toArray(predicatesArr);
                Predicate predicate = cb.and(predicatesArr);
                return predicate;
            }
        };
        return orderRepository.findAll(specification);
    }

    @Override
    public boolean save(Order order) {
        orderRepository.save(order);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAll(Integer[] ids) {
        System.out.println(ids);
        for (Integer i=0;i<ids.length;i++){
            orderRepository.deleteById(ids[i]);
        }
        return true;
    }

    @Override
    public Order get(Integer id) {
        Optional<Order> byId = orderRepository.findById(id);
        return byId.get();
    }
}
