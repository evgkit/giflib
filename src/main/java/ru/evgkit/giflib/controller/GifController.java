package ru.evgkit.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by e on 30.01.16.
 */
@Controller
public class GifController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/gif")
    @ResponseBody
    public String getOneGif() {
        return "One GIF";
    }
}
