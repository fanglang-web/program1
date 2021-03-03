package com.example.test.service;

import com.example.test.bean.SpendBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpendService {



    List<SpendBean> getAllSpend();  //查询所有记录

    int saveSpend(SpendBean spend);  //新增

    int deleteSpend(int id);  //删除

    int updateSpend(SpendBean spend); //修改

    SpendBean selectSpendById(int id);  //根据id查询




}
