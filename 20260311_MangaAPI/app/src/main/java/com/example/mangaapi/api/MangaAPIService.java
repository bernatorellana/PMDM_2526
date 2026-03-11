package com.example.mangaapi.api;

public class MangaAPIService
{
    @GET("/manga")
    Call<List<Manga>> getMangas(@Path("tile") String titol);
}
