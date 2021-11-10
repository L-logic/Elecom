package org.csu.electriccommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.csu.electriccommerce.controller.MainController;
import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.entity.Rate;
import org.csu.electriccommerce.persistence.GradeMapper;
import org.csu.electriccommerce.persistence.MainMapper;
import org.csu.electriccommerce.service.GradeService;
import org.csu.electriccommerce.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;

@SpringBootTest
class ElectriccommerceApplicationTests {
    @Autowired
    MainService mainService;
    @Autowired
    MainMapper mainMapper;
    @Autowired
    GradeService gradeService;
    @Autowired
    GradeMapper gradeMapper;

    @Test
    void contextLoads() {
    }

//    @Test
//    void getcw(){
//        ArrayList<Keyword> baby = mainService.searchcompword("宝宝");
//        for (int i = 0; i < baby.size(); i++) {
//            System.out.println(baby.get(i));
//        }
//    }

    @Test

    void Test1(){
//        Grade a = new Grade();
        ArrayList<Grade> b = new ArrayList<>();
        b = gradeService.getRateData("宝宝");

        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try {

            str = objectMapper.writeValueAsString(b);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    @Test
    void getcount(){
        mainService.getCount("冰箱");
    }

    @Test
    void a(){
        float a = gradeMapper.getgrade("牛奶");
        System.out.println(a);
    }
    @Test
    void Test2(){
        Rate rate = new Rate();
        rate.setCode(0);
        ArrayList<Grade> data = gradeService.getRateData("宝宝");
        rate.setData(data);
        rate.setCount(data.size());
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try {
            str = objectMapper.writeValueAsString(rate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
