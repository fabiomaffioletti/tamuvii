package com.tamuvii.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.tamuvii.dao.GenreDao;
import com.tamuvii.dao.hibernate.GenericDaoHibernate;
import com.tamuvii.model.Genre;

/**
 * DAO for table: Genre.
 * @author autogenerated
 */
@Repository
public class GenreDaoImpl extends GenericDaoHibernate<Genre, Serializable> implements GenreDao {
	
	/** Constructor method. */
		public GenreDaoImpl() {
			super(Genre.class);
		}
	}

