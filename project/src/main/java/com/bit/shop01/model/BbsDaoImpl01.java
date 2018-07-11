package com.bit.shop01.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.shop01.model.entity.bbsVo;

public class BbsDaoImpl01 implements BbsDao<bbsVo> {
	
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<bbsVo> rowMapper=new RowMapper<bbsVo>() {
		
		@Override
		public bbsVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new bbsVo(
					rs.getInt("bbsNum")
					,rs.getString("memId")
					,rs.getString("title")
					,rs.getString("contents")
					,rs.getDate("bbs_date")
					);
		}
	};

	@Override
	public List<bbsVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SHOP_BBS ORDER BY BBSNUM DESC";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public bbsVo selectOne(int pk) throws SQLException {
		String sql="SELECT * FROM SHOP_BBS WHERE BBSNUM=?";
		return jdbcTemplate.queryForObject(sql
				,new Object[] {pk}, rowMapper);
	}

	@Override
	public int insertOne(bbsVo bean) throws SQLException {
		String sql="INSERT INTO SHOP_BBS VALUES (?,?,?,?,sysdate)";
		return jdbcTemplate.update(sql
				, new Object[] {bean.getBbsNum(),bean.getMemId(),bean.getTitle(),bean.getContents(),null});
	}

	@Override
	public int updateOne(bbsVo bean) throws SQLException {
		String sql="UPDATE SHOP_BBS SET MEMID=?,TITLE=? WHERE BBSNUM=?";
		return jdbcTemplate.update(sql
				, new Object[] {bean.getMemId(),bean.getTitle(),bean.getBbsNum()});
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="DELETE FROM SHOP_BBS WHERE BBSNUM=?";
		return jdbcTemplate.update(sql,new Object[] {pk});
	}

}
