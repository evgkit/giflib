package ru.evgkit.giflib.model;

import java.time.LocalDate;

public class Gif {
    private String name;
    private int categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean isFavorite;

    public Gif(String name, int categoryId, LocalDate dateUploaded, String username, boolean isFavorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.isFavorite = isFavorite;
    }

    public Gif(String name, int categoryId, LocalDate dateUploaded, String username) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.isFavorite = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
