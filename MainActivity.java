package com.example.saarang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    Button pay;
    Button transfer;
    Button add;
    LinearLayoutCompat pay_icon_layout;
    LinearLayoutCompat transfer_icon_layout;
    LinearLayoutCompat add_icon_layout;
    TextView amount;

    Intent proceed_pay;
    Intent proceed_transfer;
    Intent proceed_add;

    private ProgressBar pBaramount;
    private ProgressBar pBartransaction;



    final Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pay=findViewById(R.id.pay_text);
        transfer=findViewById(R.id.transfer_text);
        add=findViewById(R.id.add_text);
        pay_icon_layout= findViewById(R.id.pay_icon_layout);
        transfer_icon_layout= findViewById(R.id.transfer_icon_layout);
        add_icon_layout= findViewById(R.id.add_icon_layout);
        pBaramount=findViewById(R.id.pBaramount);
        pBartransaction=findViewById(R.id.pBartransaction);

        pBaramount.setVisibility(v.VISIBLE);
        pBartransaction.setVisibility(v.VISIBLE);





        pay_icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceed_pay=new Intent(context,Pay.class);
                context.startActivity(proceed_pay);

            }
        });




        transfer_icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceed_transfer=new Intent(context,Transfer.class);
                context.startActivity(proceed_transfer);

            }
        });



        add_icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceed_add=new Intent(context, Add.class);
                context.startActivity(proceed_add);

            }
        });

        String response = "{"amount":400 ,
                            "transactions" : [
                                    {"transaction_name":"Popular Night-Gold","transaction_amount":400,"transaction_date":"11-12-2019"},
                                    {"transaction_name":"EDM Night-Gallery","transaction_amount":150,"transaction_date":"10-12-2019"},
                                    {"transaction_name":"Choreo Night-Gallery","transaction_amount":150,"transaction_date":"10-12-2019"},
                                    {"transaction_name":"Popular Night-Gold","transaction_amount":400,"transaction_date":"09-12-2019"}]
                            }"


        public void handleResponse(String response)
                 {
                    if(response==null) {
                        //error
                    }
                    else{
                        Gson gson =new Gson();


                        Content content= gson.fromJson(response, Content.class);

                        pBaramount.setVisibility(v.GONE);
                         pBartransaction.setVisibility(v.GONE);

                        amount=findViewById(R.id.amount);
                        TransactionModel[] transactions=new TransactionModel[];








                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                         RecentTransactionsAdapter recentTransactionsAdapter =new RecentTransactionsAdapter(transactions);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(recentTransactionsAdapter);

                        amount.setText(content.amount);


                    }





                 }







    }
}
