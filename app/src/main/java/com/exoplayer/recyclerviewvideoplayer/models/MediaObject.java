package com.exoplayer.recyclerviewvideoplayer.models;

public class MediaObject {


    private String media_url;


    public MediaObject(String title, String media_url, String thumbnail, String description) {

        this.media_url = media_url;
    }

    public MediaObject() {
    }


    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

}










