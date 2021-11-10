package org.csu.electriccommerce.persistence;

import org.csu.electriccommerce.entity.CompwordSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompwordMapper {

    void insertCompwordSet(CompwordSet compwordSet);

    /**
     * 删除一组结果
     * @param keyword
     */
    void deleteCompwordSet(String keyword);

    /**
     * 用id更新
     * @param compwordSet
     */
    void updateCompwordSet(CompwordSet compwordSet);

    /**
     * 得到一个种子关键字的一组list
     * @return
     */
    List<CompwordSet> getSetList(String keyword);

    /**
     * 根据id得到set
     * @param id
     * @return
     */
    CompwordSet getSetById(int id);

    /**
     * 根据一对关键词-竞争关键词唯一确定
     * @param keyword
     * @param compword
     * @return
     */
    CompwordSet getSetByKeyAndComp(String keyword, String compword);

    /**
     * 得到所有种子关键字的list
     * @return
     */
    List<String> getKeywordList();
}
