package com.tamuvii.dao.impl;

import com.tamuvii.dao.MessageDAO;
import com.tamuvii.model.Message;
import com.tamuvii.model.MessageExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MessageDAOImpl extends SqlMapClientDaoSupport implements MessageDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public MessageDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int countByExample(MessageExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("message.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int deleteByExample(MessageExample example) {
        int rows = getSqlMapClientTemplate().delete("message.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int deleteByPrimaryKey(Integer message) {
        Message key = new Message();
        key.setMessage(message);
        int rows = getSqlMapClientTemplate().delete("message.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public void insert(Message record) {
        getSqlMapClientTemplate().insert("message.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public void insertSelective(Message record) {
        getSqlMapClientTemplate().insert("message.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public List selectByExample(MessageExample example) {
        List list = getSqlMapClientTemplate().queryForList("message.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public Message selectByPrimaryKey(Integer message) {
        Message key = new Message();
        key.setMessage(message);
        Message record = (Message) getSqlMapClientTemplate().queryForObject("message.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int updateByExampleSelective(Message record, MessageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("message.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int updateByExample(Message record, MessageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("message.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKeySelective(Message record) {
        int rows = getSqlMapClientTemplate().update("message.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKey(Message record) {
        int rows = getSqlMapClientTemplate().update("message.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table message
     *
     * @ibatorgenerated
     */
    private static class UpdateByExampleParms extends MessageExample {
        private Object record;

        public UpdateByExampleParms(Object record, MessageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}