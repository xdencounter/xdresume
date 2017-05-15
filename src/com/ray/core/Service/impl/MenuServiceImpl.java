package com.ray.core.service.impl;

import com.ray.core.service.MenuService;
import com.ray.core.model.Menu;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-05-07.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }
}
