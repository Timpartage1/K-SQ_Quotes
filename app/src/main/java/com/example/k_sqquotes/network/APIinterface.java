package com.example.k_sqquotes.network;

import com.example.k_sqquotes.model.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("quotes.php")
    Call<List<Quote>> getQuote();

}
