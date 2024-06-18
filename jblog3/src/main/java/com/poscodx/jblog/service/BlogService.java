package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.repository.CategoryRepository;
import com.poscodx.jblog.repository.PostRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public BlogVo getBlog(String id) {
		return blogRepository.getBlog(id);
	}

	public int modifyBlog(BlogVo blogVo) {
		return blogRepository.modifyBlog(blogVo);
	}

	public List<CategoryVo> getCategoryListAndPostCount(String id) {
		return categoryRepository.getCategoryListAndPostCount(id);
	}

	public int addCategory(CategoryVo categoryVo) {
		return categoryRepository.addCategory(categoryVo);
		
	}

	public int deleteCategory(Long no) {
		return categoryRepository.deleteCategory(no);
		
	}

	public int addPost(PostVo postVo) {
		return postRepository.addPost(postVo);
		
	}

	public List<PostVo> getPostList(Long categoryNo) {
		return postRepository.getPostList(categoryNo);
	}

}
