package com.example.mangaapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapi.R;
import com.example.mangaapi.api.model.Manga;
import com.example.mangaapi.api.model.MangaList;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    private MangaList mangaList;
    private Context ctxt;
    public MangaAdapter( Context ctxt,  MangaList mangaList){
        this.mangaList = mangaList;
        this.ctxt = ctxt;
    }

    @NonNull
    @Override
    public MangaAdapter.MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout row.xml
        View view = LayoutInflater.from(ctxt).inflate(R.layout.row, parent, false);
        // crear view holder
        MangaViewHolder holder = new MangaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MangaAdapter.MangaViewHolder holder, int position) {
        //agafar el manga a la posició position
        Manga m = mangaList.getData().get(position);
        holder.txvTitle.setText(m.getAttributes().getTitle().getTitle());


        holder.txvDesc.setText(
                retalla(m.getAttributes().getDescription().getEn(), 100));
    }

    public String retalla(String s, int n){
        if(s.length()>n) return s.substring(0,n)+"...";
        else return s;
    }

    @Override
    public int getItemCount() {
        return mangaList.getData().size();
    }

    public class MangaViewHolder extends RecyclerView.ViewHolder {
        // crear variables pels views de row.xml
        TextView txvTitle;
        TextView txvDesc;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);
            txvTitle = itemView.findViewById(R.id.txvTitle);
            txvDesc = itemView.findViewById(R.id.txvDesc);
        }
    }
}
