package com.tamuvii.dao;

import com.tamuvii.model.UserToMovie;
import com.tamuvii.model.UserToMovieExample;
import com.tamuvii.model.UserToMovieKey;
import java.util.List;

public interface UserToMovieDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int countByExample(UserToMovieExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int deleteByExample(UserToMovieExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int deleteByPrimaryKey(UserToMovieKey key);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	void insert(UserToMovie record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	void insertSelective(UserToMovie record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	List selectByExample(UserToMovieExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	UserToMovie selectByPrimaryKey(UserToMovieKey key);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int updateByExampleSelective(UserToMovie record, UserToMovieExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int updateByExample(UserToMovie record, UserToMovieExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeySelective(UserToMovie record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user_to_movie
	 * @ibatorgenerated
	 */
	int updateByPrimaryKey(UserToMovie record);
}