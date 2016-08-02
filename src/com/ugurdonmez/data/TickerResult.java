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
public class TickerResult {
    
    private final double high;
    private final double last;
    private final String timestamp;
    private final double bid;
    private final double volume;
    private final double low;
    private final double ask;
    private final double open;
    private final double average;

    public TickerResult(double high, double last, String timestamp, double bid, double volume, double low, double ask, double open, double average) {
        this.high = high;
        this.last = last;
        this.timestamp = timestamp;
        this.bid = bid;
        this.volume = volume;
        this.low = low;
        this.ask = ask;
        this.open = open;
        this.average = average;
    }

    public double getHigh() {
        return high;
    }

    public double getLast() {
        return last;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getBid() {
        return bid;
    }

    public double getVolume() {
        return volume;
    }

    public double getLow() {
        return low;
    }

    public double getAsk() {
        return ask;
    }

    public double getOpen() {
        return open;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("Ticker:").append('\n');
        buf.append("High: ").append(this.high).append('\n');
        buf.append("Last: ").append(this.last).append('\n');
        buf.append("Timestamp: ").append(this.timestamp).append('\n');
        buf.append("Bid: ").append(this.bid).append('\n');
        buf.append("Volume: ").append(this.volume).append('\n');
        buf.append("Low: ").append(this.low).append('\n');
        buf.append("Ask: ").append(this.ask).append('\n');
        buf.append("Open: ").append(this.open).append('\n');
        buf.append("Average: ").append(this.average).append('\n');
        
        return buf.toString();
    }
}
