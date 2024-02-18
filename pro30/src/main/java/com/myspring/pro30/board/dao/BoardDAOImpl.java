package com.myspring.pro30.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	
	@Override
	public int insertNewArticle(Map<String, Object> articleMap)throws DataAccessException {
		int articleNo = selectNewArticleNO();
		articleMap.put("articleNO", articleNo);
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);
		return articleNo;
	}
	
	private int selectNewArticleNO()throws DataAccessException {
		int articleNo = sqlSession.selectOne("mapper.board.selectNewArticleNO");
		return articleNo;
	}

	@Override
	public ArticleVO selectArticle(int articleNO)throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle",articleNO);
	}

	@Override
	public void updateArticle(Map<String, Object> articleMap) {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNO) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.board.deleteArticle",articleNO);
	}

	@Override
	public void insertNewImage(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.board.insertNewImage",imageFileList);
	}

	private int selectNewImageFileNO() {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	@Override
	public List<ImageVO> selectImageFileList(int articleNO) {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", articleNO);
		return imageFileList;
	}
	
	
}
