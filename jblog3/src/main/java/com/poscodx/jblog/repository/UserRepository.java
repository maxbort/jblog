package com.poscodx.jblog.repository;

import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.UserVo;

@Repository
public class UserRepository {
	
	private SqlSession sqlSession;
	
	public UserRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(UserVo vo) {
		return sqlSession.insert("user.insert", vo);
	}
	
	
	public UserVo findById(String id) {
		return sqlSession.selectOne("user.findById", id);
	}
	
	public int update(UserVo vo) {
		return sqlSession.update("user.update", vo);
	}

	public UserVo findByIdAndPassword(String id, String password) {
		System.out.println(id+password);
		UserVo vo = sqlSession.selectOne("user.findByIdAndPassword", Map.of("id", id, "password",password));
		System.out.println(vo);
		return vo;
	}

	public int makeBlog(UserVo vo) {
		
		return sqlSession.insert("user.makeBlog", vo);
	}
}