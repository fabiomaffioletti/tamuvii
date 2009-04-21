package com.tamuvii.dao.impl;

import com.tamuvii.dao.UserToUserDAO;
import com.tamuvii.model.UserToUser;
import com.tamuvii.model.UserToUserExample;
import com.tamuvii.model.UserToUserKey;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserToUserDAOImpl extends SqlMapClientDaoSupport implements UserToUserDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public UserToUserDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int countByExample(UserToUserExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("user_to_user.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int deleteByExample(UserToUserExample example) {
        int rows = getSqlMapClientTemplate().delete("user_to_user.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int deleteByPrimaryKey(UserToUserKey key) {
        int rows = getSqlMapClientTemplate().delete("user_to_user.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public void insert(UserToUser record) {
        getSqlMapClientTemplate().insert("user_to_user.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public void insertSelective(UserToUser record) {
        getSqlMapClientTemplate().insert("user_to_user.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public List selectByExample(UserToUserExample example) {
        List list = getSqlMapClientTemplate().queryForList("user_to_user.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public UserToUser selectByPrimaryKey(UserToUserKey key) {
        UserToUser record = (UserToUser) getSqlMapClientTemplate().queryForObject("user_to_user.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int updateByExampleSelective(UserToUser record, UserToUserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user_to_user.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int updateByExample(UserToUser record, UserToUserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user_to_user.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKeySelective(UserToUser record) {
        int rows = getSqlMapClientTemplate().update("user_to_user.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKey(UserToUser record) {
        int rows = getSqlMapClientTemplate().update("user_to_user.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table user_to_user
     *
     * @ibatorgenerated
     */
    private static class UpdateByExampleParms extends UserToUserExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserToUserExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}