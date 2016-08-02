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
public class Trade {

    private final String date;
    private final String tid;
    private final double price;
    private final double amount;

    public Trade(String date, String tid, double price, double amount) {
        this.date = date;
        this.tid = tid;
        this.price = price;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTid() {
        return tid;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("Trade:").append('\n');
        buf.append("Date: ").append(this.date).append('\n');
        buf.append("Trade id: ").append(this.tid).append('\n');
        buf.append("Price: ").append(this.price).append('\n');
        buf.append("Amount: ").append(this.amount).append('\n');
        
        return buf.toString();
    }
}
