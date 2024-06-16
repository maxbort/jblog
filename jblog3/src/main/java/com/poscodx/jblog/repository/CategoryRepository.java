package com.poscodx.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {

	private SqlSession sqlSession;
	
	public CategoryRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<CategoryVo> getCategoryListAndPostCount(String id) {
		return sqlSession.selectList("category.getCategoryListAndPostCount", id);
	}
	public int addCategory(CategoryVo categoryVo) {
		return sqlSession.insert("category.insertNewCategory", categoryVo);
	}
	public int deleteCategory(Long no) {
		return sqlSession.delete("category.deleteCategory", no);

	}

}
