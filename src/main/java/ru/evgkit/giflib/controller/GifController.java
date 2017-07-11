package ru.evgkit.giflib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgkit.giflib.data.GifRepository;
import ru.evgkit.giflib.model.Gif;

import java.time.LocalDate;

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

    @RequestMapping("/gif/{name}")
    public String getDetailGif(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif-details";
    }
}
