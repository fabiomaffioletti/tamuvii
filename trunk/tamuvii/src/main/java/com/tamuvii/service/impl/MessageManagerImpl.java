package com.tamuvii.service.impl;

import java.util.Calendar;
import java.util.List;

import com.tamuvii.dao.CustomMessageDAO;
import com.tamuvii.dao.MessageDAO;
import com.tamuvii.model.Message;
import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.pojo.queryfilter.MessageUserFilter;
import com.tamuvii.service.MessageManager;

public class MessageManagerImpl implements MessageManager {
	private CustomMessageDAO customMessageDao = null;
	private MessageDAO messageDao = null;
	
	public void setMessageDao(MessageDAO messageDao) {
		this.messageDao = messageDao;
	}
	public void setCustomMessageDao(CustomMessageDAO customMessageDao) {
		this.customMessageDao = customMessageDao;
	}



	public List<MessageUserItem> getGroupedMessagesByUser(String username) {
		return customMessageDao.getGroupedMessagesByUser(username);
	}

	public List<MessageUserItem> getInMessagesByUser(String username) {
		return customMessageDao.getInMessagesByUser(username);
	}

	public List<MessageUserItem> getConversationWithUser(String remoteUser, String username) {
		MessageUserFilter messageUserFilter = new MessageUserFilter();
		messageUserFilter.setRemoteUser(remoteUser);
		messageUserFilter.setUsername(username);
		return customMessageDao.getConversationWithUser(messageUserFilter);
	}



	public void sendPersonalMessage(String remoteUser, String receiver, String messagetext) {
		Message message = new Message();
		message.setDateadded(Calendar.getInstance().getTime());
		message.setSender(remoteUser);
		message.setReceiver(receiver);
		message.setMessagetext(messagetext);
		messageDao.insertSelective(message);
	}
	
	public boolean sendPersonalMessageDWR(String remoteUser, String receiver, String messagetext) {
		try {
			Message message = new Message();
			message.setDateadded(Calendar.getInstance().getTime());
			message.setSender(remoteUser);
			message.setReceiver(receiver);
			message.setMessagetext(messagetext);
			messageDao.insertSelective(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}