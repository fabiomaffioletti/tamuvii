package com.tamuvii.service;

import com.tamuvii.model.Invitation;



public interface CommunicationManager {
	
	public Integer sendCommunication(Long userid, String title, String text);

	public Integer sendInvitation(String invitedEmail);
	
	public Invitation getInvitationByInvitedEmail(String invitedEmail);
	
}
