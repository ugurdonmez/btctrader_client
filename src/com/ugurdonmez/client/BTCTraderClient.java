package com.ugurdonmez.client;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.data.*;
import data.*;

import java.util.Optional;

/**
 *
 * @author ugurdonmez
 */
public interface BTCTraderClient {

    Optional<TickerResult> getBTCTraderTicker();
    
    Optional<OrderBookResult> getBTCTraderOrderBook();

    ImmutableList<Trade> getBTCTraderTrades();

    ImmutableList<OHCLData> getBTCTraderOHCLData();

    // need authentication
    Optional<BalanceResult> getBTCTraderBalance();

    ImmutableList<UserTransaction> getBTCTraderUserTransaction();

    ImmutableList<OrderResult> getBTCTraderOpenOrders();

    Optional<CancelOrderResult> cancelBTCTraderOrder(String orderId);

    Optional<OrderResult> buyBTCTraderOrder(int isMarketOrder, double price, double amount, double total);

    Optional<OrderResult> sellBTCTraderOrder(boolean isMarketOrder, double price, double amount, double total);

    Optional<DepositMoneyResult> getBTCTraderDepositMoneyInfoResult();

    Optional<DepositMoneyResult> depositBTCTraderMoney(double amount, double amountPrecision);

    Optional<WithdrawalMoneyResult> getBTCTraderMoneyWithdrawalInfoResult();

    Optional<WithdrawalMoneyResult> withdrawalBTCTraderMoney();
}
