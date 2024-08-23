package com.example.demo.controller;


import com.example.demo.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.FileData;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class HomepageController {

	private final FileStorageService storageService;

	@RequestMapping("/")
	public ModelAndView homeView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("homepage");
		view.addObject("totalCount",storageService.totalUplodedFile());
		return view;
	}

	@PostMapping("/")
	public ModelAndView addfiletoDatabase(@RequestParam("file_name") MultipartFile file) {
		ModelAndView view = new ModelAndView("homepage");
		view.addObject("id", storageService.save(file));
		view.addObject("totalCount",storageService.totalUplodedFile());
		return view;
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("key") String id) {

		Pair<Resource,FileData> fileDataPair = storageService.downloadFile(id);

		if (Objects.isNull(fileDataPair)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.header(HttpHeaders.LOCATION, "/")
					.build();
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDataPair.getSecond().getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + fileDataPair.getSecond().getFilename())
				.body(fileDataPair.getFirst());

	}

	@GetMapping("/error")
	public String error() {
		return "error";

	}

}
