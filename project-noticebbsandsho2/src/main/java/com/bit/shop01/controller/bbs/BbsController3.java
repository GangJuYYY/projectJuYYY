package com.bit.shop01.controller.bbs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.shop01.bbs.BbsService;
import com.bit.shop01.bbs.BbsVo;

@Controller
public class BbsController3 {

	@Autowired
	private BbsService bbsService;

	// notice 게시판 맵핑
	@RequestMapping(value = "/rev_bbs", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbs(String bbscd, Model model) throws Exception {

		if (bbscd == null)
			bbscd = "review";

		ArrayList<BbsVo> list = bbsService.getbbseditList(bbscd);
		String bbsnm = bbsService.getBbsNm(bbscd);

		model.addAttribute("list", list);
		model.addAttribute("bbsnm", bbsnm);
		model.addAttribute("bbscd", bbscd);

		return "/bbs/rev_bbs";
	}

	// notice 게시판 리스트
	@RequestMapping(value = "/rev_bbs_write", method = RequestMethod.GET)
	public String write(String bbscd, Model model) throws Exception {

		// 게시판 이름
		String bbsnm = bbsService.getBbsNm(bbscd);
		model.addAttribute("bbsnm", bbsnm);

		return "/bbs/rev_bbs_write";
	}

	// notice 게시판 글작성
	@RequestMapping(value = "/rev_bbs_write", method = RequestMethod.POST)
	public String write(BbsVo bbsVo) {
		bbsVo.setMemId("${memId}");
		System.out.println(bbsVo);
		bbsService.insert(bbsVo);
		return "redirect:/rev_bbs?bbscd=" + bbsVo.getBbscd();
	}

	@RequestMapping(value = "/rev_bbs_detail", method = RequestMethod.GET)
	public String view(int bbseditno, String bbscd, Model model) {

		bbsService.increaseHit(bbseditno);

		// 상세보기
		BbsVo thisBbsVo = bbsService.getBbsVo(bbseditno);
		
// 이전, 다음 글 보기		
//		BbsVo prevBbsVo = bbsService.getPrevBbsVo(bbseditno, bbscd);
//		BbsVo nextBbsVo = bbsService.getNextBbsVo(bbseditno, bbscd);

		ArrayList<BbsVo> list = bbsService.getbbseditList(bbscd);
		String bbsnm = bbsService.getBbsNm(bbscd);

		model.addAttribute("thisBbsVo", thisBbsVo);
//		model.addAttribute("prevBbsVo", prevBbsVo);
//		model.addAttribute("nextBbsVo", nextBbsVo);
		
		System.out.println(thisBbsVo);

		model.addAttribute("list", list);
		model.addAttribute("bbsnm", bbsnm);
		model.addAttribute("bbscd", bbscd);

		return "/bbs/rev_bbs_detail";
	}
	
	
	
	
	// 게시글 삭제 
	 @RequestMapping(value="/rev_bbs_delete", method=RequestMethod.GET)
	    public String delete(int bbseditno,
	            String bbscd) throws Exception {
	       
	        bbsService.delete(bbseditno);
	       
	        return "redirect:/rev_bbs?bbscd=" + bbscd;
	 
	    }  
	   
	 
	 // 게시글 수정
	    @RequestMapping(value="/rev_bbs_edit", method=RequestMethod.GET)
	    public String update(int bbseditno,
	            String bbscd,
	            Model model) throws Exception {
	       
	        BbsVo thisBbsVo = bbsService.getBbsVo(bbseditno);
	        String bbsnm = bbsService.getBbsNm(bbscd);
	         
	        //수정페이지에서 보일 게시글 정보
	        model.addAttribute("thisBbsVo", thisBbsVo);
	        model.addAttribute("bbsnm", bbsnm);
	       
	        return "/bbs/rev_bbs_edit";
	    }
	   
	    
	    @RequestMapping(value="/rev_bbs_edit", method=RequestMethod.POST)
	    public String update(BbsVo bbsVo,
	            String bbscd,
	            Model model) throws Exception {
	       
	        bbsService.update(bbsVo);
	       
	        return "redirect:/rev_bbs_detail?bbseditno=" + bbsVo.getBbseditno() +
	                "&bbscd=" + bbsVo.getBbscd();
	    }
	
	
}
