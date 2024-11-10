package com.yuzarsif.food.ordering.system.order.service.domain.ports.input.mesage.listener.restaurantapproval;

import com.yuzarsif.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
