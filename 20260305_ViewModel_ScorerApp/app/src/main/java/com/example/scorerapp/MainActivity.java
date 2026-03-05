package com.example.scorerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.scorerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    int local=0;
    int visitant=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // carreguem el layout amb el binding, i desem el binding en una variable global
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mostrarScore();


        binding.btnLocalPlus.setOnClickListener(v -> {
            local++;
            mostrarScore();
        });
        binding.btnVisitorPlus.setOnClickListener(v -> {
            visitant++;
            mostrarScore();
        });
        binding.btnLocalMinus.setOnClickListener(v -> {
            local--;
            mostrarScore();
        });
        binding.btnVisitorMinus.setOnClickListener(v -> {
            visitant--;
            mostrarScore();
        });

    }

    private void mostrarScore() {
        //mostrar valors local i visitant als textboxes
        binding.txvLocalScore.setText(String.valueOf(local));
        binding.txvVisitorScore.setText(String.valueOf(visitant));

    }
}