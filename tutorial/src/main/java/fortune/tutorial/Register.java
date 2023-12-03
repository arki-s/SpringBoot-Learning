package fortune.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Register {

    @RequestMapping("/")
    public String start(){
        return "input.html";
    }

    @RequestMapping("/register")
    public ModelAndView register
            (@ModelAttribute RegisterBean rb, ModelAndView m){
        m.addObject("rb", rb);
        m.setViewName("register.html");
        return m;
    }
}
