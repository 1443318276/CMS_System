package edu.xww.spring.controller.master;

import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;
import edu.xww.beans.DeleteBean;
import edu.xww.beans.ErrorBean;
import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserMasterRule;
import edu.xww.db.model.ViewRouterRule;
import edu.xww.spring.controller.PublicController;
import edu.xww.utils.Tools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "master", method = RequestMethod.POST)
public class MasterApiController extends PublicController {
    @Value("${system.defaultMasterPassword}")
    private String defaultPassword;

    @RequestMapping("userMasterData")
    @ResponseBody
    public BootsTableResponse<UserMaster> userMasterData(@RequestBody BootsTableRequest tableRequest) {
        UserMaster master = (UserMaster) session.getAttribute("loginUser");
        //从Table的Extras参数内直接获取数据
        Integer routerId = tableRequest.getExtra("routerId", Integer.class);
        //超级管理员可以管理所有用户信息
        if (master.getRouterId() > 1) {
            if (routerId == null || routerId <= master.getRouterId()) {
                routerId = master.getRouterId() + 1;
                tableRequest.setExtra("routerId", routerId);
            }
        }

        return masterService.bootsData(tableRequest);
    }

    @RequestMapping("editUserMaster")
    @ResponseBody
    public ErrorBean editUserMaster(@RequestBody UserMaster userMaster) {
        if (userMaster == null) return ErrorBean.getInstance(1);
        int resultLines;//返回数据影响的行数
        if (userMaster.isInsert()) {
            userMaster.setMasterPassword(Tools.md5(defaultPassword));
            resultLines = masterService.insertSelective(userMaster);
        } else {
            userMaster.setMasterPassword(null);
            resultLines = masterService.updateByPrimaryKey(userMaster);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delUserMaster")
    @ResponseBody
    public ErrorBean delUserMaster(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (masterService.delElementByIdList(deleteBean.getIdList()) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(5);
    }

    @RequestMapping("userMasterRuleData")
    @ResponseBody
    public BootsTableResponse<ViewRouterRule> userMasterRuleData(@RequestBody BootsTableRequest tableRequest) {
        return masterRuleService.ViewBootsData(tableRequest);
    }

    @RequestMapping("editUserMasterRule")
    @ResponseBody
    public ErrorBean editUserMasterRule(@RequestBody UserMasterRule record) {
        if (record == null) return ErrorBean.getInstance(1);
        int resultLines;
        if (record.isInsert()) {
            resultLines = masterRuleService.insertSelective(record);
        } else {
            resultLines = masterRuleService.updateByPrimaryKey(record);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

}
