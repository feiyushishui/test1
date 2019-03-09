package com.tencent.gaio.affair.feign;

import com.tencent.gaio.affair.domain.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "${affair-apis:affair-apis}", url = "http://localhost:8080", path = "/items")
public interface ItemFeign {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test();

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
     * 根据事项实施编码code查询数据
     * @param itemTaskCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}", method = RequestMethod.GET)
    ResponseEntity<Item> queryItemByCode(@PathVariable("itemTaskCode") String itemTaskCode, @RequestParam("mark") String mark);

    /**
     * 根据事项实施标识id查询数据
     * @param itemTaskCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/{itemTaskCode}", method = RequestMethod.GET)
    ResponseEntity<Item> queryItemById(@PathVariable("itemTaskCode") long itemTaskCode, @RequestParam("mark") String mark);
}
