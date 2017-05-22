package com.ugurdonmez.trade;

import com.google.common.collect.ImmutableList;
import com.ugurdonmez.client.BTCTraderClient;
import com.ugurdonmez.client.BTCTraderClientFactory;
import com.ugurdonmez.client.BTCTraderClientImpl;
import com.ugurdonmez.data.BalanceResult;
import com.ugurdonmez.data.CancelOrderResult;
import com.ugurdonmez.data.OrderBookResult;
import com.ugurdonmez.data.OrderResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: Gurcan Asus
 * Date: 22.05.2017
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class LongTermAlgorithm implements Runnable {

    private final OrderType type;
    private final double end;
    //    private final double amount;
    private final double spreadStopLimit;

    private OrderResult lastBuyOrder;
    private OrderResult lastSellOrder;

    public LongTermAlgorithm(OrderType type, double end, double spreadStopLimit) {
        this.type = type;
        this.end = end;
//        this.amount = amount;
        this.spreadStopLimit = spreadStopLimit;
    }

    public static void main(String args[]) {
        LongTermAlgorithm buy = new LongTermAlgorithm(OrderType.BUY, 6200, 10);
        Thread buyThread = new Thread(buy);
        buyThread.start();

        LongTermAlgorithm sell = new LongTermAlgorithm(OrderType.SELL, 6200, 10);
        Thread sellThread = new Thread(sell);
        sellThread.start();
    }

    @Override
    public void run() {
        try {
            BTCTraderClient btcTraderClient = new BTCTraderClientImpl();

            //önce açýklarý temizliyoruz
            ImmutableList<OrderResult> openOrders = btcTraderClient.getBTCTraderOpenOrders();
            if (this.type == OrderType.BUY) {
                openOrders.stream()
                        .filter(order -> order.getType().equals("BuyBtc"))
                        .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));
            }
            if (this.type == OrderType.SELL) {
                openOrders.stream()
                        .filter(order -> order.getType().equals("SellBtc"))
                        .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));
            }

//            openOrders = btcTraderClient.getBTCTraderOpenOrders();

            while (true) {
                // get margin
                Optional<OrderBookResult> orderBookOptional = btcTraderClient.getBTCTraderOrderBook();

                if (!orderBookOptional.isPresent()) {
                    System.out.println("Piyasa alýnamadý. 10 sn bekleniyor...");
                    Thread.sleep(10000);
                    continue;
                }

                OrderBookResult orderBook = orderBookOptional.get();

                double spread = round(orderBook.getAsks()[0][0] - orderBook.getBids()[0][0], 2);

//                System.out.println(this.type + " için alýþ satýþ fiyat farký: " + spread);
                if (spread <= spreadStopLimit) {
                    System.out.println(this.type + " için alýþ satýþ fiyat farký: " + spread + ", bekleniyor.");
                    Thread.sleep(1000);
                    continue;
                }

                if (this.type == OrderType.BUY) {

                    double bidStart = orderBook.getBids()[0][0];
                    double bidSecondStart = orderBook.getBids()[1][0];

                    if (lastBuyOrder == null || lastBuyOrder.getId() == null) {
                        double bidPrice = round(bidStart + 0.01, 2);
                        if (bidPrice > this.end) {
                            System.out.println(this.type + "için alýþ fiyatý çok yüksek: " + bidPrice);
                            Thread.sleep(1000);
                            continue;
                        }
                        double currentAmount = calculateAmount(bidPrice, type);
                        if (currentAmount == 0) {
                            System.out.println("BTC almak için yeterli para yok, bekleniyor");
                            Thread.sleep(1000);
                            continue;
                        }
                        Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, currentAmount, 0);
                        orderResult.ifPresent(result -> this.lastBuyOrder = result);
                    } else {
                        if (bidStart != lastBuyOrder.getPrice()) {
                            Optional<CancelOrderResult> cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastBuyOrder.getId());
                            int i = 0;
                            while ((!cancelOrderResult.isPresent() || !cancelOrderResult.get().isResult()) && i < 5) {
                                i++;
                                System.out.println("Son iþlem silinemiyor!");
                                Thread.sleep(1000);
                                cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastBuyOrder.getId());
                            }
                            this.lastBuyOrder = null;

                            double bidPrice = round(bidStart + 0.01, 2);
                            if (bidPrice > this.end) {
                                System.out.println(this.type + "için alýþ fiyatý çok yüksek: " + bidPrice);
                                Thread.sleep(1000);
                                continue;
                            }
                            double currentAmount = calculateAmount(bidPrice, type);
                            if (currentAmount == 0) {
                                System.out.println("BTC almak için yeterli para yok, bekleniyor");
                                Thread.sleep(1000);
                                continue;
                            }
                            Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, currentAmount, 0);
                            orderResult.ifPresent(result -> this.lastBuyOrder = result);
                        } else if (round(lastBuyOrder.getPrice() - bidSecondStart, 2) > 0.01) {
                            Optional<CancelOrderResult> cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastBuyOrder.getId());
                            while (!cancelOrderResult.isPresent() || !cancelOrderResult.get().isResult()) {
                                cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastBuyOrder.getId());
                            }
                            this.lastBuyOrder = null;

                            double bidPrice = bidSecondStart + 0.01;
                            if (bidPrice > this.end) {
                                System.out.println(this.type + "için alýþ fiyatý çok yüksek: " + bidPrice);
                                Thread.sleep(1000);
                                continue;
                            }
                            double currentAmount = calculateAmount(bidPrice, type);
                            if (currentAmount == 0) {
                                System.out.println("BTC almak için yeterli para yok, bekleniyor");
                                Thread.sleep(1000);
                                continue;
                            }
                            Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, currentAmount, 0);
                            orderResult.ifPresent(result -> this.lastBuyOrder = result);
                        }
                    }

//                    double bidStart = orderBook.getBids()[0][0];
//                    bidStart += 0.01;


                    // cancel old buy orders


//                    openOrders.stream()
//                            .filter(order -> order.getType().equals("BuyBtc"))
//                            .filter(order -> order.getPrice() < bidStart)
//                            .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));
//
//                    btcTraderClient.buyBTCTraderOrder(0, bidStart, amount, 0);

//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                } else {
                    double askStart = orderBook.getAsks()[0][0];
                    double askSecondStart = orderBook.getAsks()[1][0];

                    if (lastSellOrder == null || lastSellOrder.getId() == null) {
                        double bidPrice = round(askStart - 0.01, 2);
                        if (bidPrice < this.end) {
                            System.out.println(this.type + "için satýþ fiyatý çok düþük: " + bidPrice);
                            Thread.sleep(1000);
                            continue;
                        }
                        double currentAmount = calculateAmount(bidPrice, type);
                        if (currentAmount == 0) {
                            System.out.println("Satmak için yeterli btc yok, bekleniyor");
                            Thread.sleep(1000);
                            continue;
                        }
                        Optional<OrderResult> orderResult = btcTraderClient.sellBTCTraderOrder(0, bidPrice, currentAmount, 0);
                        orderResult.ifPresent(result -> this.lastSellOrder = result);
                    } else {
                        if (askStart != lastSellOrder.getPrice()) {
                            Optional<CancelOrderResult> cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastSellOrder.getId());
                            int i = 0;
                            while ((!cancelOrderResult.isPresent() || !cancelOrderResult.get().isResult()) && i < 5) {
                                i++;
                                System.out.println("Son iþlem silinemiyor!");
                                Thread.sleep(1000);
                                cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastSellOrder.getId());
                            }
                            this.lastSellOrder = null;

                            double bidPrice = round(askStart - 0.01, 2);
                            if (bidPrice < this.end) {
                                System.out.println(this.type + "için satýþ fiyatý çok düþük: " + bidPrice);
                                Thread.sleep(1000);
                                continue;
                            }
                            double currentAmount = calculateAmount(bidPrice, type);
                            if (currentAmount == 0) {
                                System.out.println("Satmak için yeterli btc yok, bekleniyor");
                                Thread.sleep(1000);
                                continue;
                            }
                            Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, currentAmount, 0);
                            orderResult.ifPresent(result -> this.lastSellOrder = result);
                        } else if (round(askSecondStart - lastSellOrder.getPrice(), 2) > 0.01) {
                            Optional<CancelOrderResult> cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastSellOrder.getId());
                            int i = 0;
                            while ((!cancelOrderResult.isPresent() || !cancelOrderResult.get().isResult()) && i < 5) {
                                i++;
                                System.out.println("Son iþlem silinemiyor!");
                                Thread.sleep(1000);
                                cancelOrderResult = btcTraderClient.cancelBTCTraderOrder(lastSellOrder.getId());
                            }
                            this.lastSellOrder = null;

                            double bidPrice = askSecondStart - 0.01;
                            if (bidPrice < this.end) {
                                System.out.println(this.type + "için satýþ fiyatý çok düþük: " + bidPrice);
                                Thread.sleep(1000);
                                continue;
                            }
                            double currentAmount = calculateAmount(bidPrice, type);
                            if (currentAmount == 0) {
                                System.out.println("Satmak için yeterli btc yok, bekleniyor");
                                Thread.sleep(1000);
                                continue;
                            }
                            Optional<OrderResult> orderResult = btcTraderClient.buyBTCTraderOrder(0, bidPrice, currentAmount, 0);
                            orderResult.ifPresent(result -> this.lastSellOrder = result);
                        }
                    }


//                    orderBook = orderBookOptional.get();
//
//                    double bidStart = orderBook.getAsks()[0][0];
//
//                    if (bidStart < this.end) {
//                        return;
//                    }

                    // check that lowest price is our order

                    // cancel old sell orders
//                    openOrders = btcTraderClient.getBTCTraderOpenOrders();
//
//                    openOrders.stream()
//                            .filter(order -> order.getType().equals("SellBtc"))
//                            .filter(order -> order.getPrice() > bidStart)
//                            .forEach(order -> btcTraderClient.cancelBTCTraderOrder(order.getId()));
//
//                    double bidPrice = bidStart - 0.01;

//                    double currentAmount = calculateAmount(bidPrice, type);
//                    if (currentAmount == 0) {
//                        System.out.println("BTC almak için yeterli para yok, bekleniyor");
//                        Thread.sleep(1000);
//                        continue;
//                    }
//                    btcTraderClient.sellBTCTraderOrder(0, bidPrice, currentAmount, 0);


                }
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private double calculateAmount(double bidPrice, OrderType type) {
        Optional<BalanceResult> btcTraderBalance = BTCTraderClientFactory.getInstance().getBTCTraderBalance();
        if (btcTraderBalance.isPresent()) {
            BalanceResult balanceResult = btcTraderBalance.get();
            if (type == OrderType.BUY) {
                double fee = balanceResult.getMakerFeePercentage();
                double money = balanceResult.getMoneyAvailable();
                money -= round(money * fee, 2);
                double amount = money / bidPrice;
                return round(amount, 8);
            } else if (type == OrderType.SELL) {
                return balanceResult.getBitcoinAvailable();
            }
        }
        return 0;
    }

    public static double round(double value, int places) {
//        if (places < 0) throw new IllegalArgumentException();

//        long factor = (long) Math.pow(10, places);
//        value = value * factor;
//        long tmp = Math.round(value);
//        return (double) tmp / factor;

        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
