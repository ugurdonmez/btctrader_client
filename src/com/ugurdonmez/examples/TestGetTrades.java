package com.ugurdonmez.examples;

import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientImpl;

/**
 * Created by ugurdonmez on 01/08/16.
 */
public class TestGetTrades {

    public static void main(String [] args) {
        BTCTraderClient client = new BTCTraderClientImpl();

        System.out.println(client.getBTCTraderTrades());
    }

}
