package com.adminPanel.app.controller;


import com.adminPanel.app.model.Product;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public ProductService productService;

    @GetMapping("/")
    public String allProducts(Model model){
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "redirect:/allProductsPage";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product")Product product){
      productService.addProduct(product);
        return "redirect:/allProductsPage";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product")Product product){
        productService.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int id) {
        productService.deleteProduct(id);
        return "redirect:/addProductPage";
    }


    @GetMapping("/addProductForm")
    public String showAddForm(Model model){
        Product product= new Product();
        model.addAttribute("product",product);
        return "addProductPage";
    }
    @GetMapping("/updateProductForm")
    public String showUpdateForm(@RequestParam("productId") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "updateProductPage";
    }

}


