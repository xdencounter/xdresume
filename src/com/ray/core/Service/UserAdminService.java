package com.ray.core.service;

import com.ray.core.model.UserAdmin;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-05-14.
 */
public interface UserAdminService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    int insert(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    int insertSelective(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    UserAdmin selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserAdmin record);


    /**
     * 查找实体用户管理员
     * @param map
     * @return
     */
    UserAdmin findUserAdmin(Map map);

    /**
     * 查找角色权限菜单
     * @param
     * @return
     */
    List findMenuJurisdictionListByUser(Long userId);
}
