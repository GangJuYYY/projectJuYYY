package com.bit.shop01.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.shop01.model.entity.bbsVo;
import com.bit.shop01.model.BbsDao;


@Controller
public class ShopController {
	@Autowired
	BbsDao<bbsVo> bbsDao;
	@RequestMapping("/outer/")
	public String outer(Model model,HttpServletRequest req) throws SQLException {
		return "outDetail";
	}
	
	
	@RequestMapping("/top/")
	public String top(Model model,HttpServletRequest req) throws SQLException {
		return "topDetail";
	}
	
	
	@RequestMapping("/bottom/")
	public String bottom(Model model,HttpServletRequest req) throws SQLException {
			return "botDetail";
	}

	
	@RequestMapping("/dress/")
	public String dress(Model model,HttpServletRequest req) throws SQLException {
	return "dreDetail";
	}

	
	@RequestMapping("/shoeacc/")
	public String shoeacc(Model model,HttpServletRequest req) throws SQLException {
		return "sho&accDetail";
	}

	
	@RequestMapping("/sale/")
	public String sale(Model model,HttpServletRequest req) throws SQLException {
		return "saleDetail";
	}
	
	@RequestMapping("/login/")
	public String login(Model model,HttpServletRequest req) throws SQLException {
		return "/member/login";
	}

	@RequestMapping("/join/")
	public String join(Model model,HttpServletRequest req) throws SQLException {
		return "/member/join";
	}
	
	@RequestMapping("/not_bbs/")
	public String not_bbs(Model model,HttpServletRequest req) throws SQLException {
		model.addAttribute("alist", bbsDao.selectAll());
		return "/bbs/not_bbs";
	}
	
	@RequestMapping("/mypage/")
	public String mypage(Model model,HttpServletRequest req) throws SQLException {
		return "/info/mypage";
	}
	

	}
	


	

