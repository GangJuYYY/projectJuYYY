package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.shop01.model.entity.bbsVo;
import com.bit.shop01.model.entity.bbsVo;

public interface BbsDao<T> {

	List<bbsVo> selectAll() throws SQLException;
	bbsVo selectOne(int bbsNum) throws SQLException;
	int insertOne(bbsVo bean) throws SQLException;
	int updateOne(bbsVo bean) throws SQLException;
	int deleteOne(int bbsNum) throws SQLException;
	int selectTotal() throws SQLException;
}
