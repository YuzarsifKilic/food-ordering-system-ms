package com.yuzarsif.food.ordering.system.order.service.domain.ports.output.message.payment;

import com.yuzarsif.domain.event.publisher.DomainEventPublisher;
import com.yuzarsif.food.ordering.system.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
