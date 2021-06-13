package com.onebanc.transaction.network;

import com.onebanc.transaction.pojo.TransactionHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TransactionApi {
    String BASE_URL = "https://dev.onebanc.ai/assignment.asmx/";
    @GET("GetTransactionHistory")
    Call<TransactionHistory> getTransactionHistory(@Query("userId") int userId, @Query("recipientId") int recipientId);
}
