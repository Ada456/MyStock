package com.ww.service.power;

import com.ww.dao.UserMapper;
import com.ww.entity.Page;
import com.ww.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsersByPage(String username,String logincode,Page page){

        //对查询条件进行封装
        Map<String,Object> search = new HashMap<>();
        search.put("username",username);
        search.put("logincode",logincode);
        search.put("page",page);

        List<User> userList = userMapper.selectUserListByPage(search);
        return  userList;
    }


    public User getUserById(int id) {
        // TODO: 2016/7/3 0003 检验用户id是否正确
        return userMapper.selectByPrimaryKey(id);
    }


    public int updateUserById(User user){

        // TODO: 2016/7/3 0003 利用返回值做判断 是否成功
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int addUser(User user){
        // TODO: 2016/7/3 0003 利用返回值做判断 是否成功
        return userMapper.insert(user);
    }

    public int deleteUserById(int userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }
}
