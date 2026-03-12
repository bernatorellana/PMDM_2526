package com.example.mangaapi.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mangaapi.adapter.MangaAdapter;
import com.example.mangaapi.api.MangaApi;
import com.example.mangaapi.api.MangaApiService;
import com.example.mangaapi.api.model.MangaList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<MangaList> mangaList = new MutableLiveData<>();

    public MutableLiveData<MangaList> getMangaList() {
        return mangaList;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        MangaApi api = MangaApiService.getMangaAPI();

        Log.d("XXXXX", "Inici de la descàrrega: ");
        api.getManga().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (result) -> {
                            Log.d("XXX", result.toString());
                            mangaList.setValue(result);
                        },
                        error -> {
                            Log.e("XXX", "error de descàrrega ", error);
                        }

                );
    }
}
