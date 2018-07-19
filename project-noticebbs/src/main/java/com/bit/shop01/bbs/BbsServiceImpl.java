package com.bit.shop01.bbs;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mybatis.BbsMapper;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsMapper bbsMapper;

	public ArrayList<BbsVo> getbbseditList(String bbscd) {

		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("bbscd", bbscd);

		return bbsMapper.getbbseditList(hashmap);
	}

	public int insert(BbsVo bbsVo) {

		return bbsMapper.insert(bbsVo);
	}

	public void update(BbsVo bbsVo) {

		bbsMapper.update(bbsVo);

	}

	public void delete(int bbseditno) {

		bbsMapper.delete(bbseditno);
	}

	public String getBbsNm(String bbscd) {

		return bbsMapper.getBbsNm(bbscd);
	}

	/*
	 * 게시판 조회수 증가
	 */
	public void increaseHit(int bbseditno) {
		bbsMapper.increaseHit(bbseditno);
	}

	/*
	 * 게시판 객체 가져오기
	 */
	public BbsVo getBbsVo(int bbseditno) {
		return bbsMapper.getBbsVo(bbseditno);
	}
	
	
//	/*
//	 * 이전 글 보기
//	 */
//	public BbsVo getPrevBbsVo(int bbseditno, String bbscd) {
//		
//		 HashMap<String, String> hashmap = new HashMap<String, String>();
//		  Integer no = bbseditno;
//		  hashmap.put("bbseditno", no.toString());
//		  hashmap.put("bbscd", bbscd);
//		  
//		  return bbsMapper.getPrevBbsVo(hashmap);
//	}
//
//	/*
//	 * 다음 글 보기
//	 */
//	public BbsVo getNextBbsVo(int bbseditno, String bbscd) {
//		
//		 HashMap<String, String> hashmap = new HashMap<String, String>();
//		  Integer no = bbseditno;
//		  hashmap.put("bbseditno", no.toString());
//		  hashmap.put("bbscd", bbscd);
//		  
//		  return bbsMapper.getNextBbsVo(hashmap);
//	}
//	
	
}
