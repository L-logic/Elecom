package org.csu.electriccommerce.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Rate {
    private int code;
    private String meg;
    private int count;
    private ArrayList<Grade> data;
}
