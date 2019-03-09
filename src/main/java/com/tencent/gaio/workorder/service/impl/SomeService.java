package com.tencent.gaio.workorder.service.impl;

import com.tencent.gaio.workorder.feign.AffairFeign;
import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.service.intf.ISomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService implements ISomeService {

    @Autowired
    private AffairFeign affairFeign;

    @Override
    public String updateWorkorderById(ApplyVo applyVo, long id) {
        return affairFeign.updateWorkorderById(applyVo, id, "id");
    }

    @Override
    public String getWorkorderFormById(long id) {
        return affairFeign.getWorkorderFormById(id, "id");
    }
}
