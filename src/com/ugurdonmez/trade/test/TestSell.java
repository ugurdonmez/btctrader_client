package com.ugurdonmez.trade.test;

import com.ugurdonmez.trade.MakeOrderThread;
import com.ugurdonmez.trade.OrderType;
import com.ugurdonmez.trade.SellThread;

/**
 * Created by ugurdonmez on 16/08/16.
 */
public class TestSell {

    public static void main(String [] args) {

        // MakeOrderThread makeOrderThread = new MakeOrderThread(OrderType.SELL, 1701, 0.02, 4);

        // Thread thread = new Thread(makeOrderThread);

        // thread.run();

        SellThread sellThread = new SellThread(1675, 0.01, 0.5);

        Thread thread = new Thread(sellThread);

        thread.run();

    }

}
