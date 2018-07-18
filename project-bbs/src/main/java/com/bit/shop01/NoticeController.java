//package com.bit.shop01;
//
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.bit.shop01.model.BbsDao;
//import com.bit.shop01.model.entity.bbsVo;
//
//@Controller
//public class NoticeController {
//
//	@Autowired
//	BbsDao<bbsVo> dao;
//	
//	@RequestMapping("/")
//	public String home() {
//		return "home";
//	}
//	
//	@RequestMapping("/not_bbs.bit")
//	public String list(Model model){
//		try {
//			model.addAttribute("alist", dao.selectAll());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "/bbs/not_bbs";
//	}
//	
//	@RequestMapping("/detail.bit")
//	public String detail(Model model,HttpServletRequest req) {
//		String idx=req.getParameter("idx");
//		int pk=Integer.parseInt(idx);
//		
//		try {
//			model.addAttribute("bean", dao.selectOne(pk));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "/bbs/detail";
//	}
//	
//	@RequestMapping("/edit.bit")
//	public String edit(Model model,HttpServletRequest req) {
//		String idx=req.getParameter("idx");
//		int pk=Integer.parseInt(idx);
//		
//		try {
//			model.addAttribute("bean", dao.selectOne(pk));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "/bbs/edit";
//	}
//	
//	@RequestMapping("add.bit")
//	public String add() {
//		return "/bbs/add";
//	}
//	
//	@RequestMapping("insert.bit")
//	public String insert(HttpServletRequest req) {
//		
//		bbsVo bean=new bbsVo();
//		bean.setBbsNum(Integer.parseInt(req.getParameter("bbsNum")));
//		bean.setMemId(req.getParameter("memId"));
//		bean.setTitle(req.getParameter("title"));
//		bean.setContents(req.getParameter("contents"));
//		try {
//			dao.insertOne(bean);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return "redirect:/not_bbs.bit";
//	}
//	
//	@RequestMapping("/update.bit")
//	public String update(int bbsNum, String memId, String title, String contents) {
//		
//		bbsVo bean=new bbsVo();
//		bean.setBbsNum(bbsNum);
//		bean.setMemId(memId);
//		bean.setTitle(title);
//		bean.setContents(contents);
//		try {
//			dao.updateOne(bean);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "redirect:/detail.bit?idx="+bbsNum;
//	}
//}

