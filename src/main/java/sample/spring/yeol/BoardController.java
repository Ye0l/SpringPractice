package sample.spring.yeol;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> list = this.boardService.getPostList();
		
		mav.addObject("data", list);
		mav.setViewName("/board/list");
		
		return mav;
	}
	
	@RequestMapping(value = "board/write", method = RequestMethod.GET)
	public ModelAndView showWritePage() {
		return new ModelAndView("board/write");
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ModelAndView write(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String id = boardService.writePost(map);
		
		if(id == null) {
			mav.setViewName("redirect:/board/write");
		} else {
			mav.setViewName("redirect:/board/detail?id=" + id);
		}
		return mav;
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> detailMap = this.boardService.getPost(map);
		mav.addObject("data", detailMap);
		mav.setViewName("board/detail");
		return mav;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isDeleteSuccess = this.boardService.delete(map);
		String id = map.get("id").toString();
		if(isDeleteSuccess) {
			mav.setViewName("redirect:/board/list");
		} else {
			mav.setViewName("redirect:/board/detail?id=" + id);
		}
		
		return mav;
	}
	
}
