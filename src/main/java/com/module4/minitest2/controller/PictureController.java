package com.module4.minitest2.controller;

import com.module4.minitest2.model.Categories;
import com.module4.minitest2.model.Picture;
import com.module4.minitest2.service.CategoriesService;
import com.module4.minitest2.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
        model.addObject("categories", categoriesService.findAll());
        model.addObject("picture", picture);
        model.setViewName("/edit");
        return model;
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("picture", new Picture());
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("status", 0);
        return "/edit";
    }
    @PostMapping("/updatePicture")
    public String update(@Valid @ModelAttribute("picture") Picture picture,BindingResult bindingResult,  @RequestParam("pictureCategories") List<Categories> categories, HttpServletRequest request)
    {
        if (bindingResult.hasErrors())
        {
            int status = Integer.parseInt(request.getParameter("status"));
            if (status == 1)
            {
                request.setAttribute("status", 1);
            }
            else
            {
                request.setAttribute("status", 0);
            }
            request.setAttribute("categories", categoriesService.findAll());
            request.setAttribute("picture", picture);
            return "/edit";
        }

        Picture updatePicture = pictureService.findById(picture.getId());

        if (updatePicture == null)
        {
            updatePicture = picture;
            pictureService.add(updatePicture);
        }
        else
        {
            updatePicture.setPictureCategories(picture.getPictureCategories());
            updatePicture.setPictureCode(picture.getPictureCode());
            updatePicture.setPictureDescribe(picture.getPictureDescribe());
            updatePicture.setPictureHeight(picture.getPictureHeight());
            updatePicture.setPictureWidth(picture.getPictureWidth());
            updatePicture.setPictureMaterial(picture.getPictureMaterial());
            pictureService.update(updatePicture);
        }
        return "redirect:/picture/";
    }

    @GetMapping("{id}/delete")
    public String remove(@PathVariable("id") Picture picture)
    {
        pictureService.delete(picture);
        return "redirect:/picture/";
    }

    @PostMapping("/searchByPictureName")
    public ModelAndView searchByName(@RequestParam("search") List<Picture> pictureListSearch )
    {
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("pictures", pictureListSearch);
         modelAndView.setViewName("/picture");
         return modelAndView;
    }
}
