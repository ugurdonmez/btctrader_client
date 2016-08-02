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
public class BalanceResult {
    
    private final double money_balance;
    private final double bitcoin_balance;
    private final double money_reserved;
    private final double bitcoin_reserved;
    private final double money_available;
    private final double bitcoin_available;
    private final double fee_percentage;
    private final double maker_fee_percentage;

    public BalanceResult(double money_balance, double bitcoin_balance, double money_reserved, double bitcoin_reserved, double money_available, double bitcoin_available, double fee_percentage, double maker_fee_percentage) {
        this.money_balance = money_balance;
        this.bitcoin_balance = bitcoin_balance;
        this.money_reserved = money_reserved;
        this.bitcoin_reserved = bitcoin_reserved;
        this.money_available = money_available;
        this.bitcoin_available = bitcoin_available;
        this.fee_percentage = fee_percentage;
        this.maker_fee_percentage = maker_fee_percentage;
    }

    public double getMoneyBalance() {
        return money_balance;
    }

    public double getBitcoinBalance() {
        return bitcoin_balance;
    }
    
    public double getMoneyReserved() {
        return money_reserved;
    }

    public double getBitcoinReserved() {
        return bitcoin_reserved;
    }

    public double getMoneyAvailable() {
        return money_available;
    }

    public double getBitcoinAvailable() {
        return bitcoin_available;
    }

    public double getFeePercentage() {
        return fee_percentage;
    }

    public double getMakerFeePercentage() {
        return maker_fee_percentage;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("Balance:").append('\n');
        buf.append("Money Balance: ").append(getMoneyBalance()).append('\n');
        buf.append("Bitcoin Balance: ").append(getBitcoinBalance()).append('\n');
        buf.append("Money Reserved: ").append(getMoneyReserved()).append('\n');
        buf.append("Bitcoin Reserved: ").append(getBitcoinReserved()).append('\n');
        buf.append("Money Available: ").append(getMoneyAvailable()).append('\n');
        buf.append("Bitcoin Available: ").append(getBitcoinAvailable()).append('\n');
        buf.append("Fee Percentage: ").append(getFeePercentage()).append('\n');
        buf.append("Maker Fee Percentage: ").append(getMakerFeePercentage()).append('\n');
        buf.append("\n");
        
        return buf.toString();
    }
    
}
