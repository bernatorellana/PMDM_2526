package org.milaifontanals.magicthegathering;

import org.milaifontanals.magicthegathering.adapter.CardAdapter;
import org.milaifontanals.magicthegathering.databinding.ActivityMainBinding;
import org.milaifontanals.magicthegathering.viewmodel.MainActivityViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


public class MainActivity extends AppCompatActivity {


    private MainActivityViewModel viewModel;
    private CardAdapter adapter;


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Recuperem el binding amb la classe "màgica" d'Android DataBindingUtil
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);

        setContentView(binding.getRoot());
        binding.prgLoading.setVisibility(View.VISIBLE);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getCardList().observe(this,cards -> {
            binding.prgLoading.setVisibility(View.INVISIBLE);

            if (cards != null) {
                adapter = new CardAdapter(cards, this);
                binding.rcyCardList.setAdapter(adapter);
            } else {
                Toast.makeText(this, "Download error.", Toast.LENGTH_SHORT).show();
            }

        });

        binding.rcyCardList.setHasFixedSize(true);
        binding.rcyCardList.setLayoutManager(new GridLayoutManager(this,2));
    }
}