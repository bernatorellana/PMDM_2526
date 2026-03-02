package com.example.recyclervieapp.model.magic;

public class MagicCard {
    String name;
    String manaCost;
    String type;
    String rarity;
    String text;
    String imageUrl;
    public MagicCard(String name, String manaCost, String type, String rarity, String text, String imageUrl) {
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.rarity = rarity;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MagicCard{" +
                "name='" + name + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", type='" + type + '\'' +
                ", rarity='" + rarity + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
