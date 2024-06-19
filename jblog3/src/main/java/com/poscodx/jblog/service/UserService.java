package com.poscodx.jblog.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
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
		return userRepository.findByIdAndPassword(id,password);
	}

	public void makeBlog(@Valid UserVo vo) {
		userRepository.makeBlog(vo);
	}
}