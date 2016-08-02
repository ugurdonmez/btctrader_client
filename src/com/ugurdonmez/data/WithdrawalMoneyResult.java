package com.ugurdonmez.data;

import com.google.common.collect.ImmutableList;

/**
 * Created by ugurdonmez on 29/07/16.
 */
public class WithdrawalMoneyResult {

    private final String iban;
    private final ImmutableList<BankList> bank_list;
    private final ImmutableList<BankList> friendly_name_list;
    private final String bank_name;
    private final double amount;
    private final boolean has_balance_request;
    private final String balance_request_id;

    public WithdrawalMoneyResult(String iban, ImmutableList<BankList> bank_list,
                                 ImmutableList<BankList> friendly_name_list, String bank_name,
                                 double amount, boolean has_balance_request, String balance_request_id) {
        this.iban = iban;
        this.bank_list = bank_list;
        this.friendly_name_list = friendly_name_list;
        this.bank_name = bank_name;
        this.amount = amount;
        this.has_balance_request = has_balance_request;
        this.balance_request_id = balance_request_id;
    }

    public String getIban() {
        return iban;
    }

    public ImmutableList<BankList> getBank_list() {
        return bank_list;
    }

    public ImmutableList<BankList> getFriendly_name_list() {
        return friendly_name_list;
    }

    public String getBank_name() {
        return bank_name;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isHas_balance_request() {
        return has_balance_request;
    }

    public String getBalance_request_id() {
        return balance_request_id;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("Withdrawal Money Result").append('\n');
        buf.append("IBAN: ").append(this.iban).append('\n');
        buf.append("Bank List").append('\n');
        for (BankList bank : bank_list) {
            buf.append('\t').append(bank).append('\n');
        }
        buf.append("Friendly Name List").append('\n');
        for (BankList bank : friendly_name_list) {
            buf.append('\t').append(bank).append('\n');
        }
        buf.append("Bank Name ").append(this.bank_name).append('\n');
        buf.append("Amount ").append(this.amount).append('\n');
        buf.append("Has Balance Request ").append(this.has_balance_request).append('\n');
        buf.append("Balance Request Id ").append(this.balance_request_id).append('\n');

        return buf.toString();
    }
}

class BankList {
    private final String key;
    private final String value;

    public BankList(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BankList{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}