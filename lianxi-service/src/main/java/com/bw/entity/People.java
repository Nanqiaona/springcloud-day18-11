package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;
    private String mname;

    @JsonIgnoreProperties(value = {"people"})
    @OneToMany(mappedBy = "people",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orderList;
}
