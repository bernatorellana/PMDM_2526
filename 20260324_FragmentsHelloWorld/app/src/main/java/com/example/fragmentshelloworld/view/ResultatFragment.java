package com.example.fragmentshelloworld.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmentshelloworld.R;
import com.example.fragmentshelloworld.viewmodel.IMCViewModel;


public class ResultatFragment extends Fragment {

    private IMCViewModel mViewModel;

    public ResultatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_resultat, container, false);


        mViewModel = ViewModelProviders.of(this.requireActivity()).get(IMCViewModel.class);

        TextView txvIMC = v.findViewById(R.id.txtResultat);

        double IMC = mViewModel.calcularIMC();
        // Convertir mViewModel.calcularIMC() en un String amb dos decimals
        String IMCs = String.format("%.2f", IMC);

        txvIMC.setText(IMCs);

        return v;
    }
}