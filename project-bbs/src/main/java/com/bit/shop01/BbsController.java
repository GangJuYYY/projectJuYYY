package com.bit.shop01;
import java.sql.SQLException;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.shop01.model.BbsDao;
import com.bit.shop01.model.entity.bbsVo;
import com.bit.shop01.service.BbsService;

@Controller
public class BbsController {
	@Autowired
	BbsService service;
	
	String view="redirect:/notice/";
	
	public void setService(BbsService service) {
		this.service = service;
	}


	@RequestMapping("/")
	public String test() throws SQLException {
		return "home";
	}
	@RequestMapping(value="/notice/",method=RequestMethod.GET)
	public String list(Model model) throws SQLException {
		service.listPage(model);
		return "/bbs/not_bbs";
	}
	@RequestMapping(value="/notice/",method=RequestMethod.POST)
	public String add(@ModelAttribute bbsVo bean, String memId) throws SQLException {
		System.out.println(bean.getMemId());
		System.out.println(memId);
		service.addPage(bean);
		return view;
	}
	@RequestMapping(value="/notice/{bbsNum}",method=RequestMethod.DELETE)
	public String del(@PathVariable int bbsNum) throws SQLException {
		service.deletePage(bbsNum);
		return view;
	}
	@RequestMapping(value="/notice/{bbsNum}", method=RequestMethod.PUT)
	public String edit(@PathVariable int bbsNum
			, @ModelAttribute bbsVo bean,Model model) throws SQLException {
		service.updatePage(bean);
		model.addAttribute("bbsNum", bbsNum);
		return view;
	}
	
}