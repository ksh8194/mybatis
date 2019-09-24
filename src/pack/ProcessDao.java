package pack;


import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	public static ProcessDao getInstance() { //singleton pattern
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); //datamapper.xml에 있는 아이디를 읽기 위해 필요
	
	public List selectdataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession(); //여기서 session은 작업단위 웹하고 관련x
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public ProductBean selectData(String arg) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		ProductBean bean = sqlSession.selectOne("selectDataPart",arg);
		sqlSession.close();
		return bean;
	}
	
	public void insertData(ProductBean bean) throws SQLException{
		SqlSession session = factory.openSession(); //수동
		//SqlSession session = factory.openSession(true);//자동저장
		session.insert("insertData",bean);
		session.commit();
		session.close();
	}
	
	

}






