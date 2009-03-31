package com.tamuvii.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.tamuvii.dao.OpinionDao;
import com.tamuvii.dao.hibernate.GenericDaoHibernate;
import com.tamuvii.model.Opinion;

/**
 * DAO for table: Opinion.
 * @author autogenerated
 */
@Repository
public class OpinionDaoImpl extends GenericDaoHibernate<Opinion, Serializable> implements OpinionDao {
	
	/** Constructor method. */
		public OpinionDaoImpl() {
			super(Opinion.class);
		}
	}
