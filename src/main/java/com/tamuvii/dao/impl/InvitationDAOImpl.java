package com.tamuvii.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.InvitationDAO;
import com.tamuvii.model.Invitation;

public class InvitationDAOImpl extends SqlMapClientDaoSupport implements InvitationDAO {

	public Long addInvitation(Invitation invitation) {
		return (Long) getSqlMapClientTemplate().insert("invitation.addInvitation", invitation);
	}

	public Integer getSentInvitationsCount(Long id) {
		return (Integer) getSqlMapClientTemplate().queryForObject("invitation.getSentInvitationsCount", id);
	}

	public Invitation getInvitationByInvitedEmail(String invitedEmail) {
		return (Invitation) getSqlMapClientTemplate().queryForObject("invitation.getInvitationByInvitedEmail", invitedEmail);
	}

}