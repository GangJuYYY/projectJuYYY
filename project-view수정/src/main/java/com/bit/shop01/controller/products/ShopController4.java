package com.bit.shop01.controller.products;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.shop01.bbs.AttachFile;
import com.bit.shop01.page.PagingHelper;
import com.bit.shop01.page.WebContants;
import com.bit.shop01.products.ProductsService;
import com.bit.shop01.products.ProductsVo;

@Controller
public class ShopController4 {

	 @Autowired
	    private ProductsService productsService;
	   
	    @RequestMapping(value="/dress", method={RequestMethod.GET, RequestMethod.POST})
	    public String dress(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "dress";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	        int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);//curPage�뒗 null 媛믪씠硫� 1濡� 留뚮뱾�뼱�빞 �븯誘�濡�
	        
	       
	        return "products/dreDetail"; 
	    }
	    
	    
	    
	    
	    @RequestMapping(value="/dress_write", method=RequestMethod.GET)
	    public String dress_write(String procd, Model model) throws Exception {
	       
	        //寃뚯떆�뙋 �씠由�
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products/dress_write";
	    }
	   
	    @RequestMapping(value="/dress_write", method=RequestMethod.POST)
	    public String outer_write(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	    
	        
	        //�뙆�씪�뾽濡쒕뱶
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        
	        //�뙆�씪�뜲�씠�꽣 �궫�엯
	        
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/dress/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/dress_detail", method=RequestMethod.GET)
	    public String dress_detail(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\spring\\spring2018\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t �뙆�씪 �씠由� = " + file.getName());

					} else {
						System.out.println("�뙆�씪�뾾�쓬");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	    	  int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	    	  if (searchWord == null) searchWord = ""; // 寃��깋�뼱媛� null �씠硫� ""�쑝濡� 蹂�寃� 
	    	  
	    	  
	    	  //紐⑸줉蹂닿린
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        //�긽�꽭蹂닿린
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products/dreDetail_detail";
	    }
	    
	    
	    
	    @RequestMapping(value="/dress_delete", method=RequestMethod.GET)
	    public String dress_delete(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/dress/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/dress_edit", method=RequestMethod.GET)
	    public String dress_edit(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        //�닔�젙�럹�씠吏��뿉�꽌 蹂댁씪 寃뚯떆湲� �젙蹂�
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products/dress_edit";
	    }
	   
	    
	    
	    @RequestMapping(value="/dress_edit", method=RequestMethod.POST)
	    public String dress_edit(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       //�뙆�씪�뾽濡쒕뱶
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       //�뙆�씪�뜲�씠�꽣 �궫�엯
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/dress_detail/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    

		// 濡쒓렇�씤 �썑


	    @RequestMapping(value="/dress2", method={RequestMethod.GET, RequestMethod.POST})
	    public String dress2(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "dress";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	        int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);//curPage�뒗 null 媛믪씠硫� 1濡� 留뚮뱾�뼱�빞 �븯誘�濡�
	        
	       
	        return "products2/dreDetail2"; 
	    }
	    
	    
	    
	    
	    @RequestMapping(value="/dress_write2", method=RequestMethod.GET)
	    public String dress_write2(String procd, Model model) throws Exception {
	       
	        //寃뚯떆�뙋 �씠由�
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products2/dress_write2";
	    }
	   
	    @RequestMapping(value="/dress_write2", method=RequestMethod.POST)
	    public String dress_write2(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	    
	        
	        //�뙆�씪�뾽濡쒕뱶
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        
	        //�뙆�씪�뜲�씠�꽣 �궫�엯
	        
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/dress2/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/dress_detail2", method=RequestMethod.GET)
	    public String dress_detail2(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\spring\\spring2018\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t �뙆�씪 �씠由� = " + file.getName());

					} else {
						System.out.println("�뙆�씪�뾾�쓬");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	    	  int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	    	  if (searchWord == null) searchWord = ""; // 寃��깋�뼱媛� null �씠硫� ""�쑝濡� 蹂�寃� 
	    	  
	    	  
	    	  //紐⑸줉蹂닿린
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        //�긽�꽭蹂닿린
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products2/dress_detail2";
	    }
	    
	    
	    
	    @RequestMapping(value="/dress_delete2", method=RequestMethod.GET)
	    public String dress_delete2(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/dress2/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/dress_edit2", method=RequestMethod.GET)
	    public String dress_edit2(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        //�닔�젙�럹�씠吏��뿉�꽌 蹂댁씪 寃뚯떆湲� �젙蹂�
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products2/dress_edit2";
	    }
	   
	    
	    
	    @RequestMapping(value="/dress_edit2", method=RequestMethod.POST)
	    public String dress_edit2(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       //�뙆�씪�뾽濡쒕뱶
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       //�뙆�씪�뜲�씠�꽣 �궫�엯
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/dress_detail2/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    
	    
	    // 愿�由ъ옄  �럹�씠吏�
	    
	    

	    @RequestMapping(value="/dress3", method={RequestMethod.GET, RequestMethod.POST})
	    public String dress3(String procd,  Integer curPage,  Model model ,String searchWord) throws Exception{
	               
	        if (procd == null) procd = "dress";
	        if (curPage == null) curPage = 1;
	        if (searchWord == null) searchWord = "";
	        
	        int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	        int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	        
	        int totalRecord = productsService.getTotalRecord(procd, searchWord);
	        
	        PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	        productsService.setPagingHelper(pagingHelper);
	        
	        int start = pagingHelper.getStartRecord();
	        int end = pagingHelper.getEndRecord();

	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord,start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	        
	   
	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        model.addAttribute("curPage", curPage);//curPage�뒗 null 媛믪씠硫� 1濡� 留뚮뱾�뼱�빞 �븯誘�濡�
	        
	       
	        return "products3/dreDetail3"; 
	    }
	    
	    
	    
	    
	    @RequestMapping(value="/dress_write3", method=RequestMethod.GET)
	    public String dress_write3(String procd, Model model) throws Exception {
	       
	        //寃뚯떆�뙋 �씠由�
	        String pronm = productsService.getProductsNm(procd);
	        model.addAttribute("pronm", pronm);
	       
	        return "products3/dreDetail_write3";
	    }
	   
	    @RequestMapping(value="/dress_write3", method=RequestMethod.POST)
	    public String dress_write3(ProductsVo productsVo , MultipartHttpServletRequest mpRequest) throws Exception{
	        productsService.insert(productsVo);
	        productsVo.setProductNum(productsService.getNewProductsVo().getProductNum());
	        
	    
	        
	        //�뙆�씪�뾽濡쒕뱶
	        List<MultipartFile> fileList = mpRequest.getFiles("upload");
	        for(MultipartFile mf : fileList){
	        String filename = mf.getOriginalFilename();
	        mf.transferTo(new File(WebContants.BASE_PATH + filename));
	        }
	       
	        
	        //�뙆�씪�뜲�씠�꽣 �궫�엯
	        
	        int size = fileList.size();
	        for (int i = 0; i < size; i++) {
	         MultipartFile mpFile = fileList.get(i);
	         AttachFile attachFile = new AttachFile();
	         String filename = mpFile.getOriginalFilename();
	         attachFile.setFilename(filename);
	         attachFile.setFiletype(mpFile.getContentType());
	         attachFile.setFilesize(mpFile.getSize());
	         attachFile.setProductNum(productsVo.getProductNum());
	         productsService.insertAttachFile(attachFile);
	        }     
	        
	        
	        return "redirect:/dress3/?procd=" + productsVo.getProcd();
	    }
	
	    
	    @RequestMapping(value="/dress_detail3", method=RequestMethod.GET)
	    public String dress_detail3(int productNum, Integer curPage, String procd, String searchWord, Model model){
	    	
	    	
	    	File dir = new File("C:\\spring\\spring2018\\project\\src\\main\\webapp\\resources\\imgs2"); 

			File[] fileList = dir.listFiles();

				System.out.println("start");
				for(int i = 0 ; i < fileList.length ; i++){

					File file = fileList[i]; 

					if(file.isFile()){

						System.out.println("\t �뙆�씪 �씠由� = " + file.getName());

					} else {
						System.out.println("�뙆�씪�뾾�쓬");
					}

				}

			System.out.println("end");
	    	
	    	
	    	  int numPerPage = 10;// �럹�씠吏��떦 �젅肄붾뱶 �닔 吏��젙
	    	  int pagePerBlock = 10;// �럹�씠吏� 留곹겕�쓽 洹몃９(block)�쓽 �겕湲� 吏��젙
	    	  if (searchWord == null) searchWord = ""; // 寃��깋�뼱媛� null �씠硫� ""�쑝濡� 蹂�寃� 
	    	  
	    	  
	    	  //紐⑸줉蹂닿린
	    	  int totalRecord = productsService.getTotalRecord(procd, searchWord);
	    	  System.out.println(curPage);
	    	  PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);  
	    	  productsService.setPagingHelper(pagingHelper);
	    	  
	    	  int start = pagingHelper.getStartRecord();
	    	  int end = pagingHelper.getEndRecord();
	       
	       
	        //�긽�꽭蹂닿린
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        ArrayList<AttachFile> attachFileList = productsService.getAttachFileList(productNum);
	 
	        ArrayList<ProductsVo> list = productsService.getProductsList(procd, searchWord, start, end);
	        String pronm = productsService.getProductsNm(procd);
	        Integer no = productsService.getListNo();
	        Integer prevLink = productsService.getPrevLink();
	        Integer nextLink = productsService.getNextLink();
	        Integer firstPage = productsService.getFirstPage();
	        Integer lastPage = productsService.getLastPage();
	        int[] pageLinks = productsService.getPageLinks();
	       
	        
	        model.addAttribute("no", no);
	        model.addAttribute("prevLink", prevLink);
	        model.addAttribute("nextLink", nextLink);
	        model.addAttribute("firstPage", firstPage);
	        model.addAttribute("lastPage", lastPage);
	        model.addAttribute("pageLinks", pageLinks);
	        
	        
	        model.addAttribute("thisProductsVo", thisProductsVo);

	        model.addAttribute("list", list);
	        model.addAttribute("pronm", pronm);
	        model.addAttribute("procd", procd);
	        model.addAttribute("attachFileList", attachFileList);
	       
	        return "products3/dress_detail3";
	    }
	    
	    
	    
	    @RequestMapping(value="/dress_delete3", method=RequestMethod.GET)
	    public String dress_delete3(int productNum,
	            String procd , Integer curPage, 
	            String searchWord) throws Exception {
	       
	        productsService.delete(productNum);
	       
	        return "redirect:/dress3/?procd=" + procd  + 
	        		  "&searchWord=" + searchWord;
	 }  
	   
	    
	    @RequestMapping(value="/dress_edit3", method=RequestMethod.GET)
	    public String dress_edit3(int productNum,
	            String procd,
	            Model model) throws Exception {
	       
	        ProductsVo thisProductsVo = productsService.getProductVo(productNum);
	        String pronm = productsService.getProductsNm(procd);
	         
	        //�닔�젙�럹�씠吏��뿉�꽌 蹂댁씪 寃뚯떆湲� �젙蹂�
	        model.addAttribute("thisProductsVo", thisProductsVo);
	        model.addAttribute("pronm", pronm);
	       
	        return "products3/dress_edit3";
	    }
	   
	    
	    
	    @RequestMapping(value="/dress_edit3", method=RequestMethod.POST)
	    public String dress_edit3(ProductsVo productsVo,  Integer curPage,
	            String procd, String searchWord,MultipartHttpServletRequest mpRequest, Model model) throws Exception {
	       
	       productsService.update(productsVo);
	       
	       //�뙆�씪�뾽濡쒕뱶
	       List<MultipartFile> fileList = mpRequest.getFiles("upload");
	       for(MultipartFile mf : fileList){
	       String filename = mf.getOriginalFilename();
	       mf.transferTo(new File(WebContants.BASE_PATH + filename));
	       }
	       
	       //�뙆�씪�뜲�씠�꽣 �궫�엯
	       int size = fileList.size();
	       for (int i = 0; i < size; i++) {
	        MultipartFile mpFile = fileList.get(i);
	        AttachFile attachFile = new AttachFile();
	        String filename = mpFile.getOriginalFilename();
	        attachFile.setFilename(filename);
	        attachFile.setFiletype(mpFile.getContentType());
	        attachFile.setFilesize(mpFile.getSize());
	        attachFile.setProductNum(productsVo.getProductNum());
	        productsService.insertAttachFile(attachFile);
	       }  
	       
	        return "redirect:/dress_detail3/?productNum=" + productsVo.getProductNum() +
	                "&procd=" + productsVo.getProcd() +  "&curPage=" + curPage  +
	                "&searchWord=" + searchWord;
	    }
	    
	    
	    
	    

	}


