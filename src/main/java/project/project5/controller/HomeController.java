package project.project5.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("page","home");
        return "home";
    }
    @GetMapping("/profile")
    public String profile(){
        return "page/profile";
    }
    @GetMapping("/private-interior")
    public String pInterior(){
        return "page/private-interior";
    }
    @GetMapping("/business-interior")
    public String bInterior(){
        return "page/business-interior";
    }
}
