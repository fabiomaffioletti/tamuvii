package com.tamuvii.eventdispatcher;

import java.util.List;

public interface TamuviiSubject {
	
	public void addListener(TamuviiListener listener);
	public void removeListener(TamuviiListener listener);
	public void notifyListeners(TamuviiEvent e) throws Exception;
	public void setListeners(List<TamuviiListener> listeners);
}
