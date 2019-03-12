package com.tencent.gaio.affair.feign;

import com.tencent.gaio.apis.affair.domain.ItemProcVo;
import com.tencent.gaio.apis.affair.entity.ItemEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "${affair-apis:affair-apis}", url = "http://localhost:8080", path = "/items")
public interface ItemFeign {

    /**
     * 根据条件分页查询事项列表
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String page(@RequestParam Map<String, Object> map);

    /**
     * 根据id查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/materials?mark=id", method = RequestMethod.GET)
    DataList itemMaterialListById(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据code查询接入事项-材料详细
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/materials?mark=code", method = RequestMethod.GET)
    DataList itemMaterialListByCode(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据ID查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/configs?mark=id", method = RequestMethod.GET)
    ItemConfigEntity queryConfigsById(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据code查询接入事项-流程配置
     *
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}/configs?mark=code", method = RequestMethod.GET)
    ItemConfigEntity queryConfigsByCode(@PathVariable("itemTaskCode") String itemTaskCode);

    /**
     * 根据事项实施编码code查询数据
     *
     * @param itemTaskCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}", method = RequestMethod.GET)
    ItemEntity queryItemByCode(@PathVariable("itemTaskCode") String itemTaskCode, @RequestParam("mark") String mark);

    /**
     * 根据事项实施标识id查询数据
     *
     * @param itemTaskCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}", method = RequestMethod.GET)
    ItemEntity queryItemById(@PathVariable("itemTaskCode") long itemTaskCode, @RequestParam("mark") String mark);

    @RequestMapping(value = "/{itemTaskCode}/procs", method = RequestMethod.GET)
    ItemProcVo queryProcs(@PathVariable("itemTaskCode") String itemTaskCode);
}
