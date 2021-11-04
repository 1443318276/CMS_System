package edu.xww.spring.controller.router;

import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;
import edu.xww.beans.DeleteBean;
import edu.xww.beans.ErrorBean;
import edu.xww.db.model.UserRouter;
import edu.xww.db.model.UserRouterRule;
import edu.xww.db.model.ViewRouterRule;
import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "master", method = RequestMethod.POST)
public class RouterApiController extends PublicController {

    @RequestMapping("userRouterData")
    @ResponseBody
    public BootsTableResponse<UserRouter> userRouterData(@RequestBody BootsTableRequest tableRequest) {
        return routerService.bootsData(tableRequest);
    }

    @RequestMapping("editUserRouter")
    @ResponseBody
    public ErrorBean editUserRouter(@RequestBody UserRouter record) {
        if (record == null) return ErrorBean.getInstance(1);
        int resultLines;
        if (record.isInsert()) {
            resultLines = routerService.insertSelective(record);
        } else {
            resultLines = routerService.updateByPrimaryKey(record);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delUserRouter")
    @ResponseBody
    public ErrorBean delUserRouter(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (routerService.delElementByIdList(deleteBean.getIdList()) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(5);
    }

    @RequestMapping("userRouterRuleData")
    @ResponseBody
    public BootsTableResponse<ViewRouterRule> userRouterRuleData(@RequestBody BootsTableRequest tableRequest) {
        return routerRuleService.ViewBootsData(tableRequest);
    }


    @RequestMapping("editUserRouterRule")
    @ResponseBody
    public ErrorBean editUserRouterRule(@RequestBody UserRouterRule record) {
        if (record == null) return ErrorBean.getInstance(1);
        int resultLines;
        if (record.isInsert()) {
            resultLines = routerRuleService.insertSelective(record);
        } else {
            resultLines = routerRuleService.updateByPrimaryKey(record);
        }
        if (resultLines > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delUserRouterRule")
    @ResponseBody
    public ErrorBean delUserRouterRule(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (routerRuleService.delElementByIdList(deleteBean.getIdList()) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(5);
    }
}
