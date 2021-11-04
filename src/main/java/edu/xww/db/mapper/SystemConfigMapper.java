package edu.xww.db.mapper;

import edu.xww.db.model.SystemConfig;
import edu.xww.db.model.SystemConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemConfigMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    long countByExample(SystemConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int deleteByExample(SystemConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int insert(SystemConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int insertSelective(SystemConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    List<SystemConfig> selectByExample(SystemConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    SystemConfig selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int updateByExampleSelective(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int updateByPrimaryKeySelective(SystemConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_config
     *
     * @mbg.generated Thu Nov 04 10:36:30 CST 2021
     */
    int updateByPrimaryKey(SystemConfig record);
}