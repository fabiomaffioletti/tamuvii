package com.tamuvii.dao.ibatis;

import java.util.List;

import com.tamuvii.dao.LookupDao;
import com.tamuvii.model.Role;

/**
 * iBatis implementation of LookupDao.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDaoiBatis extends UniversalDaoiBatis implements LookupDao {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        log.debug("Retrieving all role names...");

        return getSqlMapClientTemplate().queryForList("LookupSQL.getRoles", null);
    }
}
