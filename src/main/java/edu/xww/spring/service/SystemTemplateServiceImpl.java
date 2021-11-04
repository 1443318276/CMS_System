package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
// import db.mapper.SystemTemplateMapper;
import edu.xww.db.mapper.SystemTemplateMapper2;
import edu.xww.db.model.SystemTemplate;
import edu.xww.db.model.SystemTemplateExample;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.SystemTemplateService;
import edu.xww.spring.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

@Service
@Primary
public class SystemTemplateServiceImpl extends AbstractService implements SystemTemplateService {
    @Autowired
    private SystemTemplateMapper2 templateMapper;

    @Override
    public SystemTemplate findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return templateMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertSelective(SystemTemplate record) {
        if (record == null) return 0;
        record.prepareEdit();
        int code = templateMapper.insertSelective(record);
        if (code > 0) {
            Application.getInstance().createTemplateFile(record);
        }
        return code;
    }

    @Override
    public int updateByPrimaryKey(SystemTemplate record) {
        if (record == null) return 0;
        record.prepareEdit();
        int code = templateMapper.updateByPrimaryKeySelective(record);
        if (code > 0) {
            Application.getInstance().createTemplateFile(findByPrimaryKey(record.getId()));
        }
        return code;
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        SystemTemplate template = new SystemTemplate();
        template.setDelTime((int) (System.currentTimeMillis() / 1000));
        SystemTemplateExample example = new SystemTemplateExample();
        example.createCriteria().andIdIn(idList);
        return templateMapper.updateByExampleSelective(template, example);
    }

    @Override
    public BootsTableResponse<SystemTemplate> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //创建查询示例
        SystemTemplateExample example = new SystemTemplateExample();
        //创建查询条件构造器
        SystemTemplateExample.Criteria criteria = example.createCriteria();
        //添加查询条件
        criteria.andDelTimeEqualTo(0);
        //添加搜索条件
        if (tableRequest.getSearch() != null) {
            criteria.andTemplateNameLike(tableRequest.getSearch());
        }
        if (!StringUtils.isEmpty(tableRequest.getString("templateType"))) {
            criteria.andTemplateTypeEqualTo(tableRequest.getString("templateType"));
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
        return new BootsTableResponse<>(templateMapper.selectByExample(example));
    }

    @Override
    public List<SystemTemplate> selectDistinctTypeList() {
        return templateMapper.selectDistinctTypeList();
    }

    @Override
    public List<SystemTemplate> selectAllTemplates() {
        SystemTemplateExample example = new SystemTemplateExample();
        example.createCriteria().andDelTimeEqualTo(0);
        example.setOrderByClause("template.template_dir,template.template_name");
        return templateMapper.selectByExampleWithBLOBs(example);
    }
}

