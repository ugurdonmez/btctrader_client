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
public class OrderBookResult {
    
    private final String timestamp;
    private final double [][] bids;
    private final double [][] asks;

    public OrderBookResult(String timestamp, double[][] bids, double[][] asks) {
        this.timestamp = timestamp;
        this.bids = bids;
        this.asks = asks;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double[][] getBids() {
        return bids;
    }

    public double[][] getAsks() {
        return asks;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("Order Book:").append('\n');
        buf.append("Timestamp: ").append(this.timestamp).append('\n');
        
        buf.append("Bids: ").append('\n');
        for (int i = 0; i < 21 && i < bids.length; i++) {
            buf.append('\t').append(i).append(" :").append('\n');
            buf.append('\t').append('\t').append("Price : ").append(this.bids[i][0]).append('\n');
            buf.append('\t').append('\t').append("Volume: ").append(this.bids[i][1]).append('\n');
        }
        
        buf.append("Asks: ").append('\n');
        for (int i = 0; i < 21 && i < bids.length; i++) {
            buf.append('\t').append(i).append(" :").append('\n');
            buf.append('\t').append('\t').append("Price : ").append(this.asks[i][0]).append('\n');
            buf.append('\t').append('\t').append("Volume: ").append(this.asks[i][1]).append('\n');
        }
        buf.append("\n");
        
        return buf.toString();
    }
}
