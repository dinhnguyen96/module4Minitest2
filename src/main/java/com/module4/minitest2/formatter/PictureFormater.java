package com.module4.minitest2.formatter;

import com.module4.minitest2.model.Picture;
import com.module4.minitest2.service.PictureService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PictureFormater implements Formatter<Picture>
{
    private PictureService pictureService;

    public PictureFormater(PictureService pictureService)
    {
        this.pictureService = pictureService;
    }

    @Override
    public Picture parse(String text, Locale locale)
    {
        return pictureService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Picture object, Locale locale) {
        return object.toString();
    }
}
