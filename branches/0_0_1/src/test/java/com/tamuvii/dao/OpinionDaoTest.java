package com.tamuvii.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.model.Opinion;

public class OpinionDaoTest extends ApplicationTest {
	private OpinionDAO opinionDao = null;

	public void setOpinionDao(OpinionDAO opinionDao) {
		this.opinionDao = opinionDao;
	}
	
	

	@SuppressWarnings("unchecked")
	public void testGetOpinionsByReview() {
		Map queryMap = new HashMap();
		queryMap.put("reviewer", 4L);
		queryMap.put("movie", 1L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<Opinion> ops = opinionDao.getOpinionsByReview(queryMap);
		assertNotNull(ops);
		assertTrue(ops.size() == 3);
	}
	
}