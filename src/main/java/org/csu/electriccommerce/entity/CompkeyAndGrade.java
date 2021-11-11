package org.csu.electriccommerce.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CompkeyAndGrade {
    private String compkey;
    private ArrayList<Float> cpgrades;
}
