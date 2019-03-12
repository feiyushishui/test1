package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.apis.workorder.entity.WorkorderEntity;
import com.tencent.gaio.commons.http.DataPage;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.TaskActionReqVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import com.tencent.gaio.workorder.vo.WorkorderVO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IWorkorderService {

    /**
     * 根据条件分页查询-工单草稿列表
     * @param params
     * @return
     */
    DataPage workorderDraftPage(Map<String,Object> params);

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     * @param workorderVO
     */
    ResponseEntity<WorkorderEntity> create(WorkorderVO workorderVO);

    /**
     * 查询工单-申请人
     *
     * @param
     * @return
     */
    ResponseEntity<ApplyerVo> getApplyers(String workorderCodeOrId, String mark);


    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId);


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode);
    /**
     * 工单操作（认领、提交、代理、代理提交）
     *
     * @param workorderid
     * @param actInstId
     * @param taskActionReqVo
     * @return
     */
    Integer operateWorkorderByBpm(String workorderid, String actInstId, TaskActionReqVo taskActionReqVo);
}
