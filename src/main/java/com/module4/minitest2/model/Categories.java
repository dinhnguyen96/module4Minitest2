package com.module4.minitest2.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Categories implements Serializable
{
    private static final long  serialVersionUID  = 1L;

    private Long id;

    private String categoriesName;

    public Categories()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "categoriesName", length = 100)
    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName)
    {
        this.categoriesName = categoriesName;
    }
}
