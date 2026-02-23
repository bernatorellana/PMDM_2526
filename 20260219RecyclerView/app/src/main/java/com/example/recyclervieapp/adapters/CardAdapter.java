package com.example.recyclervieapp.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclervieapp.R;
import com.example.recyclervieapp.model.Card;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  parent.inflate(parent.getContext(), R.layout.row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card current = Card.getCartes().get(position);
        holder.imvImag.setImageResource(current.getDrawable());
        holder.txvName.setText(current.getName());
        holder.txvDesc.setText(current.getDesc());
        holder.txvElixirCost.setText(""+current.getElixirCost());
        
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
