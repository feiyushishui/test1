package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.apis.workorder.vo.CommentVo;
import com.tencent.gaio.commons.http.DataItem;

public interface IWorkorderCommentService {
    Integer createWorkorderComment(String workorderId, String taskDefKey, CommentVo commentVo);

    DataItem getWorkorderComment(String workorderId);
}
