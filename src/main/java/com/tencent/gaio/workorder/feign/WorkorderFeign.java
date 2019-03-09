package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.workorder.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${workorder-apis:workorder-apis}", url = "http://localhost:8081")
public interface WorkorderFeign {

    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.GET)
    ResponseEntity<WorkorderApplyer> findApplyerByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/items", method = RequestMethod.GET)
    ResponseEntity<WorkorderItem> findItemByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);


    @RequestMapping(value = "/workorders/{workorderCode}/traces", method = RequestMethod.GET)
    ResponseEntity<WorkorderTraces> findTracesByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

}
