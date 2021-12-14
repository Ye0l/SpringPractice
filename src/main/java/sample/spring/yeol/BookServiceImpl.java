package sample.spring.yeol;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookDao bookDao;
	
//	Controller에서 넘어옴
	@Override
	public String create(Map<String, Object> map) {
//		곧바로 다시 BookDao로 넘어감.
		int affectRowCount = this.bookDao.insert(map);
//		쿼리문이 영향을 미친 행 갯수가 1개면.. 그러니까 insert문으로 1개를 입력했으니, 제대로 입력 되었다면
		if(affectRowCount == 1) {
			return map.get("book_id").toString();
//			autoIncreasement로 가져온 값도 제대로 세팅이 되었을테니 그걸 가져옴. 여기서 AutoIncreasement = bookid값
//			이제 Controller로 돌아감
		}
		
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.bookDao.selectDetail(map);
	}
}
