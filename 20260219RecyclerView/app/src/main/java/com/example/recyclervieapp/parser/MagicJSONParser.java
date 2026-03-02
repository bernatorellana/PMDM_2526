package com.example.recyclervieapp.parser;

import android.content.Context;
import android.util.Log;

import com.example.recyclervieapp.model.magic.MagicCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class MagicJSONParser {

    private static List<MagicCard> cards;

    public static List<MagicCard> getCards(Context context){
        if(cards==null) {
            String json = "";

            try {
                InputStream is = context.getAssets().open("cards.json");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bis = new BufferedReader(isr);
                String line;
                while ((line = bis.readLine()) != null) {
                    json += line;
                }

                cards = parseCards(json);

            } catch (Exception ex) {
                Log.e("Exception", ex.getMessage());
                return null;
            }
        }
        return cards;
    }

    private static List<MagicCard> parseCards(String json) throws JSONException {

        cards = new ArrayList<MagicCard>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray cardsArray = jsonObject.getJSONArray("cards");

        for(int i=0;i<cardsArray.length();i++){
            JSONObject jo = cardsArray.getJSONObject(i);
            String name = jo.getString("name");
            String manaCost = jo.getString("manaCost");
            String type = jo.getString("type");
            String rarity = jo.getString("rarity");
            String text = jo.getString("text");
            String imageUrl = jo.optString("imageUrl","");



            MagicCard card = new MagicCard(name, manaCost, type, rarity, text, imageUrl);
            cards.add(card);
        }

        return cards;
    }
}
