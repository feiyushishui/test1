package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.ApplyVo;

public interface ISomeService {
    String updateWorkorderById(ApplyVo applyVo, long id);

    String getWorkorderFormById(long id);
}
