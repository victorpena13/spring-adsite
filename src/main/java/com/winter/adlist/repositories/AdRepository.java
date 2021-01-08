package com.winter.adlist.repositories;

import com.winter.adlist.models.Ad;
import com.winter.adlist.models.Category;
import com.winter.adlist.models.User;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {

    Iterable<Ad> findByOwner(User user);
    Iterable<Ad> findAllByCategoriesOrderByIdDesc(Category category);
}
