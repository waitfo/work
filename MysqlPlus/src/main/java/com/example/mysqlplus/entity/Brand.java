package com.example.mysqlplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Integer id;
    private String name;
    private String firstChar;
}
