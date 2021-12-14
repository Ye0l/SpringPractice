package sample.spring.yeol;

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
			return map.get("board_id").toString();
		}
		
		return null;
	}
}
