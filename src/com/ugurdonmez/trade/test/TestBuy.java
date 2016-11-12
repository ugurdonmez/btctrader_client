package com.ugurdonmez.trade.test;

/**
 * Created by ugurdonmez on 19/08/16.
 */
public class TestBuy {

    public static void main(String [] args) {

        // MakeOrderThread makeOrderThread = new MakeOrderThread(OrderType.SELL, 1701, 0.02, 4);

        // Thread thread = new Thread(makeOrderThread);

        // thread.run();

        BuyThread buyThread = new BuyThread(1675, 0.01, 0.5);

        Thread thread = new Thread(buyThread);

        thread.run();

    }

}
