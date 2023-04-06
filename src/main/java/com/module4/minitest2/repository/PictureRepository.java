package com.module4.minitest2.repository;

import com.module4.minitest2.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>
{
    @Query("from Picture")
    List<Picture> findAll();


    @Query("select pic from Picture pic where pic.id = :pictureId")
    Picture findPictureById(@Param("pictureId") Long id);


    @Query("select pic from Picture  pic where pic.pictureName like concat('%',:pictureName,'%')  ")
    List<Picture> searchByPictureName(@Param("pictureName") String pictureName);


    @Query("select pic from Picture pic join pic.pictureCategories categories where  categories.categoriesName like concat('%',:categoriesName,'%') ")
    List<Picture> searchByCategoriesName(@Param("categoriesName") String categoriesName);


}
