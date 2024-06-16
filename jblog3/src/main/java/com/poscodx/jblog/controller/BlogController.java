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

import com.poscodx.jblog.security.Auth;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	FileUploadService fileUploadService;

	
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(
		@PathVariable("id") String id,
		@PathVariable(value="categoryNo", required=false) Long categoryNo,
		@PathVariable(value="postNo", required=false) Long postNo) {
		
		BlogVo blogvo = blogService.getBlog(id);
		
		return "blog/main";
	}
	
	@Auth
	@RequestMapping(value="/admin/basic", method=RequestMethod.GET)
	public String adminBasic(@PathVariable String id, Model model) {
		
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin-basic";
	}
	
	@Auth
	@RequestMapping(value="/admin/basic/modify", method=RequestMethod.POST)
	public String adminBasicModify(@PathVariable("id") String id,
			@ModelAttribute("blogVo") BlogVo blogVo,
			@RequestParam("newLogo") MultipartFile file,
			Model model) {

		blogVo.setLogo(blogService.getBlog(id).getLogo());
		if(file != null) {
			blogVo.setLogo(fileUploadService.restore(file));
		} 
		
		blogService.modifyBlog(blogVo);
		
		 return "redirect:/{id}/admin/basic";
	}

	@Auth
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable String id, Model model) {
		
		BlogVo blogVo = blogService.getBlog(id);
		
		List<CategoryVo> categoryList = blogService.getCategoryListAndPostCount(id);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList",categoryList);
		
		return "blog/admin-category";
	}
	
	
	
	@Auth
	@RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
	public String addCategory(@PathVariable String id, CategoryVo categoryVo) {
		
		
		categoryVo.setBlogId(id);
		
		blogService.addCategory(categoryVo);
		return "redirect:/{id}/admin/category";
	}
	
	@Auth
	@RequestMapping(value = "/admin/category/delete/{no}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") String id, @PathVariable("no") Long no) {
		
		blogService.deleteCategory(no);
		
		return "redirect:/{id}/admin/category";
	}
	
	
	//@Auth
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable String id) {
		return "blog/admin-write";
	}

}