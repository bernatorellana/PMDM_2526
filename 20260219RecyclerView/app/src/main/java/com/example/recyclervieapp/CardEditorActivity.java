package com.example.recyclervieapp;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.recyclervieapp.databinding.ActivityCardEditorBinding;
import com.example.recyclervieapp.model.magic.MagicCard;
import com.example.recyclervieapp.parser.MagicJSONParser;

import java.util.List;

public class CardEditorActivity extends AppCompatActivity {

    public static final String PARAM_CARD_POSITION = "position";
    private static final int REQUEST_IMAGE_CAPTURE = 33;
    private ActivityCardEditorBinding binding;
    private MagicCard card;
    private int position;

    public static final String PARAM_CARD = "card";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_card_editor);
        //Utilitzem la classe de binding per inflar el layout
        binding = ActivityCardEditorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recuperar els paràmetres de l'Intent
        card = (MagicCard) getIntent().getSerializableExtra(PARAM_CARD);
        position = getIntent().getIntExtra(PARAM_CARD_POSITION, -1);


        showCard(card);

        // programem el botó
        binding.btnOk.setOnClickListener(v->{

            List<MagicCard> cards = MagicJSONParser.getCards(this);

            MagicCard c = cards.get(position);
            c.setName(binding.edtName.getText().toString());
            c.setText(binding.edtText.getText().toString());
            finish();
        });

        //programem el click sobre la imatge per obrir un intent de càmera
        binding.imageView.setOnClickListener(v->{
            Log.d("XXXX", "Image view click");
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // verifica que l'intent té alguna aplicació disponible
           // if(i.resolveActivity(getPackageManager())==null) return;

            startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            //recuperar la foto de l'intent
            Bundle extras = data.getExtras();


            Glide.with(this).load(extras.get("data")).into(binding.imageView);

        }
    }

    private void showCard(MagicCard card) {
        binding.edtName.setText(card.getName());
        binding.edtText.setText(card.getText());
        Glide.with(this).load(card.getImageUrl()).
                fallback(R.drawable.skeletons).into(binding.imageView);
    }
}