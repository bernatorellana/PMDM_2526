package com.example.scorerapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.scorerapp.databinding.ActivityMainBinding;
import com.example.scorerapp.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("MainActivity", "onCreate");

        super.onCreate(savedInstanceState);

        // carregar el view model
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


        //setContentView(R.layout.activity_main);
        // carreguem el layout amb el binding, i desem el binding en una variable global
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mostrarScore();

        binding.btnLocalPlus.setOnClickListener(v -> {

            viewModel.incLocal(1);
            mostrarScore();
        });
        binding.btnVisitorPlus.setOnClickListener(v -> {
            viewModel.incVisitant(1);
            mostrarScore();
        });
        binding.btnLocalMinus.setOnClickListener(v -> {
            viewModel.incLocal(-1);
            mostrarScore();
        });
        binding.btnVisitorMinus.setOnClickListener(v -> {
            viewModel.incVisitant(-1);
            mostrarScore();
        });

    }

    private void mostrarScore() {
        //mostrar valors local i visitant als textboxes
        binding.txvLocalScore.setText(String.valueOf(viewModel.getLocal()));
        binding.txvVisitorScore.setText(String.valueOf(viewModel.getVisitant()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.save();
    }
}