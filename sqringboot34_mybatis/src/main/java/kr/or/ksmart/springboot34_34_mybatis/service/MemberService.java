package kr.or.ksmart.springboot34_34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_34_mybatis.mapper.MemberMapper;

@Service
@Transactional//これがあれば、この中にあるメソッド全てがトランゼクションされる。
public class MemberService {
	
	@Autowired//シングルトン。オブジェクトを生成し、自動で消滅させてくれる？
	private MemberMapper memberMapper;
	
	public int mDelete(String mId) {
		return memberMapper.mDelete(mId);
	}
	
	public int mUpdate(Member member) {
		return memberMapper.mUpdate(member);
	}
	
	public Member selectForUpdate(String mId) {
		return memberMapper.selectForUpdate(mId);
	}
	
	public int mInsert(Member member) {
		return memberMapper.mInsert(member);
	}
	
	public List<Member> getMemberList(){
		//List<Member> mlist = memberMapper.getMemberList();
		return memberMapper.getMemberList();
	}
	public List<Member> getSelectList(String sk,String sv){
		//List<Member> mlist = memberMapper.getMemberList();
		return memberMapper.getSelectList(sk,sv);
	}
}
