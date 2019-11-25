package com.bw.service;

import com.bw.dao.PeopleRepository;
import com.bw.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class PeopleServiceImpL implements PeopleService{
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public Page<People> getpeoplelist(Integer pageNum,Integer pageSize) {
        Pageable pageable1 = PageRequest.of(pageNum-1, pageSize);
        Page<People> all = peopleRepository.findAll(pageable1);
        return all;
    }

    @Override
    public People get(Integer mid) {
        Optional<People> byId = peopleRepository.findById(mid);
        return byId.get();
    }
}
