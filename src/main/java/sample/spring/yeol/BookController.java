package sample.spring.yeol;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
//	 대체 왜 BookServiceImpl 클래스가 아니라 BookService 인터페이스를 생성하는가.. 모르겠다.
//	나중에 다시 읽어보기 https://okky.kr/article/413840
	@Autowired
	BookService bookService;
	
// 	RequestMethod : Spring version 4 이상에서만 사용
// 	이렇게 사용하면 GET방식 입력이 있을땐 위 메소드, POST는 아래 방식으로 작동하게 함
// 	GET에 아무 값이 없을 때도 이 방식으로 들어가는 듯(createPost if부분 주석처리해도 문제없이 작동함. if절은 예외처린가?)	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
//	POST입력이 있는 채로 create에 들어왔을 때.. form에 입력하면 POST로 데이터 전송하니까
	@RequestMapping(value="/create", method = RequestMethod.POST)
//	@RequestParam("가져올 데이터 이름", 없으면 모두 가져오는듯) [데이터타입] [담을 변수]
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
//		ModelAndView 객체를 만들고
		ModelAndView mav = new ModelAndView();
		
//		bookService에서 create문으로 DB값 가져온 다음 .. 여기서 일단 BookServiceImpl로 넘어감
		String bookId = this.bookService.create(map);
//		BookService로 갔다가 BookDao로 갔다가 SQL로 입력하고 가져온 ID를 들고 다시 여기까지 돌아옴.
//		입력이 제대로 되었다면 null이 아님. 하지만 만약 null이라면
		if(bookId == null) {
			mav.setViewName("redirect:/create");
//			입력하는 화면을 다시 보여줌. 예외처리가 맞는거같다.
		} else {
//			제대로 입력이 되었다면 detail페이지로 가서 입력한 값으로 select를 때림 이제 다시 RequestMapping/detail로 가서 비슷한 과정을 반복.. 
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
//		비슷한 과정을 거쳐서, 이번엔 가지고 온 값이.. 그러니까 SQL의 결과값으로 가져온게 hashMap임. Map객체로 결과를 통째로 가져왔음.
		Map<String, Object> detailMap = this.bookService.detail(map);
		
//		일단 MAV객체를 생성하고
		ModelAndView mav = new ModelAndView();
//		쿼리문 결과로 가져온 데이터를 입력함
		mav.addObject("data", detailMap);
//		String객체로 이 함수에 입력된 map객체에서 id를 꺼내옴. 아니 근데 data에서 꺼내와도 되는거 아닌가?
//		이제보니 예제에선 SQL을 select * from book이 아니라 id를 제외하고 하나씩 꺼내왔다.
//		근데 애초에 sql에서 where절에 map에 넣은 bookId를 사용해서 쿼리를 날렸으니 굳이 새걸 꺼내올 필요가 없을것같긴 하다.
		String bookId = map.get("bookId").toString();
//		bookid를 MAV객체에 추가
		mav.addObject("bookId", bookId);
//		추가한 객체를 어느 페이지로 가져갈지 설정.
		mav.setViewName("/book/detail");
//		설정이 끝난 MAV객체를 반환
		return mav;
	}
//	=============================================================================================
//	여기까지 하고 보니.. Spring은 html간섭을 최소화하고 거의 모든 부분을 그냥 자바 코딩처럼 하게 하는거같다.
//	MAV객체 .. 페이지 뷰 하나를 아예 객체로 만들어서 쓰고 있으니.. 안드로이드 view랑 비슷한 느낌. 그러고보니 이름도 똑같긴 함 액티비티든 프래그먼트든 뷰는 뷰니까..
//	일단 해당 프로젝트는 예시를 최대한 그대로 따라해서 샘플로 쓰려는 목적이니까 이후에도 코드 어레인지는 가급적 없이(이미 select * from같은건 해버렸지만) 그대로 작성함
//	그래서 이 글 쓴 사람이 프로젝트명을 sample로 했나. 샘플로 쓰라고..
//	=============================================================================================
}
