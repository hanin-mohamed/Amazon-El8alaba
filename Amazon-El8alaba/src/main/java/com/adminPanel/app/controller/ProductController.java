package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDAOImp;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
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
        ProductDetails productDetails = new ProductDetails();

        productDetails.setProduct(product);
        product.setProductDetails(productDetails);

        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/processAddProduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
                             @RequestParam("image") MultipartFile image) throws IOException {
        if (result.hasErrors()) {
            return "add-product";
        }

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        if (!image.isEmpty()) {
            product.getProductDetails().setImage(image.getBytes());
        }

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
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result
    , @RequestParam("image") MultipartFile image) throws IOException {
        if (result.hasErrors()) {
            return "update-product";
        }

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        if (!image.isEmpty()) {
            product.getProductDetails().setImage(image.getBytes());
        }
        productDAOImp.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productDAOImp.getAllProducts();
        model.addAttribute("products", products);
        return "all-products";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int id) {
        productDAOImp.deleteProduct(id);
        return "redirect:/products/list";
    }

    @GetMapping("/productDetails")
    public String showProductDetails(@RequestParam("productId") int id, Model model) {
        Product product = productDAOImp.findProductById(id);
        model.addAttribute("product", product);
        return "product-details";
    }
}