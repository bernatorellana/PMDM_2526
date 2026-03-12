package com.example.mangaapi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.mangaapi.adapter.MangaAdapter;
import com.example.mangaapi.api.MangaApi;
import com.example.mangaapi.api.MangaApiService;
import com.example.mangaapi.api.model.MangaList;
import com.example.mangaapi.databinding.ActivityMainBinding;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MangaList mangaList;
    private ActivityMainBinding binding;
    private MangaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // usar view binding per carregar el layout i assginar a variable global
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configura el recycler view com una graella
        binding.rcyManga.setLayoutManager(new GridLayoutManager(this, 2));

        //crear adapter

        MangaApi api = MangaApiService.getMangaAPI();

        api.getManga().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (result) -> {
                            Log.d("XXX", result.toString());
                            mangaList = result;
                            adapter = new MangaAdapter(this, mangaList);
                            binding.rcyManga.setAdapter(adapter);

                        },
                        error -> {
                            Log.e("XXX", "error de descàrrega ", error);

                        }

                );


    }
}