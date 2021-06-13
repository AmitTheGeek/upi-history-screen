package com.onebanc.transaction.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onebanc.transaction.R;
import com.onebanc.transaction.network.TransactionApi;
import com.onebanc.transaction.pojo.TransactionHistory;
import com.onebanc.transaction.ui.TransactionAdapter;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        recyclerView = findViewById(R.id.recyclerview);

    }


    @Override
    public void onResume() {
        super.onResume();
        fetchTransactionInfo();
    }

    public void fetchTransactionInfo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TransactionApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransactionApi transactionApi = retrofit.create(TransactionApi.class);
        Call<TransactionHistory> call = transactionApi.getTransactionHistory(1, 2);

        call.enqueue(new Callback<TransactionHistory>() {
            @Override
            public void onResponse(Call<TransactionHistory> call, Response<TransactionHistory> response) {
                TransactionHistory transactionHistory = response.body();

                Log.d(TAG, "onResponse: " + transactionHistory.getTransactions().toString());
                Collections.sort(transactionHistory.getTransactions());

                TransactionAdapter adapter = new TransactionAdapter(transactionHistory, TransactionActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(TransactionActivity.this));

            }

            @Override
            public void onFailure(Call<TransactionHistory> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(TransactionActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}