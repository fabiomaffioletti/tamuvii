package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.Shelf;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;
import com.tamuvii.pojo.queryfilter.ShelfItemFilter;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.util.TamuviiConstants;

public class ShelfManagerImpl implements ShelfManager {
	private CustomShelfDAO customShelfDao = null;
	
	public void setCustomShelfDao(CustomShelfDAO customShelfDao) {
		this.customShelfDao = customShelfDao;
	}


	public List<ShelfDirectorReport> getShelfDirectorReport(String username, Integer from, Integer to, String orderAttribute) {
		ShelfDirectorReportFilter sdrf = new ShelfDirectorReportFilter();
		sdrf.setUsername(username);
		sdrf.setFrom(from);
		sdrf.setTo(to);
		sdrf.setOrderAttribute(orderAttribute);
		
		return customShelfDao.getShelfDirectorReport(sdrf);
	}


	public List<ShelfItem> getShelfByFilter(String username, Integer director, String orderAttribute, String orderCriteria, Integer page) throws Exception {
		try {
			ShelfItemFilter sif = new ShelfItemFilter();
			sif.setUsername(username);
			sif.setDirector(director);
			sif.setOrderAttribute(orderAttribute != null ? orderAttribute : TamuviiConstants.MOVIES_DEFAULT_ORDER_ATTRIBUTE );
			sif.setOrderCriteria(orderCriteria != null ? orderCriteria : TamuviiConstants.MOVIES_DEFAULT_ORDER);
			sif.setFrom(page*TamuviiConstants.MOVIES_PER_PAGE);
			sif.setTo(TamuviiConstants.MOVIES_PER_PAGE);
			return customShelfDao.getShelfByFilter(sif);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public Shelf getShelf(String username, Integer director, String orderAttribute, String orderCriteria, Integer page) throws Exception {
		try {
			Shelf s = new Shelf();
			ShelfItemFilter sif = new ShelfItemFilter();
			sif.setUsername(username);
			sif.setDirector(director);
			
			// Prendo il numero totale di film filtrati per username e regista
			s.setItemsSize((float) customShelfDao.getShelfCountByFilter(sif));
			
			// Continuo a riempire il filtro per l'ordinamento (il numero totale di film non cambia applicando solo un ordinamento)
			sif.setOrderAttribute(orderAttribute != null ? orderAttribute : TamuviiConstants.MOVIES_DEFAULT_ORDER_ATTRIBUTE );
			sif.setOrderCriteria(orderCriteria != null ? orderCriteria : TamuviiConstants.MOVIES_DEFAULT_ORDER);
			sif.setFrom(page*TamuviiConstants.MOVIES_PER_PAGE);
			sif.setTo(TamuviiConstants.MOVIES_PER_PAGE);
			
			// Riempio il bean con i dati relativi ai film filtrati
			s.setItems(customShelfDao.getShelfByFilter(sif));
			
			// Setto la pagina corrente
			s.setCurrentPage(page);
			return s;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	

}