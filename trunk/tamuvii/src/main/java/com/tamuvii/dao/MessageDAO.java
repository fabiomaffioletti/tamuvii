package com.tamuvii.dao;

import com.tamuvii.model.Message;
import com.tamuvii.model.MessageExample;
import java.util.List;

public interface MessageDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int countByExample(MessageExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int deleteByExample(MessageExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(Integer message);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    void insert(Message record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    void insertSelective(Message record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    List selectByExample(MessageExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    Message selectByPrimaryKey(Integer message);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(Message record, MessageExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int updateByExample(Message record, MessageExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(Message record);
}