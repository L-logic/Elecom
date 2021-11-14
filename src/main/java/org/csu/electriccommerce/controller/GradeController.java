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

import javax.servlet.http.HttpSession;
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
    public String goTable(@RequestParam("word") String word, Model model, HttpSession session){
        ArrayList<Hunhe> arrayList = mainService.findComp(word);
        model.addAttribute("word",word);
        session.setAttribute("arrayList",arrayList);
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

    @RequestMapping("/getGrade")
    public String getGrade(@RequestParam("xing0")String xing0,
                           @RequestParam("xing1")String xing1,
                           @RequestParam("xing2")String xing2,
                           @RequestParam("xing3")String xing3,
                           @RequestParam("xing4")String xing4,
                           @RequestParam("xing5")String xing5,
                           @RequestParam("xing6")String xing6,
                           @RequestParam("xing7")String xing7,
                           @RequestParam("xing8")String xing8,
                           @RequestParam("xing9")String xing9,
                           HttpSession session,
                           Model model){
        ArrayList<Hunhe> arrayList = (ArrayList<Hunhe>)session.getAttribute("arrayList");
        if (xing0!=null && xing1!=null && xing2!=null && xing3!=null&& xing4!=null&&
                xing5!=null&& xing6!=null&& xing7!=null&& xing8!=null&& xing9!=null){
            ArrayList<Float> xings = new ArrayList<>();
            xings.add(Float.parseFloat(xing0));
            xings.add(Float.parseFloat(xing1));
            xings.add(Float.parseFloat(xing2));
            xings.add(Float.parseFloat(xing3));
            xings.add(Float.parseFloat(xing4));
            xings.add(Float.parseFloat(xing5));
            xings.add(Float.parseFloat(xing6));
            xings.add(Float.parseFloat(xing7));
            xings.add(Float.parseFloat(xing8));
            xings.add(Float.parseFloat(xing9));

            for (int i = 0; i < arrayList.size(); i++) {
                gradeService.addGrade(arrayList.get(i),xings.get(i));
            }
        }
        model.addAttribute("word",arrayList.get(0).getKeyword());
        model.addAttribute("arrayList",arrayList);
        return "page/table";
    }
}
