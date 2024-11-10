package com.yuzarsif.domain.event.publisher;

import com.yuzarsif.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
