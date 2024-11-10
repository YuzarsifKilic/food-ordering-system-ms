package com.yuzarsif.food.ordering.system.order.service.domain.mapper;

import com.yuzarsif.domain.valueobject.CustomerId;
import com.yuzarsif.domain.valueobject.Money;
import com.yuzarsif.domain.valueobject.ProductId;
import com.yuzarsif.domain.valueobject.RestaurantId;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.yuzarsif.food.ordering.system.order.service.domain.dto.create.OrderAddress;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Order;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.OrderItem;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Product;
import com.yuzarsif.food.ordering.system.order.service.domain.entity.Restaurant;
import com.yuzarsif.food.ordering.system.order.service.domain.valueobject.StreetAddress;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant
                .builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream()
                        .map(orderItem -> new Product(new ProductId(orderItem.getPrdoductId())))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order
                .builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderRespose(Order order) {
        return CreateOrderResponse
                .builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(@NotNull List<com.yuzarsif.food.ordering.system.order.service.domain.dto.create.OrderItem> items) {
        return items.stream()
                .map(orderItem ->
                        OrderItem
                                .builder()
                                .product(new Product(new ProductId(orderItem.getPrdoductId())))
                                .quantity(orderItem.getQuantity())
                                .price(new Money(orderItem.getPrice()))
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(@NotNull OrderAddress address) {
        return new StreetAddress(
                UUID.randomUUID(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity());
    }
}
