package com.bw.service;

import com.bw.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeopleService {
    Page<People> getpeoplelist(Integer pageNum,Integer pageSize);

    People get(Integer mid);
}
