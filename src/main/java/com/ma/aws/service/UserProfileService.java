package com.ma.aws.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ma.aws.bucket.BucketName;
import com.ma.aws.filestore.FileStore;
import com.ma.aws.profile.UserProfile;

@Service
public class UserProfileService {
	@Autowired
	private FileStore fileStore;
	
	public List<UserProfile> getUserProfiles(){
		List<UserProfile> userProfiles = new ArrayList<>();
		
		userProfiles.add(new UserProfile(UUID.fromString("2ee97318-1fc6-487d-ac70-babcc6c8f711"), "Aplicacao", null));
		
		
		return userProfiles;
	}

	public void uploadUserProfileImage(String userID, MultipartFile file) {
		
		//tem conteudo
		if ( file.isEmpty() ) {
			throw new IllegalArgumentException("Não é uma imagem");
		}
		
		//é uma imagem
		if ( !Arrays.asList( ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_GIF.getMimeType(), ContentType.IMAGE_PNG.getMimeType() ).contains(file.getContentType()) ) {
			throw new IllegalStateException("O arquivo nao é uma imagem válida");
		}
		
		//usuario
		UserProfile usuario = getUserProfiles().get(0);
		
		//metadata
		Map<String, String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		
		//s3
		String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),usuario.getUuid() );
		String filename = String.format("%s-%s", file.getName(), UUID.randomUUID());
		 
		try {
			fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
