package com.patel.service;

import com.patel.model.Favorite;
import com.patel.model.Food;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {

    List<Favorite> addItemToFavorite(Long foodId, String jwt) throws Exception;

    List<Favorite> removeItemFromFavorite(Long foodId, String jwt) throws Exception;

    List<Favorite> findFavoriteByUser(String jwt) throws Exception;

    List<Food> getFavoriteFoods(String jwt) throws Exception;
}
