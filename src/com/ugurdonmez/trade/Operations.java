package com.ugurdonmez.trade;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.data.OrderResult;

/**
 * Created by ugurdonmez on 03/08/16.
 */
public interface Operations {

    void cancelOrders(OrderType type, double maxPrice);

    ImmutableList<OrderResult> getOpenOrderByTypeAndPrice(OrderType type, double price);

    boolean isFirstOrder(OrderResult orderResult);

}
