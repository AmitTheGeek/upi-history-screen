package com.onebanc.transaction.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.onebanc.transaction.R;

public class TransactionViewHolder extends RecyclerView.ViewHolder {

    private TextView amount;
    private TextView transactionId;
    private TextView transactionIdNum;
    private TextView transactionStatus;
    private Button firstButton;
    private Button secondButton;
    private RelativeLayout cardViewWrapper;
    private TextView date;
    private LinearLayout transactionIdDetails;
    private LinearLayout buttonDetails;
    private ImageView transactionStatusImg;

    public TransactionViewHolder(@NonNull View layout) {
        super(layout);
        amount = layout.findViewById(R.id.amount);
        cardViewWrapper = layout.findViewById(R.id.cardViewWrapper);
        date = layout.findViewById(R.id.date);
        transactionId = layout.findViewById(R.id.transactionId);
        transactionIdNum = layout.findViewById(R.id.transactionIdtxt);
        firstButton = layout.findViewById(R.id.firstButton);
        secondButton = layout.findViewById(R.id.secondButton);
        transactionIdDetails = layout.findViewById(R.id.transactionIdDetails);
        buttonDetails = layout.findViewById(R.id.buttonDetails);
        transactionStatusImg = layout.findViewById(R.id.transactionStatusImg);
        transactionStatus = layout.findViewById(R.id.transactionStatustxt);

    }

    @Override
    public String toString() {
        return super.toString();
    }


    public TextView getAmount() {
        return amount;
    }

    public TextView getTransactionId() {
        return transactionId;
    }

    public TextView getTransactionIdNum() {
        return transactionIdNum;
    }

    public TextView getTransactionStatus() {
        return transactionStatus;
    }

    public Button getFirstButton() {
        return firstButton;
    }

    public Button getSecondButton() {
        return secondButton;
    }

    public RelativeLayout getCardViewWrapper() {
        return cardViewWrapper;
    }

    public TextView getDate() {
        return date;
    }

    public LinearLayout getTransactionIdDetails() {
        return transactionIdDetails;
    }

    public LinearLayout getButtonDetails() {
        return buttonDetails;
    }

    public ImageView getTransactionStatusImg() {
        return transactionStatusImg;
    }
}
