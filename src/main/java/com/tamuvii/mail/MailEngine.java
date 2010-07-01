package com.tamuvii.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailEngine {
	protected final transient Log log = LogFactory.getLog(getClass());
	private MailSender mailSender;
	private VelocityEngine velocityEngine;
	private String from;
	
	public void setFrom(String from) {
		this.from = from;
	}
	public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
    
    
    @SuppressWarnings("unchecked")
	public void sendMessage(SimpleMailMessage msg, String templateName, Map model) {
    	log.debug("Sending email with template: " + templateName + " to "+msg.getTo());
        String result = null;
        try {
        	if(msg.getFrom()==null)
        		msg.setFrom(from);
            result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, model);
            msg.setText(result);
            mailSender.send(msg);
            
        } catch (VelocityException e) {
            log.error("Errore nella preparazione del messaggio", e);
        } catch (MailException me) {
            log.error("Errore nell'invio dell'email", me);
        }
    }
    
    @SuppressWarnings("unchecked")
	public void sendHtmlMessage(SimpleMailMessage msg, String templateName, Map model) {
		try {
			log.debug("Start preparing a new html email...");
			log.debug("Recipients: "+ArrayUtils.toString(msg.getTo()));
			log.debug("Subject: "+msg.getSubject());
			MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(msg.getTo());
			if(msg.getFrom()==null)
        		helper.setFrom(from);
			helper.setSubject(msg.getSubject());

			model = model == null ? new HashMap() : model;
			String htmlText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, model);
			helper.setText(htmlText, true);

			((JavaMailSenderImpl) mailSender).send(message);
			log.debug("Email sent");
			
		} catch (Exception e) {
			log.error("Errore nella preparazione del messaggio html", e);
		}
	}

}