package com.playground.springposproject.Controller;

import com.playground.springposproject.Entity.Product;
import com.playground.springposproject.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showProductForm(HttpServletRequest request,
                                  @RequestParam(name = "action", required = false, defaultValue = "Add") String action,
                                  @RequestParam(name = "id", required = false, defaultValue = "0") Long id) {

        request.setAttribute("action", action);
        request.setAttribute("product", (action.equals("Add")) ? new Product() : productService.getProductById(id));

        return "forward:/home?module=products_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        this.productService.saveProduct(product);
        return "redirect:/home?module=products";
    }

}
