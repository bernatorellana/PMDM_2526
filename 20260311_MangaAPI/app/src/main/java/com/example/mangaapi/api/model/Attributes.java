
package com.example.mangaapi.api.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Attributes {

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("altTitles")
    @Expose
    private List<AltTitle> altTitles;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("isLocked")
    @Expose
    private Boolean isLocked;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("officialLinks")
    @Expose
    private Object officialLinks;
    @SerializedName("originalLanguage")
    @Expose
    private String originalLanguage;
    @SerializedName("lastVolume")
    @Expose
    private String lastVolume;
    @SerializedName("lastChapter")
    @Expose
    private String lastChapter;
    @SerializedName("publicationDemographic")
    @Expose
    private String publicationDemographic;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("contentRating")
    @Expose
    private String contentRating;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("chapterNumbersResetOnNewVolume")
    @Expose
    private Boolean chapterNumbersResetOnNewVolume;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("availableTranslatedLanguages")
    @Expose
    private List<String> availableTranslatedLanguages;
    @SerializedName("latestUploadedChapter")
    @Expose
    private String latestUploadedChapter;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<AltTitle> getAltTitles() {
        return altTitles;
    }

    public void setAltTitles(List<AltTitle> altTitles) {
        this.altTitles = altTitles;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Object getOfficialLinks() {
        return officialLinks;
    }

    public void setOfficialLinks(Object officialLinks) {
        this.officialLinks = officialLinks;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(String lastVolume) {
        this.lastVolume = lastVolume;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getPublicationDemographic() {
        return publicationDemographic;
    }

    public void setPublicationDemographic(String publicationDemographic) {
        this.publicationDemographic = publicationDemographic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getChapterNumbersResetOnNewVolume() {
        return chapterNumbersResetOnNewVolume;
    }

    public void setChapterNumbersResetOnNewVolume(Boolean chapterNumbersResetOnNewVolume) {
        this.chapterNumbersResetOnNewVolume = chapterNumbersResetOnNewVolume;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<String> getAvailableTranslatedLanguages() {
        return availableTranslatedLanguages;
    }

    public void setAvailableTranslatedLanguages(List<String> availableTranslatedLanguages) {
        this.availableTranslatedLanguages = availableTranslatedLanguages;
    }

    public String getLatestUploadedChapter() {
        return latestUploadedChapter;
    }

    public void setLatestUploadedChapter(String latestUploadedChapter) {
        this.latestUploadedChapter = latestUploadedChapter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attributes.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("altTitles");
        sb.append('=');
        sb.append(((this.altTitles == null)?"<null>":this.altTitles));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("isLocked");
        sb.append('=');
        sb.append(((this.isLocked == null)?"<null>":this.isLocked));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("officialLinks");
        sb.append('=');
        sb.append(((this.officialLinks == null)?"<null>":this.officialLinks));
        sb.append(',');
        sb.append("originalLanguage");
        sb.append('=');
        sb.append(((this.originalLanguage == null)?"<null>":this.originalLanguage));
        sb.append(',');
        sb.append("lastVolume");
        sb.append('=');
        sb.append(((this.lastVolume == null)?"<null>":this.lastVolume));
        sb.append(',');
        sb.append("lastChapter");
        sb.append('=');
        sb.append(((this.lastChapter == null)?"<null>":this.lastChapter));
        sb.append(',');
        sb.append("publicationDemographic");
        sb.append('=');
        sb.append(((this.publicationDemographic == null)?"<null>":this.publicationDemographic));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null)?"<null>":this.year));
        sb.append(',');
        sb.append("contentRating");
        sb.append('=');
        sb.append(((this.contentRating == null)?"<null>":this.contentRating));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("chapterNumbersResetOnNewVolume");
        sb.append('=');
        sb.append(((this.chapterNumbersResetOnNewVolume == null)?"<null>":this.chapterNumbersResetOnNewVolume));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("availableTranslatedLanguages");
        sb.append('=');
        sb.append(((this.availableTranslatedLanguages == null)?"<null>":this.availableTranslatedLanguages));
        sb.append(',');
        sb.append("latestUploadedChapter");
        sb.append('=');
        sb.append(((this.latestUploadedChapter == null)?"<null>":this.latestUploadedChapter));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
