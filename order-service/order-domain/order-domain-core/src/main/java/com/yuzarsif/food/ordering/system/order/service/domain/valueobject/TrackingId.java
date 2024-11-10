package com.yuzarsif.food.ordering.system.order.service.domain.valueobject;

import com.yuzarsif.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID value) {
        super(value);
    }
}
