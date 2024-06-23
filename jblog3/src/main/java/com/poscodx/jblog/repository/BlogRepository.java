 package com.poscodx.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;

@Repository
public class BlogRepository {
	
	private SqlSession sqlSession;
	
	public BlogRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public BlogVo getBlog(String id) {
		return sqlSession.selectOne("blog.getBlog", id);
	}

	public int modifyBlog(BlogVo blogVo) {
		return sqlSession.update("blog.modify",blogVo);
	}

	public Long getLastPostNo(Long categoryNo) {
		return sqlSession.selectOne("blog.getLastPostNo", categoryNo);
	}
	
	public int makeBlog(BlogVo blogVo) {
		
		return sqlSession.insert("blog.makeBlog", blogVo);
	}

}
