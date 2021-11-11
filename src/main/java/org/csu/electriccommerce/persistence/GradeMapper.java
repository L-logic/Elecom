package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeMapper {

    void addGrace(Hunhe hunhe, float grace);

    Grade getGrade(String keyword, String compkey);

}
