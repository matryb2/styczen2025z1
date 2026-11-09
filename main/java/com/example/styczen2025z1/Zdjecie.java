package com.example.styczen2025z1;

public class Zdjecie {
    private int id;
    private String alt;
    private int imageResId;
    private int category;
    private int downloads;

    public Zdjecie(int id, String alt, int imageResId, int category, int downloads) {
        this.id = id;
        this.alt = alt;
        this.imageResId = imageResId;
        this.category = category;
        this.downloads = downloads;
    }

    public int getId() { return id; }
    public String getAlt() { return alt; }
    public int getImageResId() { return imageResId; }
    public int getCategory() { return category; }
    public int getDownloads() { return downloads; }

    public void incrementDownloads() {
        this.downloads++;
    }
}