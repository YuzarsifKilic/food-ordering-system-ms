package com.yuzarsif.food.ordering.system.order.service.domain.dto.create;

import com.yuzarsif.domain.valueobject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {

    @NotNull
    private final UUID orderTrackingId;
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;
}
