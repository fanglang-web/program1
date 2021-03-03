package com.example.test.controller;


import com.example.test.bean.SpendBean;
import com.example.test.service.SpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpendController {

    @Autowired
    SpendService spendService;



    /***
     * 查询所有信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/showSpends")
    public String showSpends(ModelMap modelMap){
        List<SpendBean> spendList = spendService.getAllSpend();
        modelMap.addAttribute("spendList",spendList);
        return "spends";
    }

    @RequestMapping("/toAddSpend")
    public String add(){
        return "addSpend";
    }



    @RequestMapping("/addSpend")
    @ResponseBody
    public Map addSpend(SpendBean spendBean){
        int flag = spendService.saveSpend(spendBean);
        Map<String,Object> map = new HashMap<>();

        if(flag == 1){
            return map;
        }else {
            map.put("msg","新增用户失败");
            return map;
        }
    }


    /**
     * 根据id删除信息
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/deleteSpend+{id}")
    public String dropSpend(@PathVariable("id") Integer id, ModelMap modelMap){
        int flag = spendService.deleteSpend(id);
        List<SpendBean> spendList = spendService.getAllSpend();
        modelMap.addAttribute("spendList",spendList);
        if(flag == 1){
            return "Spends";
        }else {
            return "error";
        }
    }

    /***
     * 根据id查询信息
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/spend+{id}")
    public String findSpendById(@PathVariable("id") Integer id,ModelMap modelMap){
        SpendBean spendBean = spendService.selectSpendById(id);
        modelMap.addAttribute("spendBean",spendBean);
        return "spendInfo";
    }

    /***
     * 修改
     * @param spendBean
     * @return
     */
    @RequestMapping("/modifySpend")
    @ResponseBody
    public Map modifySpend(SpendBean spendBean){
        int flag = spendService.updateSpend(spendBean);
        Map<String,Object> map = new HashMap<>();
        if(flag == 1){
            map.put("msg","修改信息成功");
            return map;
        }else {
            map.put("msg","修改信息失败");
            return map;
        }
    }



}
