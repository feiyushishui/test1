package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.apis.affair.domain.ItemProcVo;
import com.tencent.gaio.apis.affair.entity.ProcConfigEntity;
import com.tencent.gaio.apis.bpm.vo.ProcessInstanceReqVo;
import com.tencent.gaio.apis.bpm.vo.ProcessInstanceRspVo;
import com.tencent.gaio.apis.bpm.vo.ProcessInstanceVo;
import com.tencent.gaio.apis.workorder.entity.WorkorderEntity;
import com.tencent.gaio.apis.workorder.entity.WorkorderFormEntity;
import com.tencent.gaio.apis.workorder.entity.WorkorderTraceEntity;
import com.tencent.gaio.apis.workorder.vo.ApplyerVo;
import com.tencent.gaio.apis.workorder.vo.WorkorderFormVo;
import com.tencent.gaio.workorder.domain.WorkorderItem;
import com.tencent.gaio.workorder.feign.ProcessInstanceFeign;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderFormServiceImpl implements IWorkorderFormService {

    @Autowired
    private WorkorderFeign workorderFeign;
    @Autowired
    private ItemFeign itemFeign;
    @Autowired
    private ProcessInstanceFeign processInstanceFeign;

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    @Override
    public WorkorderFormEntity findByWorkorderid(String workorderid) {
        return workorderFeign.findByWorkorderid(workorderid, "id");
    }

    /**
     * 通过工单code查询表单
     *
     * @param workorderCode
     * @return
     */
    @Override
    public WorkorderFormEntity findByWorkorderCode(String workorderCode) {
        return workorderFeign.findByWorkorderCode(workorderCode, "code");
    }

    /**
     * 根据id更新工单-申请人信息
     *
     * @param applyVo
     * @param id
     * @return
     */
    @Override
    public String updateWorkorderById(ApplyerVo applyVo, long id) {
        return workorderFeign.updateWorkorderById(applyVo, id, "id");
    }

    /**
     * 根据code更新工单-申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @Override
    public String updateWorkorderByCode(ApplyerVo applyVo, String workorderCode) {
        return workorderFeign.updateWorkorderByCode(applyVo, workorderCode, "code");
    }

    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId) {
        return workorderFeign.updateFormsByWorkorderId(vo, workorderId, "id");
    }

    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode) {
        return workorderFeign.updateFormsByWorkorderCode(vo, workorderCode, "code");
    }

    /**
     * @param workorderFormVo
     * @param workorderCode
     * @param mark
     */
    @Override
    public void createWorkorderForm(WorkorderFormVo workorderFormVo, String workorderCode, String mark) {
        workorderFeign.createWorkorderForm(workorderFormVo, workorderCode, mark);
    }

    /**
     * 通过工单流水号完成表单提交，并启动工单流程实例
     *
     * @param workorderCode
     * @return
     */
    @Override
    public int submitWorkorderTask(String workorderCode, String mark) {

        // step No.1 获取事项
        WorkorderItem workorderItemEntity = workorderFeign.getWorkorderItem(workorderCode, mark);

        // step No.2 获取事项流程配置
        String itemTaskCode = workorderItemEntity.getTaskCode();
        ItemProcVo procs = itemFeign.queryProcs(itemTaskCode);

        // step No.3 启动流程实例 返回实例ID
        Map variables = new HashMap();
        List<ProcConfigEntity> list = procs.getConfig();
        for (ProcConfigEntity procConfigEntity : list) {
            variables.put(procConfigEntity.getCode(), procConfigEntity.getValue());
        }
        ProcessInstanceReqVo processInstanceReqVo = new ProcessInstanceReqVo();
        processInstanceReqVo.setProcessDefinitionId(procs.getProcDefId());
        processInstanceReqVo.setVariables(variables);
        ResponseEntity<ProcessInstanceRspVo> processInstanceResEntity = processInstanceFeign.create(processInstanceReqVo);
        ProcessInstanceRspVo processInstanceRspVo = processInstanceResEntity.getBody();
        ProcessInstanceVo processInstanceVo = processInstanceRspVo.getData();


        String processInstanceId = processInstanceVo.getProcessInstanceId();

        // step No.4 更新工单
        WorkorderEntity workorderEntity = new WorkorderEntity();
        workorderEntity.setProcInstId(processInstanceId);
        //TODO 状态，参考那十张表状态，联系人胜锋
        workorderEntity.setState("1");
        ResponseEntity workResEntitiy = workorderFeign.updateWorkorder(workorderEntity, workorderCode, "id");
        if (workResEntitiy.getStatusCode().value() != 200) {
            return 1;
        }
        //TODO step No.5 工单痕迹
        WorkorderTraceEntity wte = new WorkorderTraceEntity();
//        wte.setActInstId();
//        wte.setActName();
//        wte.set


//         workorderFeign.createTrace(wte,workorderCode,"code");

        //TODO step No.6 返回结果


        System.out.println("processInstanceId:" + processInstanceId);
        return 0;
    }
}