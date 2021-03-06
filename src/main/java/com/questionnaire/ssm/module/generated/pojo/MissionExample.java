package com.questionnaire.ssm.module.generated.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MissionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mission
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mission
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mission
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public MissionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mission
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mission
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMissionIdIsNull() {
            addCriterion("mission_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionIdIsNotNull() {
            addCriterion("mission_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionIdEqualTo(Long value) {
            addCriterion("mission_id =", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotEqualTo(Long value) {
            addCriterion("mission_id <>", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThan(Long value) {
            addCriterion("mission_id >", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mission_id >=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThan(Long value) {
            addCriterion("mission_id <", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThanOrEqualTo(Long value) {
            addCriterion("mission_id <=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdIn(List<Long> values) {
            addCriterion("mission_id in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotIn(List<Long> values) {
            addCriterion("mission_id not in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdBetween(Long value1, Long value2) {
            addCriterion("mission_id between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotBetween(Long value1, Long value2) {
            addCriterion("mission_id not between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateIsNull() {
            addCriterion("mission_start_date is null");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateIsNotNull() {
            addCriterion("mission_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateEqualTo(Date value) {
            addCriterion("mission_start_date =", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateNotEqualTo(Date value) {
            addCriterion("mission_start_date <>", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateGreaterThan(Date value) {
            addCriterion("mission_start_date >", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("mission_start_date >=", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateLessThan(Date value) {
            addCriterion("mission_start_date <", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateLessThanOrEqualTo(Date value) {
            addCriterion("mission_start_date <=", value, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateIn(List<Date> values) {
            addCriterion("mission_start_date in", values, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateNotIn(List<Date> values) {
            addCriterion("mission_start_date not in", values, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateBetween(Date value1, Date value2) {
            addCriterion("mission_start_date between", value1, value2, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionStartDateNotBetween(Date value1, Date value2) {
            addCriterion("mission_start_date not between", value1, value2, "missionStartDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateIsNull() {
            addCriterion("mission_final_date is null");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateIsNotNull() {
            addCriterion("mission_final_date is not null");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateEqualTo(Date value) {
            addCriterion("mission_final_date =", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateNotEqualTo(Date value) {
            addCriterion("mission_final_date <>", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateGreaterThan(Date value) {
            addCriterion("mission_final_date >", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("mission_final_date >=", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateLessThan(Date value) {
            addCriterion("mission_final_date <", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateLessThanOrEqualTo(Date value) {
            addCriterion("mission_final_date <=", value, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateIn(List<Date> values) {
            addCriterion("mission_final_date in", values, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateNotIn(List<Date> values) {
            addCriterion("mission_final_date not in", values, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateBetween(Date value1, Date value2) {
            addCriterion("mission_final_date between", value1, value2, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andMissionFinalDateNotBetween(Date value1, Date value2) {
            addCriterion("mission_final_date not between", value1, value2, "missionFinalDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mission
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mission
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}