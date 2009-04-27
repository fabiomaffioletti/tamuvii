package com.tamuvii.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.validation.BindException;

public class LoggingUtils {
	public static String stackTraceToString(Throwable e) {
		String retValue = null;
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			retValue = sw.toString();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (sw != null)
					sw.close();
			} catch (IOException ignore) {
			}
		}
		return retValue;
	}

	@SuppressWarnings("unchecked")
	public static void logRequestString(HttpServletRequest request, Log log) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("?");
		if (request.getParameterMap() != null) {
			Enumeration enumerator = request.getParameterNames();
			while (enumerator.hasMoreElements()) {
				String parName = (String) enumerator.nextElement();
				buffer.append(parName + "=" + request.getParameter(parName)
						+ "&");
			}
			log.debug("parameters:" + buffer.toString());
		}
	}

	public static void logErrors(BindException errors, Log log) {
		if (errors != null && errors.hasErrors()) {
			log.debug(errors.getMessage());
		}
	}
}
