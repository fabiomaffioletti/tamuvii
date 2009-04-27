//package com.tamuvii.eventdispatcher.listener;
//
//import java.util.Calendar;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import com.tamuvii.eventdispatcher.AmadeusEvent;
//import com.tamuvii.eventdispatcher.AmadeusListenerAbs;
//
//
//public class LoggerListener extends AmadeusListenerAbs {
//    protected transient final Log log = LogFactory.getLog(getClass());
//    private LoggerManager loggerManager = null;
//
//	public void setLoggerManager(LoggerManager loggerManager) {
//		this.loggerManager = loggerManager;
//	}
//
//	public void onManagedEvent(AmadeusEvent event) {
//		
//		String message=(String) event.getEventProperty("message");
//		Registration registration=(Registration) event.getEventProperty("registration");
//		AmadeusUser user=(AmadeusUser) event.getEventProperty("user");
//		String contractId = (String) event.getEventProperty("contractId");
//		String IdHistory = (String) event.getEventProperty("IdHistory");
//		String idhol = (String) event.getEventProperty("idhol");
//		String idcli = (String) event.getEventProperty("idcli");
//		
//		String logline=message+" [";
//		if (user!=null) {
//			logline+="user{";
//			logline+="name:"+user.getUsername()+" ";
//			logline+="} ";
//		}
//		if (registration!=null) {
//			logline+="registration{";
//			logline+="idhol:"+registration.getCustomer().getIdhol()+" ";
//			logline+="idcli:"+registration.getCustomer().getIdcli()+" ";
//			logline+="branches:"+registration.getBranches().size()+" ";
//			logline+="} ";
//		}
//		if(contractId != null) {
//			logline+=contractId+" ";
//		}
//		if(IdHistory != null) {
//			logline+=IdHistory+" ";
//		}
//		if(idhol != null) {
//			logline+=idhol+" ";
//		}
//		if(idcli != null) {
//			logline+=idcli+" ";
//		}
//		
//		logline=logline.substring(0,logline.length()-1)+ "]";
//		
//		if(logline.length() > 255)
//			logline = logline.substring(0, 254);
//		
//		loggerManager.logData(Calendar.getInstance().getTime(), user == null ? "username vuoto" : user.getUsername(), logline);
//		
//		log.debug("--: LOGGER :-- "+logline);
//
//	}
//
//
//}
