package com.ray.core.service.impl;

import com.ray.core.dao.UserAdminMapper;
import com.ray.core.model.UserAdmin;
import com.ray.core.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-05-14.
 */
@Service("userAdminService")
public class UserAdminServiceImpl implements UserAdminService {
    @Autowired
    private UserAdminMapper userAdminMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(UserAdmin record) {
        return 0;
    }

    @Override
    public int insertSelective(UserAdmin record) {
        return 0;
    }

    @Override
    public UserAdmin selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserAdmin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserAdmin record) {
        return 0;
    }

    @Override
    public UserAdmin findUserAdmin(Map map) {
        return userAdminMapper.findUserAdmin(map);
    }

    @Override
    public List findMenuJurisdictionListByUser(Long userId) {
        return userAdminMapper.findMenuJurisdictionListByUser(userId);
    }
}
