package com.tamuvii.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table message
     *
     * @ibatorgenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table message
     *
     * @ibatorgenerated
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public MessageExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    protected MessageExample(MessageExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table message
     *
     * @ibatorgenerated
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return this;
        }

        public Criteria andMessageEqualTo(Integer value) {
            addCriterion("message =", value, "message");
            return this;
        }

        public Criteria andMessageNotEqualTo(Integer value) {
            addCriterion("message <>", value, "message");
            return this;
        }

        public Criteria andMessageGreaterThan(Integer value) {
            addCriterion("message >", value, "message");
            return this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(Integer value) {
            addCriterion("message >=", value, "message");
            return this;
        }

        public Criteria andMessageLessThan(Integer value) {
            addCriterion("message <", value, "message");
            return this;
        }

        public Criteria andMessageLessThanOrEqualTo(Integer value) {
            addCriterion("message <=", value, "message");
            return this;
        }

        public Criteria andMessageIn(List values) {
            addCriterion("message in", values, "message");
            return this;
        }

        public Criteria andMessageNotIn(List values) {
            addCriterion("message not in", values, "message");
            return this;
        }

        public Criteria andMessageBetween(Integer value1, Integer value2) {
            addCriterion("message between", value1, value2, "message");
            return this;
        }

        public Criteria andMessageNotBetween(Integer value1, Integer value2) {
            addCriterion("message not between", value1, value2, "message");
            return this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return this;
        }

        public Criteria andSenderIn(List values) {
            addCriterion("sender in", values, "sender");
            return this;
        }

        public Criteria andSenderNotIn(List values) {
            addCriterion("sender not in", values, "sender");
            return this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return this;
        }

        public Criteria andReceiverIn(List values) {
            addCriterion("receiver in", values, "receiver");
            return this;
        }

        public Criteria andReceiverNotIn(List values) {
            addCriterion("receiver not in", values, "receiver");
            return this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return this;
        }

        public Criteria andMessagetextIsNull() {
            addCriterion("message_text is null");
            return this;
        }

        public Criteria andMessagetextIsNotNull() {
            addCriterion("message_text is not null");
            return this;
        }

        public Criteria andMessagetextEqualTo(String value) {
            addCriterion("message_text =", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextNotEqualTo(String value) {
            addCriterion("message_text <>", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextGreaterThan(String value) {
            addCriterion("message_text >", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextGreaterThanOrEqualTo(String value) {
            addCriterion("message_text >=", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextLessThan(String value) {
            addCriterion("message_text <", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextLessThanOrEqualTo(String value) {
            addCriterion("message_text <=", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextLike(String value) {
            addCriterion("message_text like", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextNotLike(String value) {
            addCriterion("message_text not like", value, "messagetext");
            return this;
        }

        public Criteria andMessagetextIn(List values) {
            addCriterion("message_text in", values, "messagetext");
            return this;
        }

        public Criteria andMessagetextNotIn(List values) {
            addCriterion("message_text not in", values, "messagetext");
            return this;
        }

        public Criteria andMessagetextBetween(String value1, String value2) {
            addCriterion("message_text between", value1, value2, "messagetext");
            return this;
        }

        public Criteria andMessagetextNotBetween(String value1, String value2) {
            addCriterion("message_text not between", value1, value2, "messagetext");
            return this;
        }

        public Criteria andDateaddedIsNull() {
            addCriterion("date_added is null");
            return this;
        }

        public Criteria andDateaddedIsNotNull() {
            addCriterion("date_added is not null");
            return this;
        }

        public Criteria andDateaddedEqualTo(Date value) {
            addCriterion("date_added =", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotEqualTo(Date value) {
            addCriterion("date_added <>", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedGreaterThan(Date value) {
            addCriterion("date_added >", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_added >=", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedLessThan(Date value) {
            addCriterion("date_added <", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedLessThanOrEqualTo(Date value) {
            addCriterion("date_added <=", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedIn(List values) {
            addCriterion("date_added in", values, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotIn(List values) {
            addCriterion("date_added not in", values, "dateadded");
            return this;
        }

        public Criteria andDateaddedBetween(Date value1, Date value2) {
            addCriterion("date_added between", value1, value2, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotBetween(Date value1, Date value2) {
            addCriterion("date_added not between", value1, value2, "dateadded");
            return this;
        }
    }
}