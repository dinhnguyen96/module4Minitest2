package com.module4.minitest2.service.impl;

import com.module4.minitest2.model.Picture;
import com.module4.minitest2.repository.PictureRepository;
import com.module4.minitest2.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PictureServiceImpl implements PictureService
{

    @Autowired
    private PictureRepository pictureRepository;
    @Override
    public List<Picture> findAll()
    {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id)
    {
        return pictureRepository.findPictureById(id);
    }

    @Override
    public List<Picture> searchByPictureName(String pictureName) {
        return pictureRepository.searchByPictureName(pictureName);
    }

    @Override
    public List<Picture> searchByCategoriesName(String categoriesName) {
        return pictureRepository.searchByCategoriesName(categoriesName);
    }
}
