package com.example.test.serviceImpl;

import com.example.test.bean.SpendBean;
import com.example.test.mapper.SpendMapper;
import com.example.test.service.SpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendServiceImpl implements SpendService {

    @Autowired
    SpendMapper spendMapper;


    @Override
    public List<SpendBean> getAllSpend() {
        return spendMapper.getAllSpend();
    }

    @Override
    public int saveSpend(SpendBean spendBean) {
        int flag = spendMapper.saveSpend(spendBean);
        return flag;
    }

    @Override
    public int deleteSpend(int id) {
        int flag = spendMapper.deleteSpend(id);
        return flag;
    }

    @Override
    public int updateSpend(SpendBean spend) {
        int flag = spendMapper.updateSpend(spend);
        return flag;
    }

    @Override
    public SpendBean selectSpendById(int id) {
        return spendMapper.selectSpendById(id);
    }



}
