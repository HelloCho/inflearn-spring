package hello.core.discount.service;

import hello.core.discount.model.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
