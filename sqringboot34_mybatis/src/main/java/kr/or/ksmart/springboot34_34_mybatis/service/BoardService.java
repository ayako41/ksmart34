package kr.or.ksmart.springboot34_34_mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_34_mybatis.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public Map<String,Object> boardList(int currentPage){
		//いくつの行を表示するか
		final int ROW_PER_PAGE = 10;
		
		//見せる最初のページの番号を初期化
		int startPageNum=1;
		
		//見せる最後のぺ-ジ＝ページ個数
		int endPageNum = ROW_PER_PAGE;
		
		//currentPage 見たいページ
		//みたいページががペ-ジ6番目以上だった場合、startpageNum変動
		if(currentPage>(ROW_PER_PAGE/2)) {
			startPageNum = currentPage-((endPageNum/2)-1);
			endPageNum += (startPageNum-1);
		}
		
		//limit 適用する startRow、定数ROW_PER_PAGE(いくつのページを表示するか)
		Map<String,Object> map = new HashMap<String,Object>();
		//ページアルゴリズム
		//コリ実行のために、LIMIT startRow,rowPerPageを計算
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		//全体カウント
		double count = boardMapper.getBoardRowCount();
		
		//データがいくつあるのかから、何ページまであるのかを計算
		int lastPage = (int)Math.ceil((count/ROW_PER_PAGE));
		boardMapper.boardList(map);
		if(lastPage<endPageNum) {
			endPageNum=lastPage;
		}
		
		//controllerに送るページ関連のオブジェクト
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("boardList", boardMapper.boardList(map));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		
		return resultMap;
	}
}
