package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setProductDetails(new ProductDetails()); // Initialize ProductDetails
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/processAddProduct")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/updateProduct")
    public String showUpdateForm(@RequestParam("productId") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "update-product";
    }
    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all-products";
    }
    @PostMapping("/processUpdateProduct")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/productDetails")
    public String showProductDetails(@RequestParam("productId") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-details";
    }
}