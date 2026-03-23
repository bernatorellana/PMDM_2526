package com.example.fragmentshelloworld.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.fragmentshelloworld.R;
import com.example.fragmentshelloworld.viewmodel.IMCViewModel;


public class AlcadaFragment extends Fragment {

    private IMCViewModel mViewModel;

    public AlcadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_alcada, container, false);

        mViewModel = ViewModelProviders.of(this.requireActivity()).get(IMCViewModel.class);

        EditText edtAlcada = v.findViewById(R.id.edtAlcada);

        edtAlcada.setText(""+mViewModel.getAlcada());


        edtAlcada.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                try{
                    int alcada = Integer.parseInt(s.toString());
                    mViewModel.setAlcada(alcada);
                }catch(NumberFormatException e){
                    mViewModel.setAlcada(0);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        return v;
    }
}