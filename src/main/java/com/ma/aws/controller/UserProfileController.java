package com.ma.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ma.aws.service.UserProfileService;

@RestController
@RequestMapping("/api/v1/")
public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;
	
	@PostMapping(
			path = "{userID}/image/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void uploadUserProfileImage(@PathVariable String userID, @RequestParam("file") MultipartFile file ) {
		
		userProfileService.uploadUserProfileImage(userID, file);
		
	}

}
