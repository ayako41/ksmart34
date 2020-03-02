package kr.or.ksmart.springboot34_34_mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ksmart.springboot34_34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_34_mybatis.mapper.MMapper;

@Service
public class MService {
	
	private MMapper mmapper;
	
	public List<Member> getlist(){
		
		return mmapper.getlist();
	};
}
