package com.fatec.WBClients.application.http.controllers;

import com.fatec.WBClients.application.services.ProductService;
import com.fatec.WBClients.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class ProductController implements WebMvcConfigurer {

    private final ProductService productService;

    private final String viewFolder = "Product/";

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/new")
    public String newProfile(Model model) {
        Product Product = new Product();
        model.addAttribute("user", Product);
        return viewFolder + "new";
    }

    @RequestMapping("/product/edit/{id}")
    public String editProfile(@PathVariable(name = "id") Long id, Model model) {
        Product Product = productService.findById(id);
        model.addAttribute("Product", Product);
        return viewFolder + "edit";
    }

    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("Product") Product Product) {
        Product Product1 = productService.findById(Product.getIdProduct());
        Product1.setNameProduct(Product.getNameProduct());
        productService.save(Product1);
        return "redirect:/product/list";
    }

    @RequestMapping("/product/list")
    public String listProfile(Model model) {
        List<Product> profileList = productService.listAll();
        model.addAttribute("profileList", profileList);

        return viewFolder + "list";
    }

    @RequestMapping(value = "product/save", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("product") Product Product) {
        productService.save(Product);

        return "redirect:/product/list";
    }

    @RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
    public String deleteProfile(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/user-account/list";
    }
}