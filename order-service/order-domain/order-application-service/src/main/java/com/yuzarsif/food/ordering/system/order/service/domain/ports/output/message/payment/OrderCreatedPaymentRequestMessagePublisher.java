package com.yuzarsif.food.ordering.system.order.service.domain.ports.output.message.payment;

import com.yuzarsif.domain.event.publisher.DomainEventPublisher;
import com.yuzarsif.food.ordering.system.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
