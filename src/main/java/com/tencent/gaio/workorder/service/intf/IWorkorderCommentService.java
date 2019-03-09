package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.CommentVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderCommentService {
    Integer createWorkorderComment(String workorderId, String taskDefKey, CommentVo commentVo);
}
