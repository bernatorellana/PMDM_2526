package com.example.mangaapi.api;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MangaApiService {


    @NonNull
    public static MangaApi getMangaAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mangadex.org/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MangaApi service = retrofit.create(MangaApi.class);
        return service;
    }
}
