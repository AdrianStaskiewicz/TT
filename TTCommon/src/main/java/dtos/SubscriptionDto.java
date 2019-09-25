package dtos;

import entities.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private Long id;
    private User subscriber;
    private Task task;

    public SubscriptionDto(Subscription subscription) {
        this.id = subscription.getId();
        this.subscriber = subscription.getSubscriber();
        this.task = subscription.getTask();
    }

    public Subscription toEntity() {
        Subscription subscription = new Subscription();
        subscription.setId(this.id);
        subscription.setSubscriber(this.subscriber);
        subscription.setTask(this.task);
        return subscription;
    }
}
