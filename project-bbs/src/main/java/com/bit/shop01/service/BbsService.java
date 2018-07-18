package com.bit.shop01.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.shop01.model.BbsDao;
import com.bit.shop01.model.entity.bbsVo;


@Service
public class BbsService {
	@Autowired
	BbsDao bbsDao;
	public void listPage(Model model) throws SQLException {
		model.addAttribute("alist", bbsDao.selectAll());
		model.addAttribute("total", bbsDao.selectTotal());
	}

	public void addPage(bbsVo bean) throws SQLException {
		bbsDao.insertOne(bean);
	}
	
	public void deletePage(int bbsNum) throws SQLException {
		bbsDao.deleteOne(bbsNum);
		
	}
	
	public void updatePage(bbsVo bean) throws SQLException {
		bbsDao.updateOne(bean);
	}
}
