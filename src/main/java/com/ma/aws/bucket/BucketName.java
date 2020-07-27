package com.ma.aws.bucket;

public enum BucketName {
	
	PROFILE_IMAGE("app-image-upload-1");
	
	private final String bucketName; 
	
	BucketName (String bucketName) {
		this.bucketName = bucketName;
	}
	
	public String getBucketName() {
		return bucketName;
	}

}
