package com.example.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpendBean {
    private int id;
    private double sancan;
    private double richang;
    private double chuandai;
    private double lingshi;
    private String remark;
    private String date;
}
