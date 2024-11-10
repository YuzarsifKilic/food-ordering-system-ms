package com.yuzarsif.food.ordering.system.order.service.domain.ports.output.message.restaurantapproval;

import com.yuzarsif.domain.event.publisher.DomainEventPublisher;
import com.yuzarsif.food.ordering.system.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
