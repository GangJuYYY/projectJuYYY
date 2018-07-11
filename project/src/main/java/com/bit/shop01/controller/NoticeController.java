package com.bit.shop01.controller;
import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.shop01.model.BbsDao;
import com.bit.shop01.model.entity.bbsVo;

@Controller
@RequestMapping("/bbs")
public class NoticeController {
	@Autowired
	BbsDao<bbsVo> bbsDao;

//	@RequestMapping("/not_bbs")
//	public String list(Model model) throws SQLException {
//		model.addAttribute("alist", bbsDao.selectAll());
//		return "bbs2/not_bbs";
//	}
	@RequestMapping("/ndetail")
	public String detail(int idx,Model model) throws SQLException {
		model.addAttribute("bean", bbsDao.selectOne(idx));
		return "bbs2/ndetail";
	}
	
	@RequestMapping("/nadd")
	public String add() {
		return "bbs2/nadd";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(int bbsNum,String memId,String title,String contents) throws SQLException {
		bbsVo bean=new bbsVo(bbsNum,memId,title,contents,null);
		bbsDao.insertOne(bean);
		return "redirect:not_bbs";
	}
	
	@RequestMapping("/nedit")
	public String editFrom(int idx,Model model) throws SQLException {
		model.addAttribute("bean", bbsDao.selectOne(idx));
		return "bbs2/nedit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute bbsVo bean) throws SQLException {
		
		if(bbsDao.updateOne(bean)>0)
		return "redirect:ndetail?idx="+bean.getBbsNum();
		return "redirect:nedit?idx="+bean.getBbsNum();
	}
	
	@RequestMapping(value="/delete")
	public String delete(int idx) throws SQLException {
		bbsDao.deleteOne(idx);
		return "redirect:not_bbs";
	}
}
