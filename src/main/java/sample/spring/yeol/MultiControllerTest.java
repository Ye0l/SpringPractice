package sample.spring.yeol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiControllerTest {
	
	@RequestMapping(value = "/")
	public ModelAndView testHomepage() {
		return new ModelAndView("/home");
	}
}
