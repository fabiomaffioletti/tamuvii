package com.tamuvii.service.impl;

import java.util.Date;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.dao.ConfigDAO;
import com.tamuvii.dao.InvitationDAO;
import com.tamuvii.dao.UserDAO;
import com.tamuvii.model.Invitation;
import com.tamuvii.model.User;
import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.events.TamuviiEventImpl;
import com.tamuvii.observer.subject.TamuviiSubject;
import com.tamuvii.service.CommunicationManager;
import com.tamuvii.util.MD5Utils;
import com.tamuvii.util.RequestUtils;

public class CommunicationManagerImpl extends ApplicationManager implements CommunicationManager {
	private TamuviiSubject tamuviiEventDispatcher = null;
	private UserDAO userDao = null;
	private InvitationDAO invitationDao = null;
	private ConfigDAO configDao = null;

	public void setConfigDao(ConfigDAO configDao) {
		this.configDao = configDao;
	}
	public void setTamuviiEventDispatcher(TamuviiSubject tamuviiEventDispatcher) {
		this.tamuviiEventDispatcher = tamuviiEventDispatcher;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void setInvitationDao(InvitationDAO invitationDao) {
		this.invitationDao = invitationDao;
	}
	
	
	
	public Integer sendCommunication(Long userid, String title, String text) {
		TamuviiEvent communicationEvent = new TamuviiEventImpl(EventType.COMMUNICATION, this);
		try {
			communicationEvent.setEventProperty("user", userDao.getUserById(userid));
			communicationEvent.setEventProperty("title", title);
			communicationEvent.setEventProperty("text", text);
			tamuviiEventDispatcher.notifyListeners(communicationEvent);
			return 0;
		} catch (Exception e) {
			log.error(e);
			return 1;
		}
	}
	
	
	public Integer sendInvitation(String invitedEmail) {
		User user = null;
		try {
			user = userDao.getUserByUsername(RequestUtils.getRequestUsername(null));
			
			// L'amministratore ha inviti illimitati
			if(RequestUtils.getIsUserInRole(user.getUsername(), ApplicationConstants.ROLE_ADMIN)) {
				Invitation invitation = new Invitation();
				invitation.setUser(user.getId());
				invitation.setUserEmail(user.getEmail());
				Date dateSent = new Date();
				invitation.setCode(MD5Utils.MD5(dateSent.toString()));
				invitation.setDateSent(dateSent);
				invitation.setInvitedEmail(invitedEmail);
				invitationDao.addInvitation(invitation);
				
				TamuviiEvent invitationEvent = new TamuviiEventImpl(EventType.INVITATION, this);
				invitationEvent.setEventProperty("invitation", invitation);
				invitationEvent.setEventProperty("user", user);
				invitationEvent.setEventProperty("invitedEmail", invitedEmail);
				invitationEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				tamuviiEventDispatcher.notifyListeners(invitationEvent);
				
				return 0;
			
				// L'utente semplice invece ha inviti limitati a INVITATIONS_PER_USER
			} else {
				if(invitationDao.getSentInvitationsCount(user.getId()) < configDao.getIntegerValueByKey(ApplicationConstants.INVITATIONS_PER_USER)) {
					Invitation invitation = new Invitation();
					invitation.setUser(user.getId());
					invitation.setUserEmail(user.getEmail());
					Date dateSent = new Date();
					invitation.setCode(MD5Utils.MD5(dateSent.toString()));
					invitation.setDateSent(dateSent);
					invitation.setInvitedEmail(invitedEmail);
					invitationDao.addInvitation(invitation);
					
					TamuviiEvent invitationEvent = new TamuviiEventImpl(EventType.INVITATION, this);
					invitationEvent.setEventProperty("invitation", invitation);
					invitationEvent.setEventProperty("user", user);
					invitationEvent.setEventProperty("invitedEmail", invitedEmail);
					invitationEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
					tamuviiEventDispatcher.notifyListeners(invitationEvent);
					
					return 0;
					
				} else {
					// L'utente ha raggiunto il limite di inviti
					return 2;
				}
			}
			
		} catch (Exception e) {
			log.error("Errore nel salvataggio dell'invito per l'utente con id: "+user.getId() + " per l'utente invitato: "+invitedEmail, e);
			return 1;
			
		}
		
	}
	
	
	
	public Invitation getInvitationByInvitedEmail(String invitedEmail) {
		return invitationDao.getInvitationByInvitedEmail(invitedEmail);
	}

}