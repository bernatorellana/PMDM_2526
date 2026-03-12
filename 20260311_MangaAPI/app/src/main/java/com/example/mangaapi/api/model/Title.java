
package com.example.mangaapi.api.model;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Title {

    @SerializedName("en")
    @Expose
    private String en;

    @SerializedName("ja-ro")
    @Expose
    private String ja_ro;


    public String getTitle(){
        if( en!=null) return en;
        else  if( ja_ro!=null) return ja_ro;
        else return "NO_TITLE";
    }

    public String getEn() {
        return en;
    }

    public String getJaRo() {
        return ja_ro;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Title.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("en");
        sb.append('=');
        sb.append(((this.en == null)?"<null>":this.en));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
