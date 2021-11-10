package org.csu.electriccommerce.service;

import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.persistence.MainMapper;
import org.csu.electriccommerce.tool.company.NewCleanFileClass;
import org.csu.electriccommerce.tool.compkey.Algorithm;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public void addHunhe(Hunhe hunhe){
        mainMapper.addHunhe(hunhe);
    }

    public Keyword searchcompword(String keyword){

        Keyword kw = new Keyword();
        kw.setKeyword(keyword);
        PathClass pa = new PathClass();
        try {
            NewCleanFileClass.Clean(pa.wordInNew, pa.wordOut,10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num = 10;   //设定选取竞争关键字的个数

        try {
            new Algorithm().algorithm(kw,num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList compwords = kw.getCompkey();
        ArrayList comppoint = kw.getCompPoint();
        for (int i = 0; i < compwords.size(); i++) {
            mainMapper.addKeyword(kw.getKeyword(), (String) compwords.get(i));
        }
        Keyword cw = mainMapper.getcomp(kw.getKeyword());
    return cw;
    }

}
