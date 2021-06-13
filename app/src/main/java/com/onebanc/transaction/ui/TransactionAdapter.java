package com.onebanc.transaction.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.onebanc.transaction.R;
import com.onebanc.transaction.pojo.Transaction;
import com.onebanc.transaction.pojo.TransactionHistory;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.onebanc.transaction.constants.TransactionConstants.*;


public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {
    private static final String TAG = "TransactionAdapter";
    private final TransactionHistory transactionHistory;
    private final Context context;

    public TransactionAdapter(TransactionHistory transactionHistory, Context context) {
        this.transactionHistory = transactionHistory;
        this.context = context;
    }


    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionHistory.getTransactions().get(position);
        holder.getAmount().setText(String.valueOf(transaction.getAmount()));
        holder.getTransactionStatus().setText(TRANSACTION_YOU_PAID);

        if(transaction.getDirection() == 2){
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.getCardViewWrapper().getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            holder.getCardViewWrapper().setLayoutParams(params);
        }

        if(transactionHistory.getTransactions().get(position).getType() == 1) {
            holder.getTransactionIdDetails().setVisibility(View.VISIBLE);
            holder.getTransactionId().setText(TRANSACTION_ID);
            holder.getTransactionIdNum().setText(String.valueOf(transaction.getId()));
            if(transaction.getDirection() == 2){
                holder.getTransactionStatus().setText(TRANSACTION_YOU_RECEIVED);
            }
        } else {
            holder.getButtonDetails().setVisibility(View.VISIBLE);
            holder.getTransactionStatusImg().setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_clock));
            if(transaction.getDirection() == 2){
                holder.getTransactionStatus().setText(TRANSACTION_REQUEST_RECEIVED);
                holder.getFirstButton().setText(TRANSACTION_PAY);
                holder.getSecondButton().setText(TRANSACTION_DECLINE);
            } else {
                holder.getTransactionStatus().setText(TRANSACTION_YOU_REQUESTED);
                holder.getSecondButton().setVisibility(View.GONE);
                holder.getFirstButton().setText(TRANSACTION_CANCEL);
            }
        }

        holder.getDate().setText(transactionHistory.getTransactions().get(position).getReadableDate());

    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_transaction, parent,false);
        TransactionViewHolder holder = new TransactionViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return transactionHistory.getTransactions().size();
    }

}
