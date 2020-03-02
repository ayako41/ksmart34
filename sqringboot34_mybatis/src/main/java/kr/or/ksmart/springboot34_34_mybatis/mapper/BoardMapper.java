package kr.or.ksmart.springboot34_34_mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_34_mybatis.domain.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> boardList(Map<String,Object> map);
	
	public int getBoardRowCount();
}
