package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.util.FileuploadUtil;

@RestController
public class FileuploadController {

	@Autowired
	private FileuploadUtil fileuploadUtil;

	public FileuploadController() {
		System.out.println("FileuploadController created.");
	}

	@PostMapping(value = "/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		System.out.println(file.getSize());
//		System.out.println(file.getOriginalFilename());

		try {
			// file validation for not empty
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File should be provide.");
			}

			// file validation only for jpeg type
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg files are allowed.");
			}

			// file upload
			boolean upload = fileuploadUtil.fileUpload(file);
			if (upload) {
				System.out.println("File uploaded successfully.");
				// return ResponseEntity.ok("File uploaded successfully.");

				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
						.path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
	}
}
