package com.example.fragmentshelloworld.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class IMCViewModel extends AndroidViewModel {

    private int pes;
    private int alcada;

    public IMCViewModel(@NonNull Application application) {
        super(application);
    }

    public double calcularIMC(){
        double altura = alcada/100.0;
        return pes/(altura*altura);
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public int getAlcada() {
        return alcada;
    }

    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }
}
