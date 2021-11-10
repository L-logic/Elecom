package org.csu.electriccommerce.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Keyword {
    private String keyword;
    private ArrayList<String> midkey;
    private ArrayList<String> compkey;
    private ArrayList<Double> compPower;

}
