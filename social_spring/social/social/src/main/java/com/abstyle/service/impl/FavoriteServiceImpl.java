package com.abstyle.service.impl;

import com.abstyle.mapper.FavoriteMapper;
import com.abstyle.pojo.Favorite;
import com.abstyle.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteMapper favoriteMapper;

    @Override
    public List<Favorite> selectFavoriteByTarget(String favoriteTarget) {
        return favoriteMapper.selectFavoriteByTarget(favoriteTarget);
    }

    @Override
    public List<Favorite> selectFavorite() {
        return favoriteMapper.selectFavorite();
    }

    @Override
    public int createFavorite(Favorite favorite) {
        String favoriteId = System.currentTimeMillis() + "";
        favorite.setFavoriteId(favoriteId);
        List<Favorite> favorites = favoriteMapper.selectIsFavorite(favorite);
        if (favorites.isEmpty()){
            return favoriteMapper.createFavorite(favorite);
        }else {
            return 0;
        }
    }
}
