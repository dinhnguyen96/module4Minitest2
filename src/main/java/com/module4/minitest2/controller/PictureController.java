package com.module4.minitest2.controller;

import com.module4.minitest2.model.Picture;
import com.module4.minitest2.service.CategoriesService;
import com.module4.minitest2.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/picture")
public class PictureController
{
    @Autowired
    private PictureService pictureService;


    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/")
    public String pictureList(Model model)
    {
        model.addAttribute("pictures", pictureService.findAll());
        return "/picture";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Picture picture)
    {
        ModelAndView model = new ModelAndView();
        model.addObject("status", 1);
        model.addObject("pictureCategories", categoriesService.findAll());
        model.addObject("picture", picture);
        model.setViewName("/edit");
        return model;
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("picture", new Picture());
        model.addAttribute("pictureCategories", categoriesService.findAll());
        model.addAttribute("status", 0);
        return "/edit";
    }

}
