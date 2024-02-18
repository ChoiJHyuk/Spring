package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

public interface BoardDAO {
	public List selectAllArticlesList() throws DataAccessException;

	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

	public void updateArticle(Map<String, Object> articleMap);

	public void deleteArticle(int articleNO);

	public void insertNewImage(Map<String, Object> articleMap);

	public int insertNewArticle(Map<String, Object> articleMap);

	public List<ImageVO> selectImageFileList(int articleNO);
	
}
