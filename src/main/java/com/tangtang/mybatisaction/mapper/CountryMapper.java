package com.tangtang.mybatisaction.mapper;

import com.tangtang.mybatisaction.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询全部国家
     *
     * @return
     */
    List<Country> selectAll();
}
