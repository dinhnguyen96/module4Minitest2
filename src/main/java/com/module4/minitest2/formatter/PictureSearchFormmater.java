package com.module4.minitest2.formatter;

import com.module4.minitest2.model.Picture;
import com.module4.minitest2.service.PictureService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PictureSearchFormmater implements Formatter<List<Picture>>
{
    private PictureService pictureService;

    public PictureSearchFormmater(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @Override
    public List<Picture> parse(String text, Locale locale) throws ParseException
    {
        if (!text.isEmpty())
        {
            return pictureService.searchByPictureName(text);
        }
        return null;

    }

    @Override
    public String print(List<Picture> object, Locale locale) {
        return String.valueOf(object);
    }
}
