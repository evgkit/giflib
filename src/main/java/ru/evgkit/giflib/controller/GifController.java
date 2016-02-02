package ru.evgkit.giflib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgkit.giflib.data.GifRepository;
import ru.evgkit.giflib.model.Gif;

import java.time.LocalDate;

/**
 * Created by e on 30.01.16.
 */
@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/gif")
    public String getDetailGif(ModelMap modelMap) {
        modelMap.put("gif", gifRepository.findByName("android-explosion"));
        return "gif-details";
    }
}
