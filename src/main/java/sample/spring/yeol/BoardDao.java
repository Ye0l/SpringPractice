package sample.spring.yeol;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("board.insert", map);
	}
	
	public Map<String, Object> select(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("board.select", map);
	}
	
	public List<Map<String, Object>> selectAll() {
		return this.sqlSessionTemplate.selectList("board.select_all");
	}
	
	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("board.delete", map);
	}
}
