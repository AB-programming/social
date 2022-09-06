package com.abstyle.pojo;

public class Favorite {
    private String favoriteId;
    private String favoriteName;
    private String favoriteTarget;

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId='" + favoriteId + '\'' +
                ", favoriteName='" + favoriteName + '\'' +
                ", favoriteTarget='" + favoriteTarget + '\'' +
                '}';
    }

    public Favorite(String favoriteName, String favoriteTarget) {
        this.favoriteName = favoriteName;
        this.favoriteTarget = favoriteTarget;
    }

    public Favorite(String favoriteId, String favoriteName, String favoriteTarget) {
        this.favoriteId = favoriteId;
        this.favoriteName = favoriteName;
        this.favoriteTarget = favoriteTarget;
    }

    public Favorite() {
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }

    public String getFavoriteTarget() {
        return favoriteTarget;
    }

    public void setFavoriteTarget(String favoriteTarget) {
        this.favoriteTarget = favoriteTarget;
    }
}
