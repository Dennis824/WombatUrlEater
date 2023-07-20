package com.example.wombaturleater.controllers;


import com.example.wombaturleater.entities.Url;
import com.example.wombaturleater.services.UrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/urls")
public class UrlsController {

    private final UrlService urlService;


    @Autowired
    public UrlsController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("urls", urlService.findAll());
        return "urls/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("url", urlService.findOne(id));
        return "urls/show";
    }


    @GetMapping("/new")
    public String newUrl(@ModelAttribute("url") Url url) {
        return "urls/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("url") @Valid Url url,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "urls/new";

        urlService.save(url);
        return "redirect:/urls";
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        urlService.delete(id);
        return "redirect:/urls";
    }

}