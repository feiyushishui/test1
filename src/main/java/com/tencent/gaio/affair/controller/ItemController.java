package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.service.IItemService;
import com.tencent.gaio.commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/items"})
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        return iItemService.test();
    }

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String page(@RequestParam String name,@RequestParam String taskCode){
        return  iItemService.page(name,taskCode);
    }

    /**
     * 根据id查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/materials"},method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String ItemMaterialListById(@PathVariable("itemTaskCode") String itemTaskCode){
        return  iItemService.itemMaterialListById(itemTaskCode);
    }

    /**
     * 根据code查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/materials"},method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public String ItemMaterialListByCode(@PathVariable("itemTaskCode") String itemTaskCode){
        return  iItemService.itemMaterialListByCode(itemTaskCode);
    }

    /**
     * 根据ID查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/configs"},method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String queryConfigsById(@PathVariable("itemTaskCode") String itemTaskCode){
        return  iItemService.queryConfigsById(itemTaskCode);
    }

    /**
     * 根据code查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/configs"},method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public String queryConfigsByCode(@PathVariable("itemTaskCode") String itemTaskCode){
        return  iItemService.queryConfigsByCode(itemTaskCode);
    }

}
