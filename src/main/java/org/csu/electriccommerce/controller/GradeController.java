package org.csu.electriccommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.csu.electriccommerce.entity.CompkeyAndGrade;
import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Rate;
import org.csu.electriccommerce.service.GradeService;
import org.csu.electriccommerce.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private MainService mainService;

    @RequestMapping("/addGrade")
    public void addGrade(@RequestParam("value") float value , Model model ){

    }

    @RequestMapping("/goTable")
    public String goTable(@RequestParam("word") String word,Model model){
        ArrayList<Hunhe> arrayList = mainService.findComp(word);
        model.addAttribute("word",word);
        model.addAttribute("arrayList",arrayList);
        return "page/table";
    }

    @RequestMapping("/setGrade")
    @ResponseBody
    public Rate setGrade(@RequestParam("word") String word){
        Rate rate = new Rate();
        if (word != null){
            rate.setCode(0);
            ArrayList<Grade> data = gradeService.getRateData(word);
            rate.setData(data);
            rate.setCount(data.size());
        }
        return rate;
    }

    @RequestMapping("/setLine")
    @ResponseBody
    public ArrayList<CompkeyAndGrade> setLine(@RequestParam("word") String word){
        ArrayList<CompkeyAndGrade> data = gradeService.getTopFiveGrade(word);
        return data;
    }
}
