package com.beerus.service;

import com.beerus.entity.User;
import com.beerus.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 用户业务层
 * @Date 2019/4/20
 **/
public interface UserService {
    /**
     * 用户登录
     *
     * @param code 编码
     * @param pwd  密码
     * @return
     */
    User login(
            @Param("userCode") String code,
            @Param("password") String pwd) throws Exception;

    /**
     * 根据用户ID修改密码
     *
     * @param uId 用户ID
     * @param pwd 密码
     * @return
     */
    boolean updatePassword(
            @Param("id") Integer uId,
            @Param("userPassword") String pwd) throws Exception;

    /**
     * 分页查询所有用户
     *
     * @param params 条件
     * @return 分页工具类
     * @throws Exception
     */
    Page<User> list_FindAll(Map<String, Object> params) throws Exception;

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    User get_UserById(Integer id) throws Exception;

    /**
     * 根据ID删除用户
     * @param id 用户ID
     * @return 是否删除成功
     * @throws Exception
     */
    boolean delete_User(Integer id) throws Exception;

    /**
     * 根据用户编码查询编码是否存在
     *
     * @param code 用户编码
     * @return 是否存在
     * @throws Exception
     */
    boolean checkUserCode(@Param("userCode") String code) throws Exception;

    /**
     * 根据ID添加用户
     *
     * @param user 用户
     * @return 是否添加成功
     */
    boolean save_User(User user) throws Exception;

    /**
     * 根据ID修改用户
     * @param user 修改的用户
     * @return 是否修改成功
     * @throws Exception
     */
    boolean modify(User user)throws Exception;
}
