
package com.example.mangaapi.api.model;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class AltTitle {

    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("ko")
    @Expose
    private String ko;
    @SerializedName("zh")
    @Expose
    private String zh;
    @SerializedName("zh-hk")
    @Expose
    private String zhHk;

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getZhHk() {
        return zhHk;
    }

    public void setZhHk(String zhHk) {
        this.zhHk = zhHk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AltTitle.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ja");
        sb.append('=');
        sb.append(((this.ja == null)?"<null>":this.ja));
        sb.append(',');
        sb.append("ko");
        sb.append('=');
        sb.append(((this.ko == null)?"<null>":this.ko));
        sb.append(',');
        sb.append("zh");
        sb.append('=');
        sb.append(((this.zh == null)?"<null>":this.zh));
        sb.append(',');
        sb.append("zhHk");
        sb.append('=');
        sb.append(((this.zhHk == null)?"<null>":this.zhHk));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
