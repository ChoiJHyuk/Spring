package com.myspring.pro30.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.pro30.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map<String, Object> articleMap)throws Exception;
//	public ArticleVO viewArticle(int articleNO)throws Exception;
	public Map viewArticle(int articleNO)throws Exception;
	public void modArticle(Map<String, Object> articleMap);
	public void removeArticle(int articleNO);
}
