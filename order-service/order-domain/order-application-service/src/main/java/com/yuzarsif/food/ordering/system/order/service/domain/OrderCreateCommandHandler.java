package com.yuzarsif.food.ordering.system.order.service.domain;

import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Customer;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Order;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Restaurant;
import com.yuzarsif.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.yuzarsif.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.yuzarsif.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.yuzarsif.food.ordering.system.order.service.domain.ports.output.message.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.yuzarsif.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.yuzarsif.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.yuzarsif.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper, OrderDataMapper orderDataMapper, OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderRespose(orderCreatedEvent.getOrder());
    }

}
