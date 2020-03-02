package kr.or.ksmart.springboot34_34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_34_mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public int goodsInsert(Goods goods) {
		return goodsMapper.goodsInsert(goods);
	}
	
	public List<Goods> goodslist(){
		List<Goods> list = goodsMapper.goodslist();
		return list;
	}
	public List<Goods> goodsSearchlist(String sv,String sk){
		List<Goods> list = goodsMapper.goodsSearchlist(sv,sk);
		return list;
	}
	
	
	public Goods goodsUpdateForm(String gCode) {
		return goodsMapper.goodsUpdateForm(gCode);
	}
	
	public int goodsUpdate(Goods goods) {
		return goodsMapper.goodsUpdate(goods);
	}
	
	public int goodsDelete(String gCode) {
		return goodsMapper.goodsDelete(gCode);
	}
}
