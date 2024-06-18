package com.poscodx.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.PostVo;

@Repository
public class PostRepository {
	private SqlSession sqlSession;
	
	public PostRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int addPost(PostVo postVo) {
		return sqlSession.insert("blog.addPost", postVo);
	}

	public List<PostVo> getPostList(Long categoryNo) {
		return sqlSession.selectList("blog.getPostList",categoryNo);
	}

}
