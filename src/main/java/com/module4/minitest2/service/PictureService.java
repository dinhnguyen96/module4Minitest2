package com.module4.minitest2.service;

import com.module4.minitest2.model.Picture;

import java.util.List;

public interface PictureService {


    List<Picture> findAll();


    Picture findById(Long id);

    List<Picture> searchByPictureName(String pictureName);

    List<Picture> searchByCategoriesName(String categoriesName);

    void add(Picture picture);

    void update(Picture picture);

    void delete(Picture picture);


}
