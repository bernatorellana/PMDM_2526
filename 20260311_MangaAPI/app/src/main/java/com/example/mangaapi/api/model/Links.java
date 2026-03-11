
package com.example.mangaapi.api.model;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Links {

    @SerializedName("al")
    @Expose
    private String al;
    @SerializedName("ap")
    @Expose
    private String ap;
    @SerializedName("bw")
    @Expose
    private String bw;
    @SerializedName("mu")
    @Expose
    private String mu;
    @SerializedName("amz")
    @Expose
    private String amz;
    @SerializedName("cdj")
    @Expose
    private String cdj;
    @SerializedName("ebj")
    @Expose
    private String ebj;
    @SerializedName("mal")
    @Expose
    private String mal;
    @SerializedName("raw")
    @Expose
    private String raw;

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getBw() {
        return bw;
    }

    public void setBw(String bw) {
        this.bw = bw;
    }

    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public String getAmz() {
        return amz;
    }

    public void setAmz(String amz) {
        this.amz = amz;
    }

    public String getCdj() {
        return cdj;
    }

    public void setCdj(String cdj) {
        this.cdj = cdj;
    }

    public String getEbj() {
        return ebj;
    }

    public void setEbj(String ebj) {
        this.ebj = ebj;
    }

    public String getMal() {
        return mal;
    }

    public void setMal(String mal) {
        this.mal = mal;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Links.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("al");
        sb.append('=');
        sb.append(((this.al == null)?"<null>":this.al));
        sb.append(',');
        sb.append("ap");
        sb.append('=');
        sb.append(((this.ap == null)?"<null>":this.ap));
        sb.append(',');
        sb.append("bw");
        sb.append('=');
        sb.append(((this.bw == null)?"<null>":this.bw));
        sb.append(',');
        sb.append("mu");
        sb.append('=');
        sb.append(((this.mu == null)?"<null>":this.mu));
        sb.append(',');
        sb.append("amz");
        sb.append('=');
        sb.append(((this.amz == null)?"<null>":this.amz));
        sb.append(',');
        sb.append("cdj");
        sb.append('=');
        sb.append(((this.cdj == null)?"<null>":this.cdj));
        sb.append(',');
        sb.append("ebj");
        sb.append('=');
        sb.append(((this.ebj == null)?"<null>":this.ebj));
        sb.append(',');
        sb.append("mal");
        sb.append('=');
        sb.append(((this.mal == null)?"<null>":this.mal));
        sb.append(',');
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
