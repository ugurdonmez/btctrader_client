package com.ugurdonmez.trade.test;

import com.ugurdonmez.trade.BuyThread;
import com.ugurdonmez.trade.MakeOrderThread;
import com.ugurdonmez.trade.OrderType;

/**
 * Created by ugurdonmez on 19/08/16.
 */
public class TestBuy {

    public static void main(String [] args) {

        MakeOrderThread makeOrderThread = new MakeOrderThread(OrderType.BUY, 6100, 0.01, 10);

        Thread thread = new Thread(makeOrderThread);

        thread.run();
//
//        BuyThread buyThread = new BuyThread(6100, 0.01, 0.5);
//
//        Thread thread = new Thread(buyThread);
//
//        thread.run();

    }

}
