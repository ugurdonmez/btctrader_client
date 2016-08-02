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
public class CancelOrderResult {
    
    private final boolean result;

    public CancelOrderResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        
        buf.append("Cancel Order:").append('\n');
        buf.append("Result: ").append(this.result).append('\n');
        buf.append("\n");
        
        return buf.toString();
    }
}
