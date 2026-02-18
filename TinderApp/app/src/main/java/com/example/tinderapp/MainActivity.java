package com.example.tinderapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tinderapp.Model.Person;
import com.example.tinderapp.Model.Provincia;
import com.example.tinderapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private int indexActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        indexActual=0;

        carregaSpinner();


        showPersonaActual();
    }

    private void carregaSpinner() {

        binding.spnProvincia.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Provincia.getProvincies()));

    }

    private void showPersonaActual() {
        Person actual = Person.getPersones().get(indexActual);

        binding.edtNom.setText(actual.getNom());
        binding.edtDNI.setText(actual.getNIF());
        binding.spnProvincia.setSelection(actual.getProv().getCodi()-1);
        binding.imgFoto.setImageResource(actual.getImatgeResource());
        switch (actual.getSexe()){
            case DONA:
                binding.rbtDona.setChecked(true);
                break;
            case HOME:
                binding.rbtHome.setChecked(true);
                break;
            case N_C:
                binding.rbtNC.setChecked(true);
                break;
        }
    }



    }
