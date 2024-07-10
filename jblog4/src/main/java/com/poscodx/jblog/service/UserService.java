package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.repository.CategoryRepository;
import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	public void join(UserVo vo) {
		userRepository.insert(vo);
		
	}

	public void update(UserVo vo) {
		userRepository.update(vo);
	}
	
	public UserVo getUser(String id) {
		return userRepository.findById(id);
	}
	public UserVo getUser(String id, String password) {
		System.out.println("id3 ="+ id + "pass123"+password);
		return userRepository.findByIdAndPassword(id,password);
	}


}