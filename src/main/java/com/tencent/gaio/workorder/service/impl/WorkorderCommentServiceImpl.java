package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.apis.workorder.vo.CommentVo;
import com.tencent.gaio.commons.http.DataItem;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderCommentServiceImpl implements IWorkorderCommentService {
    @Autowired
    private WorkorderFeign workorderFeign;

    @Override
    public Integer createWorkorderComment(String workorderId, String taskDefKey, CommentVo commentVo) {
        return workorderFeign.createWorkorderComment(workorderId, taskDefKey, commentVo, "id");
    }

    @Override
    public DataItem getWorkorderComment(String workorderId) {
        return workorderFeign.getWorkorderComment(workorderId, "id");
    }
}