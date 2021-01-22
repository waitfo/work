package com.example.mysqlplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private String title;
    private Double price;
    private Integer num;
    private String status;
    private String sellerid;
    private Date createtime;
    private Date updatetime;
}
