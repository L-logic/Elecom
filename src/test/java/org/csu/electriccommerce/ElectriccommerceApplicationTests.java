package org.csu.electriccommerce;

import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElectriccommerceApplicationTests {
    @Autowired
    MainService mainService;

    @Test
    void contextLoads() {
    }

    @Test
    void getcw(){
        Keyword baby = mainService.searchcompword("宝宝");
    }

    @Test
    void getcount(){
        mainService.getCount("冰箱");
    }

}
