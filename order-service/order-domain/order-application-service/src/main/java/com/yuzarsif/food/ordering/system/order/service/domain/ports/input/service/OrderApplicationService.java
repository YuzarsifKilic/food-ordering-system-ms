package com.yuzarsif.food.ordering.system.order.service.domain.ports.input.service;

import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.track.TrackOrderRespone;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderRespone trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
