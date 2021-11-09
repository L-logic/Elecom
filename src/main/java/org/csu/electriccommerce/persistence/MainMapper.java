package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.Keyword;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MainMapper {
    void addKeyword(String keyword,String compword);

    Keyword getcomp(String keyword);

}
