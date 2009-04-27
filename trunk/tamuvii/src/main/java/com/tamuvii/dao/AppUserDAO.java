package com.tamuvii.dao;

import com.tamuvii.model.AppUser;
import com.tamuvii.model.AppUserExample;
import java.util.List;

public interface AppUserDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int countByExample(AppUserExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int deleteByExample(AppUserExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	void insert(AppUser record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	void insertSelective(AppUser record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	List selectByExample(AppUserExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	AppUser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int updateByExampleSelective(AppUser record, AppUserExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int updateByExample(AppUser record, AppUserExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeySelective(AppUser record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table app_user
	 * @ibatorgenerated
	 */
	int updateByPrimaryKey(AppUser record);
}