package com.ugurdonmez.examples;

import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientImpl;

/**
 * Created by ugurdonmez on 01/08/16.
 */
public class TestGetOrderBook {

    public static void main (String [] args) {

        BTCTraderClient btcTraderClient = new BTCTraderClientImpl();

        btcTraderClient.getBTCTraderOrderBook().ifPresent(System.out::println);
    }

}
