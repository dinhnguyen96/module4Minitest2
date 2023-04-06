package com.module4.minitest2.repository;


import com.module4.minitest2.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>
{

    @Query("select c from Categories c where c.id = :id")
    Categories findCategoriesByID(@Param("id") Long id);

}
