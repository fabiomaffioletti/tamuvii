package com.tamuvii.dao;

import com.tamuvii.model.Visit;
import com.tamuvii.model.VisitExample;
import java.util.List;

public interface VisitDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int countByExample(VisitExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int deleteByExample(VisitExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(Integer visit);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    void insert(Visit record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    void insertSelective(Visit record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    List selectByExample(VisitExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    Visit selectByPrimaryKey(Integer visit);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(Visit record, VisitExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int updateByExample(Visit record, VisitExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(Visit record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table visit
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(Visit record);
}