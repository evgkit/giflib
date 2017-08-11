package ru.evgkit.giflib.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.evgkit.giflib.model.Gif;
import ru.evgkit.giflib.service.CategoryService;
import ru.evgkit.giflib.service.GifService;
import ru.evgkit.giflib.web.FlashMessage;
import ru.evgkit.giflib.web.validator.GifValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GifService gifService;

    // index of all GIFs
    @RequestMapping("/")
    public String listGifs(Model model) {
        List<Gif> gifs = gifService.findAll();
        model.addAttribute("gifs", gifs);
        return "gif/index";
    }

    // Single GIF page
    @RequestMapping("/gifs/{gifId}")
    public String gifDetails(@PathVariable Long gifId, Model model) {
        Gif gif = gifService.findById(gifId);
        model.addAttribute("gif", gif);
        return "gif/details";
    }

    // Return image data as byte array of the GIF whose id is gifId
    @RequestMapping("/gifs/{gifId}.gif")
    @ResponseBody
    public byte[] gifImage(@PathVariable Long gifId) {
        return gifService.findById(gifId).getBytes();
    }

    // Favorites - index of all GIFs marked favorite
    @RequestMapping("/favorites")
    public String favorites(Model model) {
        // TODO: Get list of all GIFs marked as favorite
        List<Gif> faves = new ArrayList<>();

        model.addAttribute("gifs", faves);
        model.addAttribute("username", "Chris Ramacciotti"); // Static username
        return "gif/favorites";
    }

    @InitBinder("gif")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new GifValidator());
    }

    // Add a new GIF
    @RequestMapping(value = "/gifs", method = RequestMethod.POST)
    public String addGif(@Valid Gif gif, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.gif", result);
            redirectAttributes.addFlashAttribute("gif", gif);
            return "redirect:/upload";
        }

        gifService.save(gif);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("GIF added!", FlashMessage.Status.SUCCESS));
        return String.format("redirect:/gifs/%s", gif.getId());
    }

    // Update an existing GIF
    @RequestMapping(value = "/gifs/{gifId}", method = RequestMethod.POST)
    public String updateGif(@Valid Gif gif, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.gif", result);
            redirectAttributes.addFlashAttribute("gif", gif);
            return String.format("redirect:/gifs/%s/edit", gif.getId());
        }

        gifService.update(gif);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("GIF updated!", FlashMessage.Status.SUCCESS));
        return String.format("redirect:/gifs/%s", gif.getId());
    }

    // Form for uploading a new GIF
    @RequestMapping("/upload")
    public String formNewGif(Model model) {
        if (!model.containsAttribute("gif")) {
            model.addAttribute("gif", new Gif());
        }
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "/gifs");
        model.addAttribute("heading", "Upload Gif");
        model.addAttribute("submit", "Upload");
        return "gif/form";
    }

    // Form for editing an existing GIF
    @RequestMapping(value = "/gifs/{gifId}/edit")
    public String formEditGif(@PathVariable Long gifId, Model model) {
        if (!model.containsAttribute("gif")) {
            model.addAttribute("gif", gifService.findById(gifId));
        }
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", String.format("/gifs/%s", gifId));
        model.addAttribute("heading", "Edit Gif");
        model.addAttribute("submit", "Save");
        return "gif/form";
    }

    // Delete an existing GIF
    @RequestMapping(value = "/gifs/{gifId}/delete", method = RequestMethod.POST)
    public String deleteGif(@PathVariable Long gifId, RedirectAttributes redirectAttributes) {
        gifService.delete(gifService.findById(gifId));
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("GIF successfully deleted", FlashMessage.Status.SUCCESS));
        return "redirect:/";
    }

    // Mark/unmark an existing GIF as a favorite
    @RequestMapping(value = "/gifs/{gifId}/favorite", method = RequestMethod.POST)
    public String toggleFavorite(@PathVariable Long gifId) {
        // TODO: With GIF whose id is gifId, toggle the favorite field

        // TODO: Redirect to GIF's detail view
        return null;
    }

    // Search results
    @RequestMapping("/search")
    public String searchResults(@RequestParam String q, Model model) {
        // TODO: Get list of GIFs whose description contains value specified by q
        List<Gif> gifs = new ArrayList<>();

        model.addAttribute("gifs", gifs);
        return "gif/index";
    }
}