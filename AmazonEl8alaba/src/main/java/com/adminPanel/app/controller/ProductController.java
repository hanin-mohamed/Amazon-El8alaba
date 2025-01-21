package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDAOImp;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductDAOImp productDAOImp;

    @Autowired
    public ProductController(ProductDAOImp productDAOImp) {
        this.productDAOImp = productDAOImp;
    }

    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setProductDetails(new ProductDetails());
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/processAddProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productDAOImp.addProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/updateProduct")
    public String showUpdateForm(@RequestParam("productId") int id, Model model) {
        Product product = productDAOImp.findProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/processUpdateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productDAOImp.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productDAOImp.getAllProducts();
        model.addAttribute("products", products);
        return "all-products";
    }

    @GetMapping("/productDetails")
    public String showProductDetails(@RequestParam("productId") int id, Model model) {
        Product product = productDAOImp.findProductById(id);
        model.addAttribute("product", product);
        return "product-details";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int id) {
        productDAOImp.deleteProduct(id);
        return "redirect:/products/list";
    }
}