package com.example.recyclervieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

    private static final int NO_SELECCIONADA =-1 ;
    private int indexCartaSelecionada = NO_SELECCIONADA;

    private CardAdapter adapter;

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
        adapter = new CardAdapter(this, this);
        //Afegim l'adapter al recycler
        recyclerView.setAdapter(adapter);

        // connectar la ToolBar barMenu
        androidx.appcompat.widget.Toolbar t = findViewById(R.id.barMenu);
        this.setSupportActionBar(t);
    }


    @Override
    public void onCardClicked(Card c, int position) {
        indexCartaSelecionada = position;
        Snackbar.make(this.findViewById(android.R.id.content), "HOLA "+ c.getName(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCardLongClicked(Card c, int position) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== R.id.itmDelete) {
            adapter.removeItemSelected();
        } else if(item.getItemId()==R.id.itmDown){
           adapter.moveItemDown();
        } else if(item.getItemId()==R.id.itmUp){
            adapter.moveItemUp();
        }
        return true;
    }
}