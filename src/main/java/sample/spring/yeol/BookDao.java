package sample.spring.yeol;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
//	BookServiceImpl에서 넘어옴
	public int insert(Map<String, Object> map) {
//		SQL xml에 정의한 sql로 인자를 넘김. 기본적으로 map object로 통신하는 모양이다
//		map은 {인자1: 인자2} 형태.. 지금같은 경우는 {String, Object} 형태. DB에선 String인지 int인지 오락가락하니까 그런 모양
//		이제 book_SQL.xml로 넘어감
		return this.sqlSessionTemplate.insert("book.insert", map);
//		book_SQL에서 book_id에 세팅한 generatedKey가 그대로 있는 상태로 리턴, insert의 반환값 int는 방금 사용한 쿼리문이 몇개의 행에 영향을 미쳤는지를 반환함
//		그리고 다시 BookServiceImpl로 넘어감
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
		// 데이터를 한 개만 가져올 때, 쿼리 결과가 0행이면 null, 다수면 TooManyResultsException
	}
}
