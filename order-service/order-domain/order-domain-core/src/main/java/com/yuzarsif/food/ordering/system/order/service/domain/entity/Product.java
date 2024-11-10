package com.yuzarsif.food.ordering.system.order.service.domain.entity;

import com.yuzarsif.domain.entity.BaseEntity;
import com.yuzarsif.domain.valueobject.Money;
import com.yuzarsif.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {

    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void updateWithConfirmedAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
