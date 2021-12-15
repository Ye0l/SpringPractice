package sample.spring.yeol;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao boardDao;
	
	@Override
	public String writePost(Map<String, Object> map) {
		int affectRowCount = this.boardDao.insert(map);
		if(affectRowCount == 1) {
			return map.get("post_id").toString();
		}
		
		return null;
	}
	
	@Override
	public Map<String, Object> getPost(Map<String, Object> map) {
		return this.boardDao.select(map);
	}
	
	@Override
	public List<Map<String, Object>> getPostList() {
		return this.boardDao.selectAll();
	}
	
	@Override
	public boolean delete(Map<String, Object> map) {
		return 1 == this.boardDao.delete(map);
	}
}
