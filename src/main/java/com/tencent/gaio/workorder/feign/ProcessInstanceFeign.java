package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.apis.bpm.vo.ProcessInstanceReqVo;
import com.tencent.gaio.apis.bpm.vo.ProcessInstanceRspVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${bpm-apis:bpm-apis}", url = "http://localhost:9090/")
public interface ProcessInstanceFeign {


    /**
     * 启动流程实例
     * POST http://localhost:9090/process-instances
     * {
     * "processDefinitionId":"流程定义id",
     * "businessKey":"",
     * "variables":{
     * "days":"1"
     * }
     * }
     */
    @RequestMapping(value = "/runtime/process-instances", method = RequestMethod.POST)
    ResponseEntity<ProcessInstanceRspVo> create(@RequestBody ProcessInstanceReqVo vo);
}