package org.csu.electriccommerce.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.electriccommerce.entity.Grade;
import org.csu.electriccommerce.entity.Hunhe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GradeMapper {

    void addGrace(@Param("hunhe")Hunhe hunhe, @Param("grade")float grade);

    Grade getGrade(@Param("keyword")String keyword, @Param("compkey")String compkey);

    ArrayList<Float> findTopFiveGrade(@Param("keyword")String keyword,@Param("compkey") String compkey);
}
