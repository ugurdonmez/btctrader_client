package com.ugurdonmez.trade;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientImpl;
import com.ugurdonmez.data.CancelOrderResult;
import com.ugurdonmez.data.OrderBookResult;
import com.ugurdonmez.data.OrderResult;

import java.util.Optional;

/**
 * Created by ugurdonmez on 19/08/16.
 */
public class BuyThread implements Runnable{

    private final double lastBidPrice;
    private final double amount;
    private final double spreadStopLimit;

    private OrderResult lastOrder;

    public BuyThread(double lastBidPrice, double amount, double spreadStopLimit) {
        this.lastBidPrice = lastBidPrice;
        this.amount = amount;
        this.spreadStopLimit = spreadStopLimit;
        this.lastOrder = null;
    }

    @Override
    public void run() {

        BTCTraderClient btcTraderClient = new BTCTraderClientImpl();

        while (true) {

            // get margin
            Optional<OrderBookResult> orderBookOptional = btcTraderClient.getBTCTraderOrderBook();

            if (!orderBookOptional.isPresent()) {
                // TODO: add logger
                System.out.println("Error occurred when getting order book");

                // TODO: cancel open order
                return;
            }

            OrderBookResult orderBook = orderBookOptional.get();


            // TODO: check that order closed
            if (this.lastOrder != null) {

                ImmutableList<OrderResult> openOrders = btcTraderClient.getBTCTraderOpenOrders();

                if (openOrders.stream()
                        .filter(order -> order.getId().equals(this.lastOrder.getId()))
                        .count() < 1 ) {

                    // TODO: log
                    System.out.println("Order executed");
                    return;
                }
            }

            double spread = orderBook.getAsks()[0][0] - orderBook.getBids()[0][0];

            if (spread < spreadStopLimit) {
                // TODO: add logger
                System.out.println("Reached the spread stop limit");

                // TODO: cancel open order
                return;
            }

            double bidStart = orderBook.getBids()[0][0];

            if (bidStart > this.lastBidPrice) {
                // TODO: add logger
                System.out.println("Reached the bid start limit");

                // TODO: cancel open order
                return;
            }

            // TODO: cancel order if ....

            if (lastOrder == null) {
                double bidPrice = bidStart + 0.01;
                Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, this.amount, 0);
                orderResult.ifPresent(result -> this.lastOrder = result);
            } else {
                if (bidStart != lastOrder.getPrice()) {
                    Optional<CancelOrderResult> cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastOrder.getId());
                    while (!cancelOrderResult.isPresent() || !cancelOrderResult.get().isResult()) {
                        cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastOrder.getId());
                    }
                    this.lastOrder = null;

                    double bidPrice = bidStart + 0.01;
                    Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, this.amount, 0);
                    orderResult.ifPresent(result -> this.lastOrder = result);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
