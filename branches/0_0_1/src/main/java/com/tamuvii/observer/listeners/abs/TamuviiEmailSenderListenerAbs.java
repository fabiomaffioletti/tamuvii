package com.tamuvii.observer.listeners.abs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.mail.SimpleMailMessage;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.mail.MailEngine;
import com.tamuvii.model.User;
import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;


public abstract class TamuviiEmailSenderListenerAbs extends TamuviiListenerAbs {
    protected MailEngine mailEngine;
    
	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	@SuppressWarnings("unchecked")
	public void onManagedEvent(TamuviiEvent event) {
		SimpleMailMessage msg = new SimpleMailMessage();
		User user = (User) event.getEventProperty("user");
		msg.setTo(user.getEmail());
		msg.setSentDate(new Date());
		Map model = new HashMap();
		model.put("appURL", event.getEventProperty("appURL"));
		
		if(event.getType().equals(EventType.FRIEND_ADDED)) {
			msg.setSubject(event.getEventProperty("first") + ApplicationConstants.FRIEND_ADDED_EMAIL_SUBJECT);
			model.put("user", user);
			model.put("first", event.getEventProperty("first"));
			mailEngine.sendMessage(msg, "friend_added.vm", model);
			
		} else if(event.getType().equals(EventType.NEARBY_ADDED)) {
			msg.setSubject(event.getEventProperty("first") + ApplicationConstants.NEARBIE_ADDED_EMAIL_SUBJECT);
			model.put("user", user);
			model.put("first", event.getEventProperty("first"));
			mailEngine.sendMessage(msg, "nearbie_added.vm", model);
			
		} else if(event.getType().equals(EventType.RELATIONSHIP_CHANGED)) {
			msg.setSubject(event.getEventProperty("first") + ApplicationConstants.RELATIONSHIP_CHANGED_EMAIL_SUBJECT);
			model.put("user", user);
			model.put("relationship", event.getEventProperty("relationship"));
			model.put("first", event.getEventProperty("first"));
			mailEngine.sendMessage(msg, "relationship_changed.vm", model);
			
		} else if(event.getType().equals(EventType.REVIEW_VOTED)) {
			if(event.getEventProperty("type").equals("positive")) {
				msg.setSubject(user.getUsername() + ApplicationConstants.REVIEW_VOTED_POSITIVE_EMAIL_SUBJECT);
				model.put("vote", "positivo");
			} else {
				msg.setSubject(user.getUsername() + ApplicationConstants.REVIEW_VOTED_NEGATIVE_EMAIL_SUBJECT);
				model.put("vote", "negativo");
			}
			model.put("user", user);
			model.put("movie", event.getEventProperty("movie"));
			mailEngine.sendMessage(msg, "review_voted.vm", model);
			
		} else if(event.getType().equals(EventType.OPINION_WROTE)) {
			msg.setSubject(user.getUsername() + ApplicationConstants.OPINION_WROTE_EMAIL_SUBJECT);
			model.put("writer", event.getEventProperty("writer"));
			model.put("user", user);
			model.put("movie", event.getEventProperty("movie"));
			mailEngine.sendMessage(msg, "opinion_wrote.vm", model);
			
		} else if(event.getType().equals(EventType.REGISTRATION_SUCCESS)) {
			msg.setSubject(user.getUsername() + ApplicationConstants.REGISTRATION_SUCCESS_EMAIL_SUBJECT);
			model.put("user", user);
			mailEngine.sendHtmlMessage(msg, "registration_success.vm", model);
			
		} else if(event.getType().equals(EventType.COMMUNICATION)) {
			msg.setSubject((String) event.getEventProperty("title"));
			model.put("user", user);
			model.put("text", (String) event.getEventProperty("text"));
			mailEngine.sendMessage(msg, "communication.vm", model);
			
		} else if(event.getType().equals(EventType.INVITATION)) {
			msg.setSubject(user.getUsername() + ApplicationConstants.INVITATION_SENT_EMAIL_SUBJECT);
			model.put("user", user);
			msg.setFrom((String) event.getEventProperty("invitedEmail"));
			mailEngine.sendMessage(msg, "invitation.vm", model);
			
		}
		
		log.debug("email sender listener called");
	}
	
}