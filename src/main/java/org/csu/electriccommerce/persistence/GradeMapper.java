package org.csu.electriccommerce.persistence;

import org.springframework.stereotype.Repository;

@Repository
public interface GradeMapper {

    void addGrace(String compword, float grace);

    float getgrade(String compword);

}
