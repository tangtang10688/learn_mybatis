package com.tangtang.mybatisaction.mapper;

import com.tangtang.mybatisaction.model.SysUser;
//import com.tangtang.mybatisaction.model.SysRole;
import com.tangtang.mybatisaction.model.SysUser;
//import com.tangtang.mybatisaction.model.SysUserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<SysUser> selectAll();
}