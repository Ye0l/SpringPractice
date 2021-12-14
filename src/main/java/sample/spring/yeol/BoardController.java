package sample.spring.yeol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService BoardService;
	
	@RequestMapping(value = "/board/list")
	public ModelAndView list() {
		return new ModelAndView("board/list");
	}
}
