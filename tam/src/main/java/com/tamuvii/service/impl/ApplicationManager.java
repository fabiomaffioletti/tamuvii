package com.tamuvii.service.impl;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tamuvii.ApplicationConstants;

public abstract class ApplicationManager {
	protected final Log log = LogFactory.getLog(getClass());
	
	protected final SimpleDateFormat sdf = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
}
