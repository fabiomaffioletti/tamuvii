package com.tamuvii.observer.subject;

import java.util.List;

import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.listeners.TamuviiListener;

public interface TamuviiSubject {
	
	public void addListener(TamuviiListener listener);
	public void removeListener(TamuviiListener listener);
	public void notifyListeners(TamuviiEvent e) throws Exception;
	public void setListeners(List<TamuviiListener> listeners);
}
