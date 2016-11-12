package com.ugurdonmez.trade;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientImpl;
import com.ugurdonmez.data.BalanceResult;
import com.ugurdonmez.data.OrderBookResult;
import com.ugurdonmez.data.OrderResult;

import java.util.Optional;

/**
 * Created by ugurdonmez on 03/08/16.
 */
public class BasicAlgorithm {

    public static void main(String [] args) throws InterruptedException {

        BTCTraderClient btcTraderClient = new BTCTraderClientImpl();

        while (true) {
            Thread.sleep(1000);

            Optional<BalanceResult> balanceResultOptional = btcTraderClient.getBTCTraderBalance();

            if (!balanceResultOptional.isPresent()) {
                Thread.sleep(10000);
                continue;
            }

            BalanceResult balance = balanceResultOptional.get();

            ImmutableList<OrderResult> openOrdersList = btcTraderClient.getBTCTraderOpenOrders();

            // check that there is enough money or open orders
            if (openOrdersList.size() == 0 && balance.getBitcoinAvailable() < 0.005 && balance.getMoneyAvailable() < 90) {
                System.out.println("Program terminates");
                return;
            }


            Optional<OrderBookResult> orderBookOptional = btcTraderClient.getBTCTraderOrderBook();

            if (!orderBookOptional.isPresent()) {
                continue;
            }

            OrderBookResult orderBook = orderBookOptional.get();

            double spread = orderBook.getAsks()[0][0] - orderBook.getBids()[0][0];

            System.out.println(spread);

            if (spread < 9) {
                Thread.sleep(10000);
                continue;
            }

            // buy order
            // each two second check that order is first in row, otherwise update it to the limit

            // sell order
        }

    }

}
