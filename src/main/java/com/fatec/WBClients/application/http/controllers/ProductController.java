/*package com.fatec.WBClients.application.http.controllers;

import com.fatec.WBClients.application.services.ProductService;
import com.fatec.WBClients.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.Collator;
import java.util.List;

@Controller
public class ProductController implements WebMvcConfigurer {

    private final ProductService profileService;

    private final String viewFolder = "Product/";


    public ProductController(ProductService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/user-account/new")
    public String newProfile(Model model) {
        Product Product = new Product();
        model.addAttribute("user", Product);
        return viewFolder + "new";
    }

    @RequestMapping("/user-account/edit/{id}")
    public String editProfile(@PathVariable(name = "id") Long id, Model model) {
        Product Product = profileService.findById(id);
        model.addAttribute("Product", Product);
        return viewFolder + "edit";
    }

    @RequestMapping(value = "/user-account/edit", method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("Product") Product Product) {
        Product Product1 = profileService.findById(Product.getId_product());
        Product1.setName_product(Product.getName_product());
        profileService.save(Product1);
        return "redirect:/user-account/list";
    }

    @RequestMapping("/user-account/list")
    public String listProfile(Model model) {
        List<Product> profileList = profileService.listAll();
        model.addAttribute("profileList", profileList);

        return viewFolder + "list";
    }

    @RequestMapping(value = "user-account/save", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("user") Product Product) {
        profileService.save(Product);

        return "redirect:/user-account/list";
    }

    @RequestMapping(value = "user-account/delete/{id}", method = RequestMethod.GET)
    public String deleteProfile(@PathVariable("id") Long id) {
        profileService.delete(id);
        return "redirect:/user-account/list";
    }
}*/