package com.example.recyclervieapp;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclervieapp.adapters.CardAdapter;
import com.example.recyclervieapp.model.Card;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements CardAdapter.OnCardClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anem a buscar el recycler
        RecyclerView recyclerView = findViewById(R.id.rcyCards);
        // Configurem el recycler en mode llista
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Creem l'adapter
        CardAdapter adapter = new CardAdapter(this, this);
        //Afegim l'adapter al recycler
        recyclerView.setAdapter(adapter);

    }

    public void onCardClicked(Card c){

    }


    @Override
    public void onCardClicked(Card c, int position) {
        Snackbar.make(this.findViewById(android.R.id.content), "HOLA "+ c.getName(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCardLongClicked(Card c, int position) {

    }
}