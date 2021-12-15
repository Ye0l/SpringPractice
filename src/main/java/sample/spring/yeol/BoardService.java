package sample.spring.yeol;

import java.util.List;
import java.util.Map;

public interface BoardService {

	String writePost(Map<String, Object> map);

	Map<String, Object> getPost(Map<String, Object> map);

	List<Map<String, Object>> getPostList();

	boolean delete(Map<String, Object> map);

}
