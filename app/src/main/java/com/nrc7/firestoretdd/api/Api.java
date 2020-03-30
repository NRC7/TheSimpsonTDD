package com.nrc7.firestoretdd.api;

import com.nrc7.firestoretdd.model.Pojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //quotes?count=20
    @GET("quotes?")
    Call<Pojo[]> getQuotes(@Query("count") int num);

    // https://thesimpsonsquoteapi.glitch.me/quotes?count=num&count=num

    // "https://thesimpsonsquoteapi.glitch.me/quotes?count=9"
}
