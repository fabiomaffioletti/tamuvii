package com.tamuvii.dao;

import com.tamuvii.model.Invitation;

public interface InvitationDAO {
	
	public Long addInvitation(Invitation invitation);
	
	public Integer getSentInvitationsCount(Long id);
	
	public Invitation getInvitationByInvitedEmail(String invitedEmail);

}