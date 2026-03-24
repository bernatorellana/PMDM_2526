package com.example.fragmentshelloworld.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmentshelloworld.R;
import com.example.fragmentshelloworld.viewmodel.IMCViewModel;


public class PesFragment extends Fragment {

    private IMCViewModel mViewModel;

    public PesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pes, container, false);

        mViewModel = ViewModelProviders.of(this.requireActivity()).get(IMCViewModel.class);

        EditText edtPes = v.findViewById(R.id.edtPes);
        edtPes.setText(""+mViewModel.getPes());

        edtPes.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                try{
                    int pes = Integer.parseInt(s.toString());
                    mViewModel.setPes(pes);
                }catch(NumberFormatException e){
                    mViewModel.setPes(0);
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