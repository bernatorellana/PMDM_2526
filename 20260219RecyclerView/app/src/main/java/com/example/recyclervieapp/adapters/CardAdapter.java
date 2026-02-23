package com.example.recyclervieapp.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclervieapp.R;
import com.example.recyclervieapp.model.Card;
import com.example.recyclervieapp.model.Rarity;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;

    public CardAdapter(Context c){
        context = c;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = parent.inflate(parent.getContext(), R.layout.row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card current = Card.getCartes().get(position);
        holder.imvImag.setImageResource(current.getDrawable());
        holder.txvName.setText(current.getName());
        holder.txvDesc.setText(current.getDesc());
        holder.txvElixirCost.setText("" + current.getElixirCost());
        Rarity r = current.getRarity();
        int color = Color.WHITE;
        switch (r) {
            case EPIC:
                color = context.getColor(R.color.epic);
                break;
            case RARE:
                color = context.getColor(R.color.rare);
                break;
            case COMMON:
                color = context.getColor(R.color.common);
                break;
        }
        ColorStateList csl = ColorStateList.valueOf(color);
        holder.llyCard.setBackgroundTintList(csl);
    }

    @Override
    public int getItemCount() {
        return Card.getCartes().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imvImag;
        TextView txvName;
        TextView txvDesc;
        TextView txvElixirCost;
        LinearLayout llyCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvImag = itemView.findViewById(R.id.imvImag);
            txvName = itemView.findViewById(R.id.txvName);
            txvDesc = itemView.findViewById(R.id.txvDesc);
            txvElixirCost = itemView.findViewById(R.id.txvElixirCost);
            llyCard = itemView.findViewById(R.id.llyCard);
        }
    }
}
