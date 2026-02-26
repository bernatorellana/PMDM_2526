package com.example.recyclervieapp.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclervieapp.R;
import com.example.recyclervieapp.model.Card;
import com.example.recyclervieapp.model.Rarity;
import com.google.android.material.snackbar.Snackbar;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {


    public void setSeleccionat(int i) {
        this.selectedIndex = i;
    }

    public void removeItemSelected() {
        if(selectedIndex!=NOTHING_SELECTED) {
            Card.getCartes().remove(selectedIndex);
            notifyItemRemoved(selectedIndex);
            selectedIndex = NOTHING_SELECTED;
        }
    }

    public void moveItemDown() {
        if(selectedIndex!=NOTHING_SELECTED && selectedIndex<Card.getCartes().size()-1) {
            Card c = Card.getCartes().remove(selectedIndex);
            Card.getCartes().add(selectedIndex+1, c);
            selectedIndex ++;
            notifyItemChanged(selectedIndex);
            notifyItemChanged(selectedIndex-1);
            //notifyItemMoved(selectedIndex, selectedIndex+1);
        }
    }

    public void moveItemUp() {
        if(selectedIndex!=NOTHING_SELECTED && selectedIndex>0) {
            Card c = Card.getCartes().remove(selectedIndex-1);
            Card.getCartes().add(selectedIndex, c);
            selectedIndex --;
            notifyItemChanged(selectedIndex);
            notifyItemChanged(selectedIndex+1);
        }
    }

    public interface OnCardClicked{
        void onCardClicked(Card c, int position);
        void onCardLongClicked(Card c, int position);
    }

    private OnCardClicked listener;
    private static final int NOTHING_SELECTED = -1;
    private int selectedIndex = NOTHING_SELECTED;
    private Context context;

    public CardAdapter(Context c, OnCardClicked listener){
        context = c;
        this.listener = listener;
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

        // Mirem si la carta està seleccionada i en aquest
        // cas canviem el background
        if (selectedIndex == position) {
            holder.llyCard.setBackgroundColor(context.getColor(R.color.selected_row));
        } else {
            holder.llyCard.setBackgroundColor(context.getColor(R.color.non_selected_row));
        }
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

            llyCard.setOnClickListener(v ->{
                Card card = selectCard(v);
                listener.onCardClicked(card, selectedIndex);
            });

            llyCard.setOnLongClickListener(v -> {
                Card card = selectCard(v);
                listener.onCardLongClicked(card, selectedIndex);
                return true;
            });

        }

        @NonNull
        private Card selectCard(View v) {
            int oldIndex = selectedIndex;
            selectedIndex = this.getBindingAdapterPosition();

            if(oldIndex!=NOTHING_SELECTED) notifyItemChanged(oldIndex);
            notifyItemChanged(selectedIndex);
            //Toast.makeText(context, "HOLA "+ Card.getCartes().get(selectedIndex).getName(),
            //       Toast.LENGTH_SHORT).show();
            Card card = Card.getCartes().get(selectedIndex);
            return card;
        }
    }
}
