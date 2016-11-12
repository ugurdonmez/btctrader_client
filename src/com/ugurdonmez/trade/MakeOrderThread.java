package com.ugurdonmez.trade;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientImpl;
import com.ugurdonmez.data.OrderBookResult;
import com.ugurdonmez.data.OrderResult;

import java.util.Optional;

/**
 * Created by ugurdonmez on 04/08/16.
 */
public class MakeOrderThread implements Runnable{

    private final OrderType type;
    private final double end;
    private final double amount;
    private final double spreadStopLimit;

    public MakeOrderThread(OrderType type, double end, double amount, double spreadStopLimit) {
        this.type = type;
        this.end = end;
        this.amount = amount;
        this.spreadStopLimit = spreadStopLimit;
    }

    @Override
    public void run() {

        BTCTraderClient btcTraderClient = new BTCTraderClientImpl();

        // get margin
        Optional<OrderBookResult> orderBookOptional = btcTraderClient.getBTCTraderOrderBook();

        if (!orderBookOptional.isPresent()) {
            return;
        }

        OrderBookResult orderBook = orderBookOptional.get();

        double spread = orderBook.getAsks()[0][0] - orderBook.getBids()[0][0];

        if (spread < spreadStopLimit) {
            return;
        }

        if (this.type == OrderType.BUY) {
            while (true) {
                double bidStart = orderBook.getBids()[0][0];
                //bidStart += 0.01;

                if (bidStart > this.end) {
                    return;
                }

                // cancel old buy orders
                ImmutableList<OrderResult> openOrders = btcTraderClient.getBTCTraderOpenOrders();

                openOrders.stream()
                        .filter(order -> order.getType().equals("BuyBtc"))
                        .filter(order -> order.getPrice() < bidStart)
                        .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));

                btcTraderClient.buyBTCTraderOrder(0, bidStart, amount, 0);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            while (true) {

                orderBook = orderBookOptional.get();

                double bidStart = orderBook.getAsks()[0][0];

                if (bidStart < this.end) {
                    return;
                }

                // check that lowest price is our order

                // cancel old sell orders
                ImmutableList<OrderResult> openOrders = btcTraderClient.getBTCTraderOpenOrders();

                openOrders.stream()
                        .filter(order -> order.getType().equals("SellBtc"))
                        .filter(order -> order.getPrice() > bidStart)
                        .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));

                double bidPrice = bidStart - 0.01;

                btcTraderClient.sellBTCTraderOrder(0, bidPrice, amount, 0);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
