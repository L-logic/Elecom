package org.csu.electriccommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/link")
public class LinkController {

    @RequestMapping("/toIntroduction")
    public String toIntroduction()
    {
        return "page/introduction";
    }

    @RequestMapping("/toContact")
    public String toContact()
    {
        return "page/contact";
    }

    @RequestMapping("/toIndex")
    public String toIndex()
    {
        return "index";
    }
}
