package com.yuzarsif.food.ordering.system.order.service.domain.dto.message;

import com.yuzarsif.domain.valueobject.OrderApprovalStatus;

import java.time.Instant;
import java.util.List;

public class PaymentApprovalResponse {

    private String id;
    private String sagaId;
    private String orderId;
    private String restaurantId;
    private Instant createdAt;
    private OrderApprovalStatus orderApprovalStatus;
    private List<String> failureMessages;
}
