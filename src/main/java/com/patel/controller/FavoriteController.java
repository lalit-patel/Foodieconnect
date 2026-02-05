package com.patel.controller;

import com.patel.model.*;
import com.patel.request.AddToCartItemRequest;
import com.patel.request.UpdateCartItemRequest;
import com.patel.service.FavoriteService;
import com.patel.service.FoodService;
import com.patel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/{foodId}")
    public ResponseEntity<List<Favorite>> addItemToFavorite(@PathVariable Long foodId,
                                                            @RequestHeader("Authorization") String jwt)
            throws Exception {
        List<Favorite> favorites = favoriteService.addItemToFavorite(foodId, jwt);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<List<Favorite>> removeFavoriteItem(@PathVariable Long foodId,
                                                             @RequestHeader("Authorization") String jwt)
            throws Exception {
        List<Favorite> favorites = favoriteService.removeItemFromFavorite(foodId, jwt);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Food>> findUserFavorite(@RequestHeader("Authorization") String jwt)
            throws Exception {
        List<Food> favorites = favoriteService.getFavoriteFoods(jwt);
        return ResponseEntity.ok(favorites);
    }
}
