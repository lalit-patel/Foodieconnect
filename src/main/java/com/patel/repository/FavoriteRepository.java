package com.patel.repository;

import com.patel.model.Favorite;
import com.patel.model.Food;
import com.patel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByUserAndFood(User user, Food food);

    List<Favorite> findAllByUser(User user);
}
