package kr.or.ksmart.springboot34_34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_34_mybatis.domain.Member;

@Mapper
public interface MMapper {

	public List<Member> getlist();
}
