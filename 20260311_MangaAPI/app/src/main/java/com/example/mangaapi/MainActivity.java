package com.example.mangaapi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.mangaapi.adapter.MangaAdapter;
import com.example.mangaapi.api.MangaApi;
import com.example.mangaapi.api.MangaApiService;
import com.example.mangaapi.api.model.MangaList;
import com.example.mangaapi.databinding.ActivityMainBinding;
import com.example.mangaapi.viewmodel.MainActivityViewModel;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


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

       // Agafar el view model amb el view model provider
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getMangaList().observe(this, (result) -> {
            adapter = new MangaAdapter(this, result);
            binding.rcyManga.setAdapter(adapter);
        });
    }
}