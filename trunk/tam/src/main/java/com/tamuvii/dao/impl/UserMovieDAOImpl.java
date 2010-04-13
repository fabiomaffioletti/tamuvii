package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.UserMovieDAO;
import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.ShelfItem;

public class UserMovieDAOImpl extends SqlMapClientDaoSupport implements UserMovieDAO {

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAll(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user_movie.getAll", queryMap);
	}
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAllShelf(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user_movie.getAllShelf", queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllShelfCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user_movie.getAllShelfCount", queryMap);
	}
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAllWishlist(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user_movie.getAllWishlist", queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllWishlistCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user_movie.getAllWishlistCount", queryMap);
	}

	@SuppressWarnings("unchecked")
	public ShelfItem getUserMovieByMovieId(Map queryMap) {
		return (ShelfItem) getSqlMapClientTemplate().queryForObject("user_movie.getUserMovieByMovieId", queryMap);
	}

	public void addUserMovie(UserMovie userMovie) {
		getSqlMapClientTemplate().insert("user_movie.addUserMovie", userMovie);
	}

	public void updateUserMovie(UserMovie userMovie) {
		getSqlMapClientTemplate().update("user_movie.updateUserMovie", userMovie);
	}

	public void deleteUserMovieById(Map queryMap) {
		getSqlMapClientTemplate().delete("user_movie.deleteUserMovieById", queryMap);
	}

	@SuppressWarnings("unchecked")
	public Map getShelfItemBelonging(Map queryMap) {
		return (Map) getSqlMapClientTemplate().queryForMap("user_movie.getShelfItemBelonging", queryMap, "movie");
	}
	@SuppressWarnings("unchecked")
	public Map getMovieItemBelonging(Map queryMap) {
		return (Map) getSqlMapClientTemplate().queryForMap("user_movie.getMovieItemBelonging", queryMap, "movie");
	}
	@SuppressWarnings("unchecked")
	public Integer getSingleMovieItemBelonging(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user_movie.getSingleMovieItemBelonging", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public void moveToShelf(Map queryMap) {
		getSqlMapClientTemplate().update("user_movie.moveToShelf", queryMap);
	}


}