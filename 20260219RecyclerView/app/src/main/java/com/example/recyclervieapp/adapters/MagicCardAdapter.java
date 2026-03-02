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

import com.bumptech.glide.Glide;
import com.example.recyclervieapp.R;
import com.example.recyclervieapp.model.Card;
import com.example.recyclervieapp.model.Rarity;
import com.example.recyclervieapp.model.magic.MagicCard;
import com.example.recyclervieapp.parser.MagicJSONParser;


public class MagicCardAdapter extends RecyclerView.Adapter<MagicCardAdapter.ViewHolder> {


    public void setSeleccionat(int i) {
        this.selectedIndex = i;
    }

    public void removeItemSelected() {
        if(selectedIndex!=NOTHING_SELECTED) {
            MagicJSONParser.getCards(context).remove(selectedIndex);
            notifyItemRemoved(selectedIndex);
            selectedIndex = NOTHING_SELECTED;
        }
    }

    public void moveItemDown() {
        if(selectedIndex!=NOTHING_SELECTED && selectedIndex<MagicJSONParser.getCards(context).size()-1) {

            
            MagicCard c = MagicJSONParser.getCards(context).remove(selectedIndex);
            MagicJSONParser.getCards(context).add(selectedIndex+1, c);
            selectedIndex ++;
            notifyItemChanged(selectedIndex);
            notifyItemChanged(selectedIndex-1);
            //notifyItemMoved(selectedIndex, selectedIndex+1);
        }
    }

    public void moveItemUp() {
        if(selectedIndex!=NOTHING_SELECTED && selectedIndex>0) {
            MagicCard c = MagicJSONParser.getCards(context).remove(selectedIndex-1);
            MagicJSONParser.getCards(context).add(selectedIndex, c);
            selectedIndex --;
            notifyItemChanged(selectedIndex);
            notifyItemChanged(selectedIndex+1);
        }
    }

    public interface OnCardClicked{
        void onCardClicked(MagicCard c, int position);
        void onCardLongClicked(MagicCard c, int position);
    }

    private OnCardClicked listener;
    private static final int NOTHING_SELECTED = -1;
    private int selectedIndex = NOTHING_SELECTED;
    private Context context;

    public MagicCardAdapter(Context c, OnCardClicked listener){
        context = c;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MagicCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = parent.inflate(parent.getContext(), R.layout.row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MagicCardAdapter.ViewHolder holder, int position) {
        MagicCard current = MagicJSONParser.getCards(context).get(position);
        //holder.imvImag.setImageResource(current.getDrawable());

        Glide.with(context).load(current.getImageUrl()).
                fallback(R.drawable.skeletons).into(holder.imvImag);

        holder.txvName.setText(current.getName());
        holder.txvDesc.setText(current.getText());
        holder.txvElixirCost.setText("" + current.getManaCost());

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
        return MagicJSONParser.getCards(context).size();
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
                MagicCard card = selectCard(v);
                listener.onCardClicked(card, selectedIndex);
            });

            llyCard.setOnLongClickListener(v -> {
                MagicCard card = selectCard(v);
                listener.onCardLongClicked(card, selectedIndex);
                return true;
            });

        }

        @NonNull
        private MagicCard selectCard(View v) {
            int oldIndex = selectedIndex;
            selectedIndex = this.getBindingAdapterPosition();

            if(oldIndex!=NOTHING_SELECTED) notifyItemChanged(oldIndex);
            notifyItemChanged(selectedIndex);
            //Toast.makeText(context, "HOLA "+ MagicJSONParser.getCards(context).get(selectedIndex).getName(),
            //       Toast.LENGTH_SHORT).show();
            MagicCard card = MagicJSONParser.getCards(context).get(selectedIndex);
            return card;
        }
    }
}
