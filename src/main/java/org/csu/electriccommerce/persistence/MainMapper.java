package org.csu.electriccommerce.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.electriccommerce.entity.Keyword;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMapper {
    void addKeyword();
}
