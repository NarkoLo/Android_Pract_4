package com.narkorazdorov.android_pract_4;

public class Item {
    private String artistName;
    private int imageResourceId;

    public Item(String artistName, int imageResourceId) {
        this.artistName = artistName;
        this.imageResourceId = imageResourceId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
