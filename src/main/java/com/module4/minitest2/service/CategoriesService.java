package com.module4.minitest2.service;

import com.module4.minitest2.model.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAll();


    Categories findbyId(Long id);
}
