package com.example.wombaturleater.controllers;


import com.example.wombaturleater.entities.Link;
import com.example.wombaturleater.services.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/links")
public class LinksController {

    private final LinksService linksService;


    @Autowired
    public LinksController(LinksService linksService) {
        this.linksService = linksService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("links", linksService.findAll());
        return "links/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("link", linksService.findOne(id));
        return "links/show";
    }


    @GetMapping("/new")
    public String newUrl(@ModelAttribute("link") Link link) {
        return "links/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("link") @Valid Link link,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "links/new";

        linksService.save(link);
        return "redirect:/links";
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        linksService.delete(id);
        return "redirect:/links";
    }

}