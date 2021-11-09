package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Keyword;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {


    //新增种子关键字
    @RequestMapping("/addKeyword")
    public String addKeyword(
            @RequestParam("word") String word,
            Model model) {
        if (word != null) {
            Keyword keyword = new Keyword();
            keyword.setKeyword(word);
            model.addAttribute(keyword);
            return "listings";
        }
        return "index";
    }
}
