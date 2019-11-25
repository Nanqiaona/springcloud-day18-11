package com.bw.controller;

import com.bw.entity.People;
import com.bw.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/getlist")
    public Page<People> getlist(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize){
        Page<People> getpeoplelist = peopleService.getpeoplelist(pageNum,pageSize);
        return getpeoplelist;
    }

    @RequestMapping("/get")
    public People get(Integer mid){
        People people = peopleService.get(mid);
        System.out.println("people"+people);
        return people;
    }

}
