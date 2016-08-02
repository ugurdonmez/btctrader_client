/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.data;

import java.util.Date;

/**
 *
 * @author ugurdonmez
 */
public class OHCLData {
    
    private final Date date;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final double volume;
    private final double average;
    private final double dailyChangeAmount;
    private final double dailyChangePercentage;

    public OHCLData(Date date, double open, double high, double low, 
            double close, double volume, double average, 
            double dailyChangeAmount, double dailyChangePercentage) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.average = average;
        this.dailyChangeAmount = dailyChangeAmount;
        this.dailyChangePercentage = dailyChangePercentage;
    }

    public Date getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public double getVolume() {
        return volume;
    }

    public double getAverage() {
        return average;
    }

    public double getDailyChangeAmount() {
        return dailyChangeAmount;
    }

    public double getDailyChangePercentage() {
        return dailyChangePercentage;
    }    

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("OHCL Data:").append('\n');
        buf.append("Date: ").append(this.date).append('\n');
        buf.append("Open: ").append(this.open).append('\n');
        buf.append("High: ").append(this.high).append('\n');
        buf.append("Low: ").append(this.low).append('\n');
        buf.append("Close: ").append(this.close).append('\n');
        buf.append("Volume: ").append(this.volume).append('\n');
        buf.append("Average: ").append(this.average).append('\n');
        buf.append("DailyChangeAmount: ").append(this.dailyChangeAmount).append('\n');
        buf.append("DailyChangePercentage: ").append(this.dailyChangePercentage).append('\n');
        buf.append("\n");
        
        return buf.toString();
    }
}
