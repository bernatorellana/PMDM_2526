package com.example.tinderapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tinderapp.Model.Person;
import com.example.tinderapp.Model.Provincia;
import com.example.tinderapp.databinding.ActivityMainBinding;
import com.example.tinderapp.utils.MyTextWatcher;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private int indexActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        indexActual = 1;

        carregaSpinner();

        showPersonaActual();

        programarBotons();

        programarTextChanged();

        programarSpinnerChanged();

    }

    private void programarSpinnerChanged() {

        

    }

    private void programarTextChanged() {
        binding.edtNom.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Person actual = Person.getPersones().get(indexActual);
                actual.setNom(s.toString());
            }
        });
        binding.edtDNI.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Person actual = Person.getPersones().get(indexActual);
                actual.setNIF(s.toString());
            }
        });
    }
    private void programarBotons() {
        binding.btnLeft.setOnClickListener(view -> {
            Log.d("TAG", "btn left: "+indexActual);
            if(indexActual>=1){
                indexActual--;
                showPersonaActual();
            }
      });
        binding.btnRight.setOnClickListener(view -> {

            Log.d("TAG", "btn right: "+indexActual);
            if(indexActual<Person.getPersones().size()-1){
                indexActual++;
                showPersonaActual();
            }
        });
    }

    private void carregaSpinner() {

        binding.spnProvincia.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Provincia.getProvincies()));

    }

    private void showPersonaActual() {
        Person actual = Person.getPersones().get(indexActual);

        binding.edtNom.setText(actual.getNom());
        binding.edtDNI.setText(actual.getNIF());

        Provincia p = actual.getProv();

        binding.spnProvincia.setSelection(Provincia.getProvincies().indexOf(p));
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
