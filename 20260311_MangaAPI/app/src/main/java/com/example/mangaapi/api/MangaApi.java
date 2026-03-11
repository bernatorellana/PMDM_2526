package com.example.mangaapi.api;

import com.example.mangaapi.api.model.MangaList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MangaApi {

    @GET("manga")
    Single<MangaList> getManga();

    @GET("manga")
    Single<MangaList> getMangaPerTitle(@Query("title") String title);

    //@GET("manga/{manga_id}/feed")
    //Single<CardSet> getChapters(@Path("manga_id") int mangaId);

}
