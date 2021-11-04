package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.SystemConfigMapper;
import edu.xww.db.model.SystemConfig;
import edu.xww.db.model.SystemConfigExample;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.SystemConfigService;
import edu.xww.spring.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

@Service
@Primary
public class SystemConfigServiceImpl extends AbstractService implements SystemConfigService {

    @Autowired
    private SystemConfigMapper configMapper;

    @Override
    public SystemConfig findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return configMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertSelective(SystemConfig record) {
        if (record == null) return 0;
        record.prepareEdit();
        int lines = configMapper.insertSelective(record);
        if (lines > 0) {
            Application.getInstance().updateConfig(record);
        }
        return lines;
    }

    @Override
    public int updateByPrimaryKey(SystemConfig record) {
        if (record == null) return 0;
        record.prepareEdit();
        int lines = configMapper.updateByPrimaryKeySelective(record);
        if (lines > 0) {
            Application.getInstance().updateConfig(findByPrimaryKey(record.getId()));
        }
        return lines;
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        //按条件修改
        SystemConfig record = new SystemConfig();
        record.setDelTime((int) (System.currentTimeMillis() / 1000));
        SystemConfigExample example = new SystemConfigExample();
        SystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        return configMapper.updateByExampleSelective(record, example);
    }

    @Override
    public BootsTableResponse<SystemConfig> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //创建查询示例
        SystemConfigExample example = new SystemConfigExample();
        //创建查询条件构造器
        SystemConfigExample.Criteria criteria = example.createCriteria();
        //添加查询条件
        criteria.andDelTimeEqualTo(0);
        //添加搜索条件
        if (tableRequest.getSearch() != null) {
            criteria.andConfigNameLike(tableRequest.getSearch());
        }
        //添加排序条件
        if (tableRequest.getSort() == null) {
            //默认排序条件
            example.setOrderByClause("add_time desc");
        } else {
            //通过字符串拼接的方式实现了数据的排序
            example.setOrderByClause(tableRequest.getSort() + " " + tableRequest.getOrder());
        }
        //查询分页
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(configMapper.selectByExample(example));
    }

    @Override
    public List<SystemConfig> selectAllConfig() {
        //创建查询示例
        SystemConfigExample example = new SystemConfigExample();
        //创建查询条件构造器
        SystemConfigExample.Criteria criteria = example.createCriteria();
        //添加查询条件
        criteria.andDelTimeEqualTo(0);
        return configMapper.selectByExample(example);
    }
}
