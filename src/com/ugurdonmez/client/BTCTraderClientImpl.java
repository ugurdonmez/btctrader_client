package com.ugurdonmez.client;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.data.*;
import data.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugurdonmez
 */
public class BTCTraderClientImpl implements BTCTraderClient {

    @Override
    public Optional<TickerResult> getBTCTraderTicker() {
        try {
            return BTCTraderServices.getTicker(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<OrderBookResult> getBTCTraderOrderBook() {
        try {
            return BTCTraderServices.getOrderBook(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public ImmutableList<Trade> getBTCTraderTrades() {
        try {
            return BTCTraderServices.getTradesList(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ImmutableList.of();
    }

    @Override
    public ImmutableList<OHCLData> getBTCTraderOHCLData() {
        try {
            return BTCTraderServices.getOHCLDataList(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ImmutableList.of();
    }

    @Override
    public Optional<BalanceResult> getBTCTraderBalance() {
        try {
            return BTCTraderServices.getBalance(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public ImmutableList<UserTransaction> getBTCTraderUserTransaction() {
        try {
            return BTCTraderServices.getUserTransactionList(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ImmutableList.of();
    }

    @Override
    public ImmutableList<OrderResult> getBTCTraderOpenOrders() {
        try {
            return BTCTraderServices.getOpenOrderList(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ImmutableList.of();
    }

    @Override
    public Optional<CancelOrderResult> cancelBTCTraderOrder(String orderId) {
        try {
            return BTCTraderServices.postCancelOrder(orderId,BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<OrderResult> buyBTCTraderOrder(int isMarketOrder, double price, double amount, double total) {
        try {
            return BTCTraderServices.postBuyOrder(isMarketOrder, price, amount, total,
                    BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<OrderResult> sellBTCTraderOrder(boolean isMarketOrder, double price, double amount, double total) {
        try {
            return BTCTraderServices.postSellOrder(isMarketOrder, price, amount, total,
                    BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<DepositMoneyResult> getBTCTraderDepositMoneyInfoResult() {
        try {
            return BTCTraderServices.getMoneyDepositInfo(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<DepositMoneyResult> depositBTCTraderMoney(double amount, double amountPrecision) {
        try {
            return BTCTraderServices.postMoneyDeposit(amount, amountPrecision, BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<WithdrawalMoneyResult> getBTCTraderMoneyWithdrawalInfoResult() {
        try {
            return BTCTraderServices.getMoneyWithdrawalInfo(BTCTraderServices.getAuthentication());
        } catch (IOException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BTCTraderClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.empty();
    }

    @Override
    public Optional<WithdrawalMoneyResult> withdrawalBTCTraderMoney() {
        throw new NotImplementedException();
    }
}
