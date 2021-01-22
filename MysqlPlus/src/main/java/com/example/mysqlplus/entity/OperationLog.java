package com.example.mysqlplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {
    private Integer id;
    private String operateClass;
    private String operateMethod;
    private String returnClass;
    private String returnValue;
    private String operateUser;
    private String operateTime;
    private String paramAndValue;
    private Long costTime;
}
