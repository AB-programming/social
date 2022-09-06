package com.abstyle.mapper;

import com.abstyle.pojo.Favorite;

import java.util.List;

public interface FavoriteMapper {
    List<Favorite> selectFavoriteByTarget(String favoriteTarget);

    List<Favorite> selectFavorite();

    List<Favorite> selectIsFavorite(Favorite favorite);

    int createFavorite(Favorite favorite);
}
