package com.example.demo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.FileData;
import com.example.demo.serive.Filestorageimple;

@Controller
public class HomepageController {
	@Autowired 
	@Qualifier("filestorage")
	Filestorageimple filestorageimple;
	@RequestMapping("/")
	public ModelAndView homeView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("homepage.jsp");
		return view;
	}
	@PostMapping("/")
	public ModelAndView addfiletoDatabase(@RequestParam("file_name") MultipartFile file,HttpSession session) {
		ModelAndView view = new ModelAndView("homepage.jsp"); 
	       view.addObject("id",  filestorageimple.save(file));
		return view;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Resource> downloadFile (@PathVariable String id) {
		  FileData fileData =  filestorageimple.downloadFile(id);
System.err.println(fileData.getFilename());
System.err.println(fileData.getFiletype());
System.err.println(fileData.getId());
System.err.println(fileData.getUuid());
System.err.println(fileData.getFile());
	return ResponseEntity.ok()
     .contentType(MediaType.parseMediaType(fileData.getFiletype()))
     .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+fileData.getFilename())
     .body(new ByteArrayResource(fileData.getFile()));

		 

	}
}
