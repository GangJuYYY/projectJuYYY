package com.bit.shop01;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.shop01.model.BbsDao;
import com.bit.shop01.model.entity.bbsVo;

@Controller
public class HomeController {
	@Autowired
	BbsDao<bbsVo> dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	
	@RequestMapping("/not_bbs.bit")
	public String list(Model model){
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/bbs/not_bbs";
	}
	
	@RequestMapping("/ndetail.bit")
	public String detail(Model model,HttpServletRequest req) {
		String idx=req.getParameter("idx");
		int pk=Integer.parseInt(idx);
		
		try {
			model.addAttribute("bean", dao.selectOne(pk));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/bbs/ndetail";
	}
	
	@RequestMapping("/nedit.bit")
	public String edit(Model model,HttpServletRequest req) {
		String idx=req.getParameter("idx");
		int pk=Integer.parseInt(idx);
		
		try {
			model.addAttribute("bean", dao.selectOne(pk));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/bbs/nedit";
	}
	
	@RequestMapping("nadd.bit")
	public String add() {
		return "/bbs/nadd";
	}
	
	@RequestMapping("insert.bit")
	public String insert(HttpServletRequest req) {
		
		bbsVo bean=new bbsVo();
		bean.setBbsNum(Integer.parseInt(req.getParameter("num")));
		bean.setMemId(req.getParameter("id"));
		bean.setTitle(req.getParameter("title"));
		bean.setContents(req.getParameter("contents"));
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return "redirect:/not_bbs.bit";
	}
	
	@RequestMapping("/update.bit")
	public String update(int bbsNum, String memId, String title) {
		
		bbsVo bean=new bbsVo();
		bean.setBbsNum(bbsNum);
		bean.setMemId(memId);
		bean.setTitle(title);
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/ndetail.bit?idx="+bbsNum;
	}
}







	
//	
//	@RequestMapping(value = "/outer/", method = RequestMethod.GET)
//	public String outer(Model model) {
//		
//		return "outDetail";
//	
//	}
//
//	@RequestMapping(value = "/top/", method = RequestMethod.GET)
//	public String top(Locale locale, Model model) {
//		
//		return "topDetail";
//	
//	}
//
//	@RequestMapping(value = "/bottom/", method = RequestMethod.GET)
//	public String bottom(Locale locale, Model model) {
//		
//		return "botDetail";
//	
//	}
//
//	@RequestMapping(value = "/dress/", method = RequestMethod.GET)
//	public String dress(Locale locale, Model model) {
//		
//		return "dreDetail";
//	
//	}
//
//	@RequestMapping(value = "/shoeacc/", method = RequestMethod.GET)
//	public String shoeacc(Locale locale, Model model) {
//		
//		return "sho&accDetail";
//	
//	}	
//
//	@RequestMapping(value = "/sale/", method = RequestMethod.GET)
//	public String sale(Locale locale, Model model) {
//		
//		return "saleDetail";
//	
//	
//	}
//	

	
	
	
	

