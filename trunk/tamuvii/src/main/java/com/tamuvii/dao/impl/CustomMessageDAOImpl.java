package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomMessageDAO;
import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.pojo.queryfilter.MessageUserFilter;

public class CustomMessageDAOImpl extends SqlMapClientDaoSupport implements CustomMessageDAO {
	
	public CustomMessageDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<MessageUserItem> getGroupedMessagesByUser(String username) {
		return getSqlMapClientTemplate().queryForList("custom_message.getGroupedMessagesByUser", username);
	}

	@SuppressWarnings("unchecked")
	public List<MessageUserItem> getInMessagesByUser(String username) {
		return getSqlMapClientTemplate().queryForList("custom_message.getInMessagesByUser", username);
	}

	@SuppressWarnings("unchecked")
	public List<MessageUserItem> getConversationWithUser(MessageUserFilter messageUserFilter) {
		return getSqlMapClientTemplate().queryForList("custom_message.getConversationWithUser", messageUserFilter);
	}

}