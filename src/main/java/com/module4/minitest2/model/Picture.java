package com.module4.minitest2.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Table
@Entity
public class Picture implements Serializable
{
    private static final long  serialVersionUID  = 1L;

    private Long id ;

    private String pictureCode;


    private String pictureName;


    private double pictureHeight;

    private double pictureWidth;


    private String pictureMaterial;

    private String pictureDescribe;

    private double picturePrice;


    private List<Categories> pictureCategories;




    public Picture()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "pictureCode", length = 50)
    public String getPictureCode() {
        return pictureCode;
    }

    public void setPictureCode(String pictureCode) {
        this.pictureCode = pictureCode;
    }

    @Column(name = "pictureName", length = 50)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Min(value = 0, message = "{pictureHeight.Min}")
    @Column(name = "pictureHeight")
    public double getPictureHeight()
    {
        return pictureHeight;
    }

    public void setPictureHeight(double pictureHeight)
    {
        this.pictureHeight = pictureHeight;
    }

    @Min(value = 0, message = "{pictureWidth.Min}")
    @Column(name = "pictureWidth")
    public double getPictureWidth()
    {
        return pictureWidth;
    }

    public void setPictureWidth(double pictureWidth) {
        this.pictureWidth = pictureWidth;
    }

    @Column(name = "pictureMaterial", length=50)
    public String getPictureMaterial() {
        return pictureMaterial;
    }

    public void setPictureMaterial(String pictureMaterial) {
        this.pictureMaterial = pictureMaterial;
    }

    @Column(name = "pictureDescribe", length = 200)
    public String getPictureDescribe() {
        return pictureDescribe;
    }

    public void setPictureDescribe(String pictureDescribe) {
        this.pictureDescribe = pictureDescribe;
    }

    @Min(value = 0, message = "{picturePrice.Min}")
    @Column(name = "picturePrice")
    public double getPicturePrice() {
        return picturePrice;
    }

    public void setPicturePrice(double picturePrice) {
        this.picturePrice = picturePrice;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "picture_categories", joinColumns = @JoinColumn(name = "pictureId", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name="categoriesId", referencedColumnName = "Id"))
    public List<Categories> getPictureCategories() {
        return pictureCategories;
    }

    public void setPictureCategories(List<Categories> pictureCategories) {
        this.pictureCategories = pictureCategories;
    }

}
