package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.User;
import com.beerus.mapper.UserMapper;
import com.beerus.service.UserService;
import com.beerus.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 用户业务层实现类
 * @Date 2019/4/20
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 用户数据层
     */
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public User login(String code, String pwd) throws Exception {
        return userMapper.get_User(code, pwd);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updatePassword(Integer uId, String pwd) throws Exception {
        return userMapper.updatePwd(uId, pwd) > Mark.ERROR;
    }

    @Transactional(readOnly = true)
    public Page<User> list_FindAll(Map<String, Object> params) throws Exception {
        Page<User> page = new Page<User>();
        //设置页大小
        page.setPageSize((Integer) params.get("pageSize"));
        //获取总行数
        Integer count = userMapper.count_Row(params);
        //设置总行数
        page.setTotalCount(count == null ? 0 : count);
        //设置当前页码
        page.setCurrPageNo((((Integer) params.get("currPageNo")) - 1) * page.getPageSize());
        //设置总页码
        page.setTotalPage((page.getTotalCount() + page.getPageSize() - 1) / page.getPageSize());
        //重置页码
        params.put("currPageNo", page.getCurrPageNo());
        //设置查询数据
        page.setPages(userMapper.list_FindByFilterAndPage(params));
        return page;
    }

    @Transactional(readOnly = true)
    public User get_UserById(Integer id) throws Exception {
        return userMapper.get_UserById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delete_User(Integer id) throws Exception {
        //执行删除
        Integer delResult = userMapper.delete_User(id);
        return null != delResult && delResult > Mark.ERROR;
    }

    @Transactional(readOnly = true)
    public boolean checkUserCode(String code) throws Exception {
        Integer count = userMapper.count_ByCode(code);
        return null != count && count > Mark.ERROR;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean save_User(User user) throws Exception {
        Integer result = userMapper.save_User(user);
        if (result > 0)
            throw new RuntimeException("测试异常!");
        return null != result && result > Mark.ERROR;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean modify(User user) throws Exception {
        Integer result = userMapper.update_User(user);
        return null != result && result > Mark.ERROR;
    }
}
