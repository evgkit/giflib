package ru.evgkit.giflib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgkit.giflib.data.GifRepository;
import ru.evgkit.giflib.model.Gif;

import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/favorites")
    public String favorites() {
        return "favorites";
    }

    @RequestMapping("/gif/{name}")
    public String getDetailGif(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif-details";
    }
}
