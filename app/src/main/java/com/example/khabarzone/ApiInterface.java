package com.example.khabarzone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";
//    val BASE_URL ==

    @GET("top-headlines")
    Call<NewsData> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String api);


    @GET("top-headlines")
    Call<NewsData> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String api);

//    @GET("top-headlines")
//    fun getNews(
//        @Query("country") country: String,
//        @Query("pageSize") pagesize: Int,
//        @Query("apiKey") api: String
//    )
//
//    @GET


}
