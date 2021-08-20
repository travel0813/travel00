package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.employeeMapper";
	String statement;
	
	//직원 리스트페이지
	public List<EmployeeDTO> empList(EmployeeDTO dto){
		statement = namespace + ".empList";
		System.out.println("★★★★★★★");
		return sqlSession.selectList(statement, dto);
		
	}
	
	//카운트번호
	public int count() {
		statement = namespace + ".count";
		return sqlSession.selectOne(statement);
	}
	
	//직원등록
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i + "개가 저장 되었습니다.");
	}
	
	
	//관리번호
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
		
	}

	
	

}
