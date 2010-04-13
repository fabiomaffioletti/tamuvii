package com.tamuvii.service;



public interface CommunicationManager {
	
	public Integer sendCommunication(Long userid, String title, String text);

	public Integer sendInvitation(String invitedEmail);
	
}
