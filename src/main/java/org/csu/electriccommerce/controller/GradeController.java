package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Rate;
import org.csu.electriccommerce.service.GradeService;
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

    @RequestMapping("/addGrade")
    public void addGrade(@RequestParam("value") float value , Model model ){

    }

    @RequestMapping("/goTable")
    public String goTable(@RequestParam("word") String word,Model model){
        model.addAttribute("word",word);
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
}
