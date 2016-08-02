/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurdonmez.client;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.ugurdonmez.data.*;
import data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.iharder.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.ugurdonmez.setting.Constants;
import com.ugurdonmez.setting.ServicePrefix;

/**
 *
 * @author ugurdonmez
 */
public class BTCTraderServices {

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<TickerResult> getTicker(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getTickerURL();;

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), TickerResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<OrderBookResult> getOrderBook(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getOrderBookURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), OrderBookResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static ImmutableList<Trade> getTradesList(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getTradesURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return ImmutableList.of(g.fromJson(response.toString(), Trade[].class));
        } else {
            return ImmutableList.of();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static ImmutableList<OHCLData> getOHCLDataList(AuthenticationResult authenticationResult)
            throws IOException,
            InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getOhclDataURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return ImmutableList.of(g.fromJson(response.toString(), OHCLData[].class));
        } else {
            return ImmutableList.of();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<BalanceResult> getBalance(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException,
            NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getAccountBalanceURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), BalanceResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static ImmutableList<UserTransaction> getUserTransactionList(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getUserTransactionURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return ImmutableList.of(g.fromJson(response.toString(), UserTransaction[].class));
        } else {
            return ImmutableList.of();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static ImmutableList<OrderResult> getOpenOrderList(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getOpenOrderURL();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return ImmutableList.of(g.fromJson(response.toString(), OrderResult[].class));
        } else {
            return ImmutableList.of();
        }
    }

    /**
     *
     * @param orderId
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<CancelOrderResult> postCancelOrder(String orderId, AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getCancelOrderURL();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id", String.valueOf(orderId)));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), CancelOrderResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param isMarketOrder
     * @param price
     * @param amount
     * @param total
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<OrderResult> postBuyOrder(int isMarketOrder, double price, double amount,
                                                     double total, AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getBuyURL();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Type", "BuyBtc"));
        params.add(new BasicNameValuePair("IsMarketOrder", String.valueOf(isMarketOrder)));
        params.add(new BasicNameValuePair("Price", String.valueOf(price)));
        params.add(new BasicNameValuePair("Amount", String.valueOf(amount)));
        params.add(new BasicNameValuePair("Total", String.valueOf(total)));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), OrderResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param isMarketOrder
     * @param price
     * @param amount
     * @param total
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<OrderResult> postSellOrder(boolean isMarketOrder, double price, double amount,
                                                      double total, AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getSellURL();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Type", "SellBtc"));
        params.add(new BasicNameValuePair("IsMarketOrder", String.valueOf(isMarketOrder)));
        params.add(new BasicNameValuePair("Price", String.valueOf(price)));
        params.add(new BasicNameValuePair("Amount", String.valueOf(amount)));
        params.add(new BasicNameValuePair("Total", String.valueOf(total)));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), OrderResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<DepositMoneyResult> getMoneyDepositInfo(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getGetDepositMoneyInfo();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), DepositMoneyResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param amount
     * @param amountPrecision
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<DepositMoneyResult> postMoneyDeposit(double amount, double amountPrecision,
                                                                AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getDepositMoney();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Amount", String.valueOf(amount)));
        params.add(new BasicNameValuePair("AmountPrecision", String.valueOf(amountPrecision)));

        HttpURLConnection request = Common.makePostRequest(sURL, authenticationResult, params);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), DepositMoneyResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param authenticationResult
     * @return
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static Optional<WithdrawalMoneyResult> getMoneyWithdrawalInfo(AuthenticationResult authenticationResult)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        String sURL = Constants.API_PREFIX + ServicePrefix.getGetMoneyWithdrawalInfo();

        HttpURLConnection request = Common.makeGetRequest(sURL, authenticationResult);

        if (request.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson g = new Gson();
            return Optional.of(g.fromJson(response.toString(), WithdrawalMoneyResult.class));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    protected static AuthenticationResult getAuthentication()
            throws MalformedURLException, IOException,
            InvalidKeyException, NoSuchAlgorithmException {
        
        String unixTimeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String data = Constants.API_PUBLIC_KEY + unixTimeStamp;

        byte[] secretKey = javax.xml.bind.DatatypeConverter.parseBase64Binary(Constants.API_PRIVATE_KEY);
        SecretKeySpec signingKey = new SecretKeySpec(secretKey, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] bytes = data.getBytes("UTF-8");
        byte[] rawHmac = mac.doFinal(bytes);

        return new AuthenticationResult(unixTimeStamp, Base64.encodeBytes(rawHmac));
    }
}
