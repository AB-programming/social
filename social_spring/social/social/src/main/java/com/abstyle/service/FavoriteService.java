package com.abstyle.service;

import com.abstyle.pojo.Favorite;

import java.util.List;

public interface FavoriteService {

    List<Favorite> selectFavoriteByTarget(String favoriteTarget);

    List<Favorite> selectFavorite();

    int createFavorite(Favorite favorite);
}
