package com.tangtang.mybatisaction.mapper;



import com.tangtang.mybatisaction.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class SysUserMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

            SysUser sysUser = sysUserMapper.selectById(1L);
            Assert.assertNotNull(sysUser);

            Assert.assertEquals("admin", sysUser.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

            List<SysUser> sysUserList = sysUserMapper.selectAll();

            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            // 正常情况下应该读入一张图片保存到byte数组中
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());

            // 这里的返回值result是执行的SQL影响的行数
            int result = sysUserMapper.insert(sysUser);
            // 只插入1条数据
            Assert.assertEquals(1, result);
            // id为null,没有给id赋值，并且没有配置回写id的值
            Assert.assertNull(sysUser.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 默认的sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testInsertUseGeneratedKeys() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            // 正常情况下应该读入一张图片保存到byte数组中
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());

            // 这里的返回值result是执行的SQL影响的行数
            int result = sysUserMapper.insertUseGeneratedKeys(sysUser);
            // 只插入1条数据
            Assert.assertEquals(1, result);
            // 因为id回写,所以id不为null
            Assert.assertNotNull(sysUser.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
