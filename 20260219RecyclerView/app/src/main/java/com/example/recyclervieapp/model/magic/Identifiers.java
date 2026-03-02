
package com.example.recyclervieapp.model.magic;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Identifiers {

    @SerializedName("scryfallId")
    @Expose
    private String scryfallId;
    @SerializedName("multiverseId")
    @Expose
    private Integer multiverseId;

    public String getScryfallId() {
        return scryfallId;
    }

    public void setScryfallId(String scryfallId) {
        this.scryfallId = scryfallId;
    }

    public Integer getMultiverseId() {
        return multiverseId;
    }

    public void setMultiverseId(Integer multiverseId) {
        this.multiverseId = multiverseId;
    }

}
