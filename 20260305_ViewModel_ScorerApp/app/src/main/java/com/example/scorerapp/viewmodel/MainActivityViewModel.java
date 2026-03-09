package com.example.scorerapp.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    int local=0;
    int visitant=0;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);


        Log.d("XXXXX", "Estic tornant a crear el ViewModel");
        SharedPreferences sp = getApplication().getSharedPreferences("score", Activity.MODE_PRIVATE);
        local = sp.getInt("local", 0);
        visitant = sp.getInt("visitant", 0);


    }

    public int getLocal() {
        return local;
    }

    public int getVisitant() {
        return visitant;
    }

    //mètode per incrementar/decrementar el local
    public void incLocal(int increment)
    {
        local+=increment;
        if(local<0) local-=increment;
    }

    public void incVisitant(int increment)
    {
        visitant+=increment;
        if(visitant<0) visitant-=increment;
    }

    public void reset(){
        local=0;
        visitant=0;
    }

    public void save() {
        Log.d("MainActivity", "onPause");
        SharedPreferences sp = getApplication().getSharedPreferences("score", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("local", local);
        editor.putInt("visitant", visitant);
        editor.apply();
    }
}
