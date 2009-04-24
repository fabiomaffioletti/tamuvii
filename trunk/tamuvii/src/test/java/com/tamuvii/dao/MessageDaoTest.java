package com.tamuvii.dao;

import java.util.Calendar;

import com.tamuvii.model.Message;

public class MessageDaoTest extends BaseDaoTestCase {
	private MessageDAO messageDao = null;

	public void setMessageDao(MessageDAO messageDao) {
		this.messageDao = messageDao;
	}


	public void testUpdate() {
		Message message = new Message();
		message.setDateadded(Calendar.getInstance().getTime());
		message.setSender("user");
		message.setReceiver("admin");
		message.setMessagetext("ciao");
		messageDao.insertSelective(message);
	}

}