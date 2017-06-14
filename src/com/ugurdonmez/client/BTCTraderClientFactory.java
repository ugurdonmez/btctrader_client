package com.ugurdonmez.client;

/**
 * Created with IntelliJ IDEA.
 * User: Gurcan Asus
 * Date: 23.05.2017
 * Time: 00:26
 * To change this template use File | Settings | File Templates.
 */
public class BTCTraderClientFactory {
    private static BTCTraderClient instance;
    public static BTCTraderClient getInstance(){
        if(instance == null)
            instance = new BTCTraderClientImpl();
        return instance;
    }
}
