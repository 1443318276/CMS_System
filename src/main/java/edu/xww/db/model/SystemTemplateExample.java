package edu.xww.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemTemplateExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public SystemTemplateExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
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
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("template.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("template.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("template.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("template.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("template.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("template.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("template.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("template.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("template.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("template.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("template.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("template.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNull() {
            addCriterion("template.template_type is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNotNull() {
            addCriterion("template.template_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeEqualTo(String value) {
            addCriterion("template.template_type =", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotEqualTo(String value) {
            addCriterion("template.template_type <>", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThan(String value) {
            addCriterion("template.template_type >", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_type >=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThan(String value) {
            addCriterion("template.template_type <", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThanOrEqualTo(String value) {
            addCriterion("template.template_type <=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLike(String value) {
            addCriterion("template.template_type like", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotLike(String value) {
            addCriterion("template.template_type not like", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIn(List<String> values) {
            addCriterion("template.template_type in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotIn(List<String> values) {
            addCriterion("template.template_type not in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeBetween(String value1, String value2) {
            addCriterion("template.template_type between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotBetween(String value1, String value2) {
            addCriterion("template.template_type not between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNull() {
            addCriterion("template.template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template.template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template.template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template.template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template.template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template.template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template.template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template.template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template.template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template.template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template.template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template.template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template.template_name not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateDirIsNull() {
            addCriterion("template.template_dir is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDirIsNotNull() {
            addCriterion("template.template_dir is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDirEqualTo(String value) {
            addCriterion("template.template_dir =", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirNotEqualTo(String value) {
            addCriterion("template.template_dir <>", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirGreaterThan(String value) {
            addCriterion("template.template_dir >", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_dir >=", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirLessThan(String value) {
            addCriterion("template.template_dir <", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirLessThanOrEqualTo(String value) {
            addCriterion("template.template_dir <=", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirLike(String value) {
            addCriterion("template.template_dir like", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirNotLike(String value) {
            addCriterion("template.template_dir not like", value, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirIn(List<String> values) {
            addCriterion("template.template_dir in", values, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirNotIn(List<String> values) {
            addCriterion("template.template_dir not in", values, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirBetween(String value1, String value2) {
            addCriterion("template.template_dir between", value1, value2, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateDirNotBetween(String value1, String value2) {
            addCriterion("template.template_dir not between", value1, value2, "templateDir");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIsNull() {
            addCriterion("template.template_file is null");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIsNotNull() {
            addCriterion("template.template_file is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateFileEqualTo(String value) {
            addCriterion("template.template_file =", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotEqualTo(String value) {
            addCriterion("template.template_file <>", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileGreaterThan(String value) {
            addCriterion("template.template_file >", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_file >=", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLessThan(String value) {
            addCriterion("template.template_file <", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLessThanOrEqualTo(String value) {
            addCriterion("template.template_file <=", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLike(String value) {
            addCriterion("template.template_file like", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotLike(String value) {
            addCriterion("template.template_file not like", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIn(List<String> values) {
            addCriterion("template.template_file in", values, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotIn(List<String> values) {
            addCriterion("template.template_file not in", values, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileBetween(String value1, String value2) {
            addCriterion("template.template_file between", value1, value2, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotBetween(String value1, String value2) {
            addCriterion("template.template_file not between", value1, value2, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbIsNull() {
            addCriterion("template.template_thumb is null");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbIsNotNull() {
            addCriterion("template.template_thumb is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbEqualTo(String value) {
            addCriterion("template.template_thumb =", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbNotEqualTo(String value) {
            addCriterion("template.template_thumb <>", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbGreaterThan(String value) {
            addCriterion("template.template_thumb >", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_thumb >=", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbLessThan(String value) {
            addCriterion("template.template_thumb <", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbLessThanOrEqualTo(String value) {
            addCriterion("template.template_thumb <=", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbLike(String value) {
            addCriterion("template.template_thumb like", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbNotLike(String value) {
            addCriterion("template.template_thumb not like", value, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbIn(List<String> values) {
            addCriterion("template.template_thumb in", values, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbNotIn(List<String> values) {
            addCriterion("template.template_thumb not in", values, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbBetween(String value1, String value2) {
            addCriterion("template.template_thumb between", value1, value2, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateThumbNotBetween(String value1, String value2) {
            addCriterion("template.template_thumb not between", value1, value2, "templateThumb");
            return (Criteria) this;
        }

        public Criteria andTemplateDesIsNull() {
            addCriterion("template.template_des is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDesIsNotNull() {
            addCriterion("template.template_des is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDesEqualTo(String value) {
            addCriterion("template.template_des =", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesNotEqualTo(String value) {
            addCriterion("template.template_des <>", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesGreaterThan(String value) {
            addCriterion("template.template_des >", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesGreaterThanOrEqualTo(String value) {
            addCriterion("template.template_des >=", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesLessThan(String value) {
            addCriterion("template.template_des <", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesLessThanOrEqualTo(String value) {
            addCriterion("template.template_des <=", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesLike(String value) {
            addCriterion("template.template_des like", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesNotLike(String value) {
            addCriterion("template.template_des not like", value, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesIn(List<String> values) {
            addCriterion("template.template_des in", values, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesNotIn(List<String> values) {
            addCriterion("template.template_des not in", values, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesBetween(String value1, String value2) {
            addCriterion("template.template_des between", value1, value2, "templateDes");
            return (Criteria) this;
        }

        public Criteria andTemplateDesNotBetween(String value1, String value2) {
            addCriterion("template.template_des not between", value1, value2, "templateDes");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("template.add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("template.add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("template.add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("template.add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("template.add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("template.add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("template.add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("template.add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("template.add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("template.add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("template.add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("template.add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("template.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("template.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("template.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("template.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("template.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("template.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("template.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("template.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("template.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("template.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("template.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("template.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeIsNull() {
            addCriterion("template.del_time is null");
            return (Criteria) this;
        }

        public Criteria andDelTimeIsNotNull() {
            addCriterion("template.del_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelTimeEqualTo(Integer value) {
            addCriterion("template.del_time =", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotEqualTo(Integer value) {
            addCriterion("template.del_time <>", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeGreaterThan(Integer value) {
            addCriterion("template.del_time >", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("template.del_time >=", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeLessThan(Integer value) {
            addCriterion("template.del_time <", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeLessThanOrEqualTo(Integer value) {
            addCriterion("template.del_time <=", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeIn(List<Integer> values) {
            addCriterion("template.del_time in", values, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotIn(List<Integer> values) {
            addCriterion("template.del_time not in", values, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeBetween(Integer value1, Integer value2) {
            addCriterion("template.del_time between", value1, value2, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("template.del_time not between", value1, value2, "delTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table system_template
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 04 10:36:30 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table system_template
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
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