package com.yuzarsif.food.ordering.system.order.service.domain.event;

import com.yuzarsif.domain.event.DomainEvent;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
