package com.winter.adlist.repositories;

import com.winter.adlist.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
