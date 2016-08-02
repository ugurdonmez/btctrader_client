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
public class OrderResult {
    
    private final String id;
    private final String datetime;
    private final String type;
    private final double price;
    private final double amount;

    public OrderResult(String id, String datetime, String type, double price, double amount) {
        this.id = id;
        this.datetime = datetime;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
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

        buf.append("Order Result:").append('\n');
        buf.append("Id: ").append(this.id).append('\n');
        buf.append("Datetime: ").append(this.datetime).append('\n');
        buf.append("Type: ").append(this.type).append('\n');
        buf.append("Price: ").append(this.price).append('\n');
        buf.append("Amount: ").append(this.amount).append('\n');
        buf.append("\n");

        return buf.toString();
    }
}
