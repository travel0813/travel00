package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.memberMapper";
	String statement;
	
	
	public MemberDTO memInfo(String memId) {
		statement = namespace + ".memInfo";
		return sqlSession.selectOne(statement, memId);
	}
	
	//회원등록
	public void memJoin(MemberDTO dto) {
		statement = namespace + ".memJoin";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 추가 완료");
	}

}
