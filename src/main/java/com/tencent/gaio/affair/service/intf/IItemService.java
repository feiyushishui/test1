package com.tencent.gaio.affair.service.intf;

import org.springframework.http.ResponseEntity;

public interface IItemService {
    String page(String name, String taskCode);

    ResponseEntity queryItemByCode(String itemTaskCode);

    ResponseEntity queryItemById(long itemTaskCode);
}
