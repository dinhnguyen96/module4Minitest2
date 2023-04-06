package com.module4.minitest2.formatter;

import com.module4.minitest2.model.Categories;
import com.module4.minitest2.service.CategoriesService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PictureCategoriesFormatter implements Formatter<List<Categories>> {

    private CategoriesService categoriesService;


    public PictureCategoriesFormatter(CategoriesService categoriesService)
    {
        this.categoriesService = categoriesService;
    }


    @Override
    public List<Categories> parse(String text, Locale locale) throws ParseException {
        String[] idArray = text.split(",");

        List<Categories> categoriesList = new ArrayList<>();

        for (String id : idArray)
        {
            try {
                Categories categories = this.categoriesService.findbyId(Long.parseLong(id));
                if (categories != null)
                {
                    categoriesList.add(categories);
                }
            }
            catch (NumberFormatException e)
            {
                throw new ParseException("Invalid category ID: " + id, 0);
            }

        }
        return categoriesList;
    }

    @Override
    public String print(List<Categories> object, Locale locale) {
        return object.stream().map(category -> category.getId().toString()).collect(Collectors.joining(","));
    }
}
