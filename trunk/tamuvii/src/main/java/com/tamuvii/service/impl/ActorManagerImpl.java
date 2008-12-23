package com.tamuvii.service.impl;

import com.tamuvii.dao.ActorDao;
import com.tamuvii.model.Actor;
import com.tamuvii.service.ActorManager;

public class ActorManagerImpl extends GenericManagerImpl<Actor, Integer> implements ActorManager {
	ActorDao actorDao;
	
	public ActorManagerImpl(ActorDao actorDao) {
		super(actorDao);
		this.actorDao = actorDao;
	}

}