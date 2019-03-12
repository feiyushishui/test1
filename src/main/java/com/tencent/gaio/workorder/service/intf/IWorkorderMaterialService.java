package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.apis.workorder.vo.WorkorderMaterialVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderMaterialService {
    Integer createWorkorderMaterialById(String workorderId,WorkorderMaterialVo vo);

    Integer createWorkorderMaterialByCode(String workorderCode,WorkorderMaterialVo vo);
}
