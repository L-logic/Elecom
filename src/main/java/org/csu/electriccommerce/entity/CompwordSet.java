package org.csu.electriccommerce.entity;

import lombok.Data;

@Data
public class CompwordSet {

    private int id;

    private String keyword;

    private String midkey;

    private String compkey;

    private double compPower;

    @Override
    public String toString() {
        return "CompwordSet{" +
                "id" +id + '\'' +
                "keyword" + keyword + '\'' +
                "midkey" + midkey + '\'' +
                "compkey" + compkey + '\'' +
                "compPower" + compPower + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMidkey() {
        return midkey;
    }

    public void setMidkey(String midkey) {
        this.midkey = midkey;
    }

    public String getCompkey() {
        return compkey;
    }

    public void setCompkey(String compkey) {
        this.compkey = compkey;
    }

    public double getCompPower() {
        return compPower;
    }

    public void setCompPower(double compPower) {
        this.compPower = compPower;
    }
}
