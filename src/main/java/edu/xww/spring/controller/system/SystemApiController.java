package edu.xww.spring.controller.system;

import edu.xww.db.model.SystemConfig;
import edu.xww.db.model.SystemTemplate;
import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;
import edu.xww.beans.DeleteBean;
import edu.xww.beans.ErrorBean;

@Controller
@RequestMapping(value = "master", method = RequestMethod.POST)
public class SystemApiController extends PublicController {

    @RequestMapping("systemConfigData")
    @ResponseBody
    public BootsTableResponse<SystemConfig> systemConfigData(@RequestBody BootsTableRequest tableRequest) {
        return configService.bootsData(tableRequest);
    }

    @RequestMapping("editSystemConfig")
    @ResponseBody
    public ErrorBean editSystemConfig(@RequestBody SystemConfig record) {
        if (record == null) return ErrorBean.getInstance(1);
        int resultLines;//返回数据影响的行数
        if (record.isInsert()) {
            resultLines = configService.insertSelective(record);
        } else {
            record.setConfigType(null);
            record.setConfigKey(null);
            record.setConfigName(null);
            resultLines = configService.updateByPrimaryKey(record);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delSystemConfig")
    @ResponseBody
    public ErrorBean delSystemConfig(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (configService.delElementByIdList(deleteBean.getIdList()) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(5);
    }

    @RequestMapping("systemTemplateData")
    @ResponseBody
    public BootsTableResponse<SystemTemplate> systemTemplateData(@RequestBody BootsTableRequest tableRequest) {
        return templateService.bootsData(tableRequest);
    }

    @RequestMapping("editSystemTemplate")
    @ResponseBody
    public ErrorBean editSystemTemplate(@RequestBody SystemTemplate record) {
        if (record == null) return ErrorBean.getInstance(1);
        if (!record.getTemplateFile().endsWith(".ftl")){
            record.setTemplateFile(record.getTemplateFile()+".ftl");
        }
        int resultLines;//返回数据影响的行数
        if (record.isInsert()) {
            resultLines = templateService.insertSelective(record);
        } else {
            resultLines = templateService.updateByPrimaryKey(record);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delSystemTemplate")
    @ResponseBody
    public ErrorBean delSystemTemplate(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (templateService.delElementByIdList(deleteBean.getIdList()) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(5);
    }
}
