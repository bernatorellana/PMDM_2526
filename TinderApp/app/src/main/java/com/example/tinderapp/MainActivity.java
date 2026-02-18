package com.example.tinderapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tinderapp.Model.Person;
import com.example.tinderapp.Model.Sexe;
import com.example.tinderapp.Model.Provincia;
import com.example.tinderapp.databinding.ActivityMainBinding;
import com.example.tinderapp.utils.MyTextWatcher;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private int indexActual;

    private ActivityMainBinding binding;

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

        programarRadioGroup();

    }

    private void programarRadioGroup() {



        binding.rgSexe.setOnCheckedChangeListener(
                (group,  checkedId )->{

                    HashMap<Integer, Sexe> mapa= new HashMap<>(){{
                            put(R.id.rbtHome, Sexe.HOME);
                            put(R.id.rbtDona, Sexe.DONA);
                            put(R.id.rbtNC,  Sexe.N_C);
                    }};

                    Person  p = getPersonaActual();
                    p.setSexe(mapa.get(checkedId));
        });



    }

    private void programarSpinnerChanged() {
        binding.spnProvincia.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person actual = getPersonaActual();
                actual.setProv(Provincia.getProvincies().get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Person actual = getPersonaActual();
                actual.setProv(null);
            }
        } );
    }

    private void programarTextChanged() {
        binding.edtNom.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Person actual = getPersonaActual();
                actual.setNom(s.toString());
            }
        });
        binding.edtDNI.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Person actual = getPersonaActual();
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

    private Person getPersonaActual(){
        return Person.getPersones().get(indexActual);
    }

    private void showPersonaActual() {
        Person actual = getPersonaActual();

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
