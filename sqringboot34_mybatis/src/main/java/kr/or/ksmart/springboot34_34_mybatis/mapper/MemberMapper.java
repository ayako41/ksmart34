package kr.or.ksmart.springboot34_34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_34_mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	//db Member table 모든 행을 가져오는 메서드(쿼리문 xml 에 구현)
	public List<Member> getMemberList();
	
	public List<Member> getSelectList(String sk,String sv);
	
	public int mDelete(String mId);
	
	public int mInsert(Member member);
	
	public Member selectForUpdate(String mId);
	
	public int mUpdate(Member member);
}
