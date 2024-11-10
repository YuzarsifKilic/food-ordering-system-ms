package com.yuzarsif.food.ordering.system.order.service.domain.ports.input.mesage.listener.payment;

import com.yuzarsif.food.ordering.system.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
