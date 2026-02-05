package com.patel.service;

import com.patel.model.*;
import com.patel.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImp implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Override
    public List<Favorite> addItemToFavorite(Long foodId, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.findFoodById(foodId);

        favoriteRepository.findByUserAndFood(user, food)
                .ifPresent(fav -> {
                    throw new RuntimeException("Food already in favorites");
                });

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setFood(food);

        favoriteRepository.save(favorite);

        return favoriteRepository.findAllByUser(user);
    }

    @Override
    public List<Favorite> removeItemFromFavorite(Long foodId, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.findFoodById(foodId);

        Favorite favorite = favoriteRepository.findByUserAndFood(user, food)
                .orElseThrow(() -> new Exception("Food item not found in favorites"));

        favoriteRepository.delete(favorite);

        return favoriteRepository.findAllByUser(user);
    }

    @Override
    public List<Favorite> findFavoriteByUser(String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        return favoriteRepository.findAllByUser(user);
    }

    @Override
    public List<Food> getFavoriteFoods(String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        List<Favorite> favorites = favoriteRepository.findAllByUser(user);
        return favorites.stream()
                .map(Favorite::getFood)
                .collect(Collectors.toList());

    }
}

