package com.abstyle.test;

import com.abstyle.mapper.FavoriteMapper;
import com.abstyle.pojo.Favorite;
import com.abstyle.service.FavoriteService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动spring的容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class FavoriteTest {
    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteMapper favoriteMapper;

    @Test
    public void testCreateFavorite(){
        Favorite favorite = new Favorite("66","1662215300333");
        int favorite1 = favoriteService.createFavorite(favorite);
        System.out.println(favorite1);
    }

    @Test
    public void testSelectIsFavorite(){
        Favorite favorite = new Favorite("12","1662215300333");
        List<Favorite> favorites = favoriteMapper.selectIsFavorite(favorite);
        System.out.println(favorites.isEmpty());
    }
}
