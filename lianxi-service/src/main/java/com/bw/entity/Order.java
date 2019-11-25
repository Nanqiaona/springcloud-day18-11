package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer num;
    private String pic;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatetime;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "mid")
    private People people;
}
