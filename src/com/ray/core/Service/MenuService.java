package com.ray.core.service;

import com.ray.core.model.Menu;

/**
 * Created by Administrator on 2017-05-07.
 */
public interface MenuService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    Menu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Menu record);
}
