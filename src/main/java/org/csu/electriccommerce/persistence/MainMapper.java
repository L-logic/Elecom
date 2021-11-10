package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.entity.Keyword;
import org.springframework.stereotype.Repository;


@Repository
public interface MainMapper {
    void addKeyword(String keyword,String compword);

    void addHunhe(Hunhe hunhe);

    Keyword getcomp(String keyword);

}
