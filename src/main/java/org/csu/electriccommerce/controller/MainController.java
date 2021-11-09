package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.tool.company.NewCleanFileClass;
import org.csu.electriccommerce.tool.compkey.Algorithm;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/main")
public class MainController {


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
            model.addAttribute(keyword);
            return "page/listings";
        }
        return "index";
    }
}
