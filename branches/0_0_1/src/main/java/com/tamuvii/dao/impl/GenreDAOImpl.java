package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.GenreDAO;
import com.tamuvii.model.Genre;

public class GenreDAOImpl extends SqlMapClientDaoSupport implements GenreDAO {

	@SuppressWarnings("unchecked")
	public List<Genre> getAll() {
		return getSqlMapClientTemplate().queryForList("genre.getAll");
	}

	@SuppressWarnings("unchecked")
	public List<Genre> getMovieGenres(Long id) {
		return getSqlMapClientTemplate().queryForList("genre.getMovieGenres", id);
	}

	public Genre getGenreByName(String name) {
		return (Genre) getSqlMapClientTemplate().queryForObject("genre.getGenreByName", name);
	}

	public Genre getGenreById(Long id) {
		return (Genre) getSqlMapClientTemplate().queryForObject("genre.getGenreById", id);
	}

	public void deleteMovieGenres(Long movie) {
		getSqlMapClientTemplate().delete("genre.deleteMovieGenres", movie);
	}

	public void addMovieGenre(Map queryMap) {
		getSqlMapClientTemplate().insert("genre.addMovieGenre", queryMap);
	}
	
}