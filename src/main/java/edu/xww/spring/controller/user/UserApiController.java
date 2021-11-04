package edu.xww.spring.controller.user;

import edu.xww.db.model.*;
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
public class UserApiController extends PublicController {

    @RequestMapping("userRuleData")
    @ResponseBody
    public BootsTableResponse<UserRule> userRuleData(@RequestBody BootsTableRequest tableRequest) {
        return ruleService.bootsData(tableRequest);
    }

    @RequestMapping("editUserRule")
    @ResponseBody
    public ErrorBean editUserRule(@RequestBody UserRule record) {
        if (record == null) return ErrorBean.getInstance(1);
        int lineCount;//记录被影响的数据行数
        if (record.getId() == null) {
            //新增
            lineCount = ruleService.insertSelective(record);
        } else {
            //修改
            lineCount = ruleService.updateByPrimaryKey(record);
        }
        if (lineCount == 0) return ErrorBean.getInstance(4);
        return ErrorBean.getInstance(0);
    }

    @RequestMapping("delUserRule")
    @ResponseBody
    public ErrorBean delUserRule(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null || deleteBean.getIdList() == null) return ErrorBean.getInstance(1);
        if (ruleService.delElementByIdList(deleteBean.getIdList()) == 0) return ErrorBean.getInstance(4);
        return ErrorBean.getInstance(0);
    }



}
