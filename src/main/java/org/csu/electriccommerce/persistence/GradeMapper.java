package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GradeMapper {

    void addGrace(Hunhe hunhe, float grace);

    Grade getGrade(String keyword, String compkey);

    ArrayList<Float> findTopFiveGrade(String keyword, String compkey);
}
