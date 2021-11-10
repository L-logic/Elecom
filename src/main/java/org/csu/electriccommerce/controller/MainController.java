package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.service.MainService;
import org.csu.electriccommerce.tool.company.NewCleanFileClass;
import org.csu.electriccommerce.tool.compkey.Algorithm;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

            ArrayList<Hunhe> arrayList = new ArrayList<>();
            for (int i = 0; i < keyword.getMidkey().size(); i++) {
                Hunhe hunhe = new Hunhe();
                hunhe.setKeyword(keyword.getKeyword());
                hunhe.setMidkey(keyword.getMidkey().get(i));
                hunhe.setCompkey(keyword.getCompkey().get(i));
                hunhe.setCompPower(keyword.getCompPoint().get(i));
                mainService.addHunhe(hunhe);
                arrayList.add(hunhe);
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
        System.out.println(keywordArrayList);

        PathClass pa = new PathClass();

        try {
            NewCleanFileClass.Clean(pa.wordInNew, pa.wordOut,10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num = 10;   //设定选取竞争关键字的个数
        for(int i = 0; i < keywordArrayList.size(); i++) {
            try {
                new Algorithm().algorithm(keywordArrayList.get(i),num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("keywordArrayList",keywordArrayList);
        return "index";
    }

}
