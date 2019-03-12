package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.service.intf.IItemService;
import com.tencent.gaio.apis.affair.entity.ItemConfigEntity;
import com.tencent.gaio.apis.affair.entity.ItemEntity;
import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.commons.http.DataList;
import com.tencent.gaio.commons.http.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/items"})
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String page(@RequestParam String name, @RequestParam String taskCode) {
        return iItemService.page(name, taskCode);
    }

    /**
     * 根据id查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/materials"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity<ResultModel<DataList>> ItemMaterialListById(@PathVariable("itemTaskCode") String itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.itemMaterialListById(itemTaskCode)));
    }

    /**
     * 根据code查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/materials"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel<DataList>> ItemMaterialListByCode(@PathVariable("itemTaskCode") String itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.itemMaterialListByCode(itemTaskCode)));
    }

    /**
     * 根据ID查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/configs"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity<ResultModel<ItemConfigEntity>> queryConfigsById(@PathVariable("itemTaskCode") String itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.queryConfigsById(itemTaskCode)));
    }

    /**
     * 根据code查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = {"/{itemTaskCode}/configs"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel<ItemConfigEntity>> queryConfigsByCode(@PathVariable("itemTaskCode") String itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.queryConfigsByCode(itemTaskCode)));

    }

    /**
     * 根据事项实施编码code查询数据
     *
     * @param itemTaskCode
     * @return
     */
    @GetMapping(value = "/{itemTaskCode}", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel<ItemEntity>> queryItemByCode(@PathVariable("itemTaskCode") String itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.queryItemByCode(itemTaskCode)));
    }

    /**
     * 根据事项实施标识id查询数据
     *
     * @param itemTaskCode
     * @return
     */
    @GetMapping(value = "/{itemTaskCode}")
    public ResponseEntity<ResultModel<ItemEntity>> queryItemById(@PathVariable("itemTaskCode") long itemTaskCode) {
        return ResponseEntity.ok().body(new ResultModel<>(iItemService.queryItemById(itemTaskCode)));
    }
}
