package org.csu.electriccommerce.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.persistence.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public Keyword search(){

        return null;
    }

}
