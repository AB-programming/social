package com.abstyle.controller;

import com.abstyle.pojo.Favorite;
import com.abstyle.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

    @RequestMapping("/selectFavoriteByTarget")
    public List<Favorite> selectFavoriteByTarget(String favoriteTarget){
        return favoriteService.selectFavoriteByTarget(favoriteTarget);
    }

    @RequestMapping("/selectFavorite")
    public List<Favorite> selectFavorite(){
        return favoriteService.selectFavorite();
    }

    @RequestMapping("/createFavorite")
    public int createFavorite(Favorite favorite){
        return favoriteService.createFavorite(favorite);
    }
}
