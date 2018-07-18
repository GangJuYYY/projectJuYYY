package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.shop01.model.BbsDao;
import com.bit.shop01.model.entity.bbsVo;

@Repository
public class BbsDaoImpl01 implements BbsDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<bbsVo> selectAll() throws SQLException {
		return sqlSession.selectList("notice.selectAll");
	
	}

	@Override
	public bbsVo selectOne(int bbsNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public int insertOne(bbsVo bean) throws SQLException {
		sqlSession.insert("notice.insertOne",bean);
		return 0;
		
	}

	@Override
	public int updateOne(bbsVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.update("notice.updateOne",bean);
		
		}
	

	@Override
	public int deleteOne(int bbsNum) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.delete("notice.deleteOne",bbsNum);
	
		}
	
	

	@Override
	public int selectTotal() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.total");
	}

}