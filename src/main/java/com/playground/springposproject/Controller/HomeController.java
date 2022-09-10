package com.playground.springposproject.Controller;

import com.playground.springposproject.Enums.Modules;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, @RequestParam(name = "module", required = false, defaultValue = "default") String module) {
        model.addAttribute("module", Modules.getValueByName(module));
        return "home";
    }

}
