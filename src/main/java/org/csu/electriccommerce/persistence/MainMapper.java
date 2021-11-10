package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MainMapper {
    //void addKeyword(String keyword,String compword,Double compPower);

    void addHunhe(Hunhe hunhe);

    ArrayList<Hunhe> getcomp(String keyword);


    int getCount(String keyword);

    ArrayList<Hunhe> findComp(String keyword);


}
