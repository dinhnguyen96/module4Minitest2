package com.module4.minitest2.service.impl;

import com.module4.minitest2.model.Categories;
import com.module4.minitest2.repository.CategoriesRepository;
import com.module4.minitest2.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }
}
