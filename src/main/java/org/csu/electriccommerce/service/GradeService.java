package org.csu.electriccommerce.service;

import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.persistence.GradeMapper;
import org.csu.electriccommerce.persistence.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeService {

    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    MainMapper mainMapper;

    public ArrayList<Grade> getRateData(String keyword){
        ArrayList<Grade> data = new ArrayList<>();
        ArrayList<Hunhe> b = mainMapper.findComp(keyword);

        for (int i = 0; i < b.size(); i++) {
            Grade gd = new Grade();
            gd.setSequence(i);
            gd.setCompkey(b.get(i).getCompkey());
            gd.setMidkey(b.get(i).getMidkey());
            gd.setCompPower(b.get(i).getCompPower());
            if (gradeMapper.getGrade(keyword,gd.getCompkey()) == null){
                gd.setSatisfaction(3);
            }else {
                gd.setSatisfaction(gradeMapper.getGrade(keyword,gd.getCompkey()).getSatisfaction());
            }
            data.add(gd);
        }
        return data;
    }

    public void addGrade(Hunhe hunhe, float grade){
        gradeMapper.addGrace(hunhe,grade);
    }
}
