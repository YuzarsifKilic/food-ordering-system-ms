package com.yuzarsif.food.ordering.system.order.service.domain;

import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.track.TrackOrderRespone;
import com.yuzarsif.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class OrderApplicationserviceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    OrderApplicationserviceImpl(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderRespone trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
