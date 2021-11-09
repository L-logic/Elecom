package org.csu.electriccommerce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.electriccommerce.persistence")
public class ElectriccommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectriccommerceApplication.class, args);
    }

}
