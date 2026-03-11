package com.example.mangaapi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mangaapi.api.MangaApi;
import com.example.mangaapi.api.MangaApiService;
import com.example.mangaapi.api.model.MangaList;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MangaList mangaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        MangaApi api = MangaApiService.getMangaAPI();

        api.getManga().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (result) -> {
                            Log.d("XXX", result.toString());
                            mangaList = result;
                        },
                        error -> {
                            Log.e("XXX", "error de descàrrega ", error);

                        }

                );

    }
}