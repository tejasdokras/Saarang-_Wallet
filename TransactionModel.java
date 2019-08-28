package com.example.saarang;

import com.google.gson.annotations.SerializedName;

public class TransactionModel {

    @SerializedName("transaction_name")
    public String transaction_name;
    @SerializedName("transaction_amount")
    public String transaction_amount;
    @SerializedName("transaction_date")
    public String transaction_date;

    public TransactionModel(String transaction_name,String transaction_amount,String transaction_date)
    {
        this.transaction_name=transaction_name;
        this.transaction_amount=transaction_amount;
        this.transaction_date=transaction_date;

    }
     public String getTransaction_name(){
        return transaction_name;
     }
    public void setTransaction_name(String transaction_name){
          this.transaction_name=transaction_name;
    }
    public String getTransaction_amount(){
        return transaction_amount;
    }
    public void setTransaction_amount(String transaction_amount){
        this.transaction_amount=transaction_amount;
    }
    public String getTransaction_date(){
        return transaction_date;
    }
    public void setTransaction_date(String transaction_date){
        this.transaction_date=transaction_date;
    }

}
