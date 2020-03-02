package kr.or.ksmart.springboot34_34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_34_mybatis.domain.Member;

@Mapper
public interface GoodsMapper {
	
	public int goodsInsert(Goods goods);
	
	public List<Goods> goodslist();
	
	public List<Goods> goodsSearchlist(String sk,String sv);
	
	public Goods goodsUpdateForm(String gCode);
	
	public int goodsUpdate(Goods goods);
	
	public int goodsDelete(String gCode);
}
