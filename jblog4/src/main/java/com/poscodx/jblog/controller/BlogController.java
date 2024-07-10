package com.poscodx.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.security.AuthUser;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(
		@PathVariable("id") String id,
		@PathVariable(value="categoryNo", required=false) Long categoryNo,
		@PathVariable(value="postNo", required=false) Long postNo,
		Model model) {
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute(blogVo);
		
		if(categoryNo == null) {
			categoryNo = blogService.getLastCategoryNo(id);
		}
		if(postNo==null) {
			postNo = blogService.getLastPostNo(categoryNo);
		}
		model.addAttribute("id",id);
		List<PostVo> postList = blogService.getPostList(categoryNo);
		model.addAttribute("postList",postList);
		
		
		PostVo nowPost = blogService.getPost(postNo);
		model.addAttribute("nowPost", nowPost);

		List<CategoryVo> categoryList = blogService.getCategoryList(id);
		model.addAttribute("categoryList", categoryList);
		
		
		return "blog/main";
	}
	

	@RequestMapping(value="/admin/basic", method=RequestMethod.GET)
	public String adminBasic(@PathVariable String id, @AuthUser UserVo vo, Model model) {
		
		UserVo authUser = userService.getUser(vo.getId());
		System.out.println(id);
		System.out.println(authUser.getId());
		if(!id.equals(authUser.getId())) {
			return "blog/main";
		}
		BlogVo blogVo = blogService.getBlog(id);

		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin-basic";
	}
	

	
	@RequestMapping(value="/admin/basic/modify", method=RequestMethod.POST)
	public String adminBasicModify(@PathVariable("id") String id,
			@ModelAttribute("blogVo") BlogVo blogVo,
			@RequestParam(value="newLogo", required=false) MultipartFile file,
			@RequestParam("currentLogo") String currentLogo,
			Model model) {
		
		if(file != null && !file.isEmpty()) {
			blogVo.setLogo(fileUploadService.restore(file));
		} else {
			blogVo.setLogo(currentLogo);
		}
		blogService.modifyBlog(blogVo);
		
		return "redirect:/{id}/admin/basic";
	}

	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable String id, Model model) {
		
		BlogVo blogVo = blogService.getBlog(id);
		
		List<CategoryVo> categoryList = blogService.getCategoryListAndPostCount(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList",categoryList);
		
		return "blog/admin-category";
	}
	
	
	@RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
	public String addCategory(@PathVariable String id, CategoryVo categoryVo) {
		
		
		categoryVo.setBlogId(id);
		
		blogService.addCategory(categoryVo);
		return "redirect:/{id}/admin/category";
	}
	
	@RequestMapping(value = "/admin/category/delete/{no}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") String id, @PathVariable("no") Long no) {
		
		List<PostVo> a = blogService.getPostList(no);
		
		if(a.size() == 0) {
			blogService.deleteCategory(no);
			return "redirect:/{id}/admin/category";
		} else {
			return "redirect:/{id}/admin/category";
		}
	}
	
	
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable String id, Model model) {
		
		BlogVo blogVo = blogService.getBlog(id);
		List<CategoryVo> categoryList = blogService.getCategoryListAndPostCount(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		
		return "blog/admin-write";
	}
	
	@RequestMapping(value = "/admin/write", method = RequestMethod.POST)
	public String addPost(@PathVariable String id, @ModelAttribute PostVo postVo) {
		System.out.println(postVo);
		blogService.addPost(postVo);
		return "redirect:/{id}/admin/write";
	}
	

}