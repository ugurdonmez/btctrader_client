package com.ugurdonmez.data;

import com.google.common.collect.ImmutableList;

/**
 * Created by ugurdonmez on 29/07/16.
 */
public class DepositMoneyResult {

    private final String id;
    private final String deposit_code;
    private ImmutableList<Bank> banks;
    private final String currency_type;
    private final double amount;
    private final String first_name;
    private final String last_name;
    private final String account_owner;

    public DepositMoneyResult(String id, String deposit_code, ImmutableList<Bank> banks,
                              String currency_type, double amound, String first_name,
                              String last_name, String account_owner) {
        this.id = id;
        this.deposit_code = deposit_code;
        this.banks = banks;
        this.currency_type = currency_type;
        this.amount = amound;
        this.first_name = first_name;
        this.last_name = last_name;
        this.account_owner = account_owner;
    }

    public String getId() {
        return id;
    }

    public String getDepositCode() {
        return deposit_code;
    }

    public ImmutableList<Bank> getBanks() {
        return banks;
    }

    public String getCurrencyType() {
        return currency_type;
    }

    public double getAmount() {
        return amount;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getAccountOwner() {
        return account_owner;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("Deposit Money Result").append('\n');
        buf.append("Id: ").append(this.id).append('\n');
        buf.append("Deposit Code ").append(this.deposit_code).append('\n');
        buf.append("Banks").append('\n');
        for (Bank bank : banks) {
            buf.append('\t').append(bank).append('\n');
        }
        buf.append("Currency Type ").append(this.currency_type).append('\n');
        buf.append("Amount").append(this.amount).append('\n');
        buf.append("First Name ").append(this.first_name).append('\n');
        buf.append("Last Name ").append(this.last_name).append('\n');
        buf.append("Account Owner ").append(this.account_owner).append('\n');
        buf.append("\n");

        return buf.toString();
    }
}

class Bank {

    private final String bank_name;
    private final String iban;

    public Bank(String bank_name, String iban) {
        this.bank_name = bank_name;
        this.iban = iban;
    }

    public String getBankName() {
        return bank_name;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank_name='" + bank_name + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}