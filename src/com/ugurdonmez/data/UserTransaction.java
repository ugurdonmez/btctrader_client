/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.data;

/**
 *
 * @author ugurdonmez
 */
public class UserTransaction {
    
    private final String id;
    private final String date;
    private final String operation;
    private final double btc;
    private final double currency;
    private final double price;

    public UserTransaction(String id, String dateTime, String operation, double btc, double currency, double price) {
        this.id = id;
        this.date = dateTime;
        this.operation = operation;
        this.btc = btc;
        this.currency = currency;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getOperation() {
        return operation;
    }

    public double getBtc() {
        return btc;
    }

    public double getCurrency() {
        return currency;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("User Transaction:").append('\n');
        buf.append("Id: ").append(this.id).append('\n');
        buf.append("Date: ").append(this.date).append('\n');
        buf.append("Operation: ").append(this.operation).append('\n');
        buf.append("BTC: ").append(this.btc).append('\n');
        buf.append("Currency: ").append(this.currency).append('\n');
        buf.append("Price: ").append(this.price).append('\n');
        
        return buf.toString();
    }
}
