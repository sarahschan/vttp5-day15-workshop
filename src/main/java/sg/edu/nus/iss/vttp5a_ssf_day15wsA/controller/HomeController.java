package sg.edu.nus.iss.vttp5a_ssf_day15wsA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
    
    @GetMapping()
    public String homePageRedirect(){
        return "redirect:/contacts";
    }
}
