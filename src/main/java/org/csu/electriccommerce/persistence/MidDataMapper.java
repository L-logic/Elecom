package org.csu.electriccommerce.persistence;

import org.springframework.stereotype.Repository;

@Repository
public interface MidDataMapper {

    public void insertWordApart(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7);

    public void insertFrequencis(String data, int s);

    public void insertMidKeyword(String keyword, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9);

    public void insertCompApart(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7);

    public void insertCompFrequencis(String data, int s);

    public void deleteWordApart();

    public void deleteFrequencis();

    public void deleteMidKeyword(String keyword);

    public void deleteCompApart();

    public void deleteCompFrequencis();

    public String selectMidKeyword(String keyword);

    public void insertRelated(String data);

    public void insertMidRelated(String data);

    public void deleteRelated();

    public void deleteMidRelated();
}
