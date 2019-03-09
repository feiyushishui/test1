package com.tencent.gaio.affair.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name= "${affair-apis:affair-apis}",url = "http://localhost:8080",path = "/items")
public interface ItemFeign {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test();

    /**
     * 根据条件分页查询事项列表
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String page(@RequestParam Map<String,Object> map);


    /**
     * 根据事项id查询事项基本信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{itemId}?mark=id", method = RequestMethod.GET)
    String findItemById(@PathVariable("itemId") Long id);

    /**
     * 根据事项实施编码taskCode查询事项基本信息
     * @param itemTaskCode
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}?mark=code", method = RequestMethod.GET)
    String findItemByCode(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据id查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/materials?mark=id",method = RequestMethod.GET)
    String itemMaterialListById(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据code查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/materials?mark=code",method = RequestMethod.GET)
    String itemMaterialListByCode(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据ID查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/configs?mark=id",method = RequestMethod.GET)
    String queryConfigsById(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据code查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/configs?mark=code",method = RequestMethod.GET)
    String queryConfigsByCode(@PathVariable("itemTaskCode") String itemTaskCode);

}
