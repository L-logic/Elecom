package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.entity.Rate;
import org.csu.electriccommerce.service.GradeService;
import org.csu.electriccommerce.service.MainService;
import org.csu.electriccommerce.tool.company.NewCleanFileClass;
import org.csu.electriccommerce.tool.compkey.Algorithm;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;

    //新增种子关键字
    @RequestMapping("/addKeyword")
    public String addKeyword(
            @RequestParam("word") String word,
            Model model) {
        if (word != null) {
            System.out.println(word);
            Keyword keyword = new Keyword();
            keyword.setKeyword(word);
            ArrayList<Hunhe> arrayList = new ArrayList<>();
            ArrayList<String> midkey = new ArrayList<>();
            ArrayList<String> compkey = new ArrayList<>();
            ArrayList<Double> compPower = new ArrayList<>();
            //先判断数据库中有没有该词
            if (mainService.findComp(keyword.getKeyword()).size() == 10){
                for (int i = 0; i < 10; i++) {
                    Hunhe hunhe = mainService.findComp(keyword.getKeyword()).get(i);
                    arrayList.add(hunhe);
                    midkey.add(hunhe.getMidkey());
                    compkey.add(hunhe.getCompkey());
                    compPower.add(hunhe.getCompPower());
                }
                keyword.setMidkey(midkey);
                keyword.setCompkey(compkey);
                keyword.setCompPower(compPower);
            }else {
                PathClass pa = new PathClass();
                try {
                    NewCleanFileClass.Clean(pa.wordInNew, pa.wordOut,10);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int num = 10;   //设定选取竞争关键字的个数

                try {
                    new Algorithm().algorithm(keyword,num);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                for (int i = 0; i < keyword.getMidkey().size(); i++) {
                    Hunhe hunhe = new Hunhe();
                    hunhe.setKeyword(keyword.getKeyword());
                    hunhe.setMidkey(keyword.getMidkey().get(i));
                    hunhe.setCompkey(keyword.getCompkey().get(i));
                    hunhe.setCompPower(keyword.getCompPower().get(i));
                    if (mainService.findComp(keyword.getKeyword()).size() < 10){
                        mainService.addHunhe(hunhe);
                    }
                    arrayList.add(hunhe);
                }
            }

            System.out.println(arrayList);
            model.addAttribute(keyword);
            model.addAttribute("arrayList",arrayList);
            return "page/listings";
        }
        return "index";
    }

    @RequestMapping("/addAllKeyword")
    public String addAllKeyword(HttpServletRequest req,Model model){
//        System.out.println(count);
//        ArrayList<Keyword> keywordArrayList = new ArrayList<>();
//        for (int i = 0; i < count+1; i++) {
//            Keyword keyword = new Keyword();
//            if (i==0){
//                keyword.setKeyword(req.getParameter("aword"));
//                keywordArrayList.add(keyword);
//            }
//            String str = "aword"+i ;
//            keyword.setKeyword(req.getParameter(str));
//            keywordArrayList.add(keyword);
//        }
//        System.out.println(keywordArrayList);

        System.out.println(req.getQueryString());
        String[] list = req.getQueryString().split("&");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            String str = list[i].split("=")[1];
            String decodeFName = null;
            try {
                decodeFName = URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            strings.add(decodeFName);
        }
        System.out.println(strings);

        ArrayList<Keyword> keywordArrayList = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Keyword keyword = new Keyword();
            keyword.setKeyword(strings.get(i));
            keywordArrayList.add(keyword);
        }

        for(int i = 0; i < keywordArrayList.size(); i++) {

            Keyword keyword = keywordArrayList.get(i);
            ArrayList<String> midkey = new ArrayList<>();
            ArrayList<String> compkey = new ArrayList<>();
            ArrayList<Double> compPower = new ArrayList<>();
            //先判断数据库中有没有该词,如果有
            if (mainService.findComp(keyword.getKeyword()).size() == 10){
                for (int j = 0; j < 10; j++) {
                    Hunhe hunhe = mainService.findComp(keyword.getKeyword()).get(j);
                    midkey.add(hunhe.getMidkey());
                    compkey.add(hunhe.getCompkey());
                    compPower.add(hunhe.getCompPower());
                }
                keyword.setMidkey(midkey);
                keyword.setCompkey(compkey);
                keyword.setCompPower(compPower);
            }else {
                PathClass pa = new PathClass();
                try {
                    NewCleanFileClass.Clean(pa.wordInNew, pa.wordOut,10);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int num = 10;   //设定选取竞争关键字的个数

                try {
                    new Algorithm().algorithm(keyword,num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //插入数据库
                for (int k = 0; k < keyword.getMidkey().size(); k++) {
                    Hunhe hunhe = new Hunhe();
                    hunhe.setKeyword(keyword.getKeyword());
                    hunhe.setMidkey(keyword.getMidkey().get(k));
                    hunhe.setCompkey(keyword.getCompkey().get(k));
                    hunhe.setCompPower(keyword.getCompPower().get(k));
                    if (mainService.findComp(keyword.getKeyword()).size() < 10){
                        mainService.addHunhe(hunhe);
                    }
                }
            }
        }
        System.out.println(keywordArrayList);

        model.addAttribute("keywordArrayList",keywordArrayList);
        return "page/listings2";
    }

}
