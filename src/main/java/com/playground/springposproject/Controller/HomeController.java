package com.playground.springposproject.Controller;

import com.playground.springposproject.Enums.Modules;
import com.playground.springposproject.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/home")
    public String home(Model model, HttpServletRequest request,
                       @RequestParam(name = "module", required = false, defaultValue = "default") String moduleName) {
        setupModule(model, request, moduleName);
        return "home";
    }

    private void setupModule(Model model, HttpServletRequest request, String moduleName) {
        Modules module = Modules.getModule(moduleName);

        if (null != module) {
            model.addAttribute("module", module.getValue());

            switch (module) {
                case ACCOUNT:
                    break;
                case PRODUCTS:
                    model.addAttribute("products", productService.getAllProducts());
                    break;
                case PRODUCTS_FORM:
                    model.addAttribute("action", request.getAttribute("action"));
                    model.addAttribute("product", request.getAttribute("product"));
                    break;
                default:
            }
        }

    }
}
