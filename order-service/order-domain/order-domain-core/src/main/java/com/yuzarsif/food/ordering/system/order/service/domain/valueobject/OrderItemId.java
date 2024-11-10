package com.yuzarsif.food.ordering.system.order.service.domain.valueobject;

import com.yuzarsif.domain.entity.BaseEntity;
import com.yuzarsif.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {

    public OrderItemId(Long value) {
        super(value);
    }
}
