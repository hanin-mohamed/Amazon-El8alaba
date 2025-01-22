package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDAOImp;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = dateFormat.parse(text);
                    setValue(date);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
                }
            }
        });
    }

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
        System.out.println("ProductController.showAddForm");
        return "add-product";
    }

    @PostMapping("/processAddProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        product.getProductDetails().setProduct(product);
        productDAOImp.addProduct(product);
        System.out.println("ProductController.addProduct");

        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productDAOImp.getAllProducts();
        model.addAttribute("products", products);
        System.out.println("ProductController.listProducts");
        return "all-products";
    }


    @GetMapping("/updateProduct")
    public String showUpdateForm(@RequestParam("productId") int  id, Model model) {
        System.out.println("ProductController.showUpdateForm");
        Product product = productDAOImp.findProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/processUpdateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        System.out.println("ProductController.updateProduct");
        productDAOImp.updateProduct(product);
        return "redirect:/products/list";
    }



    @GetMapping("/productDetails")
    public String showProductDetails(@RequestParam("productId") int id, Model model) {
        Product product = productDAOImp.findProductById(id);
        model.addAttribute("product", product);
        System.out.println("ProductController.showProductDetails");
        return "product-details";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int id) {
        productDAOImp.deleteProduct(id);
        System.out.println("ProductController.deleteProduct");
        return "redirect:/products/list";
    }
}