package com.ma.aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {

	@Bean
	public AmazonS3 s3 () {
		AWSCredentials awsCredentials = new BasicAWSCredentials("zxczxczxczxczxczxc", "zxczxczxczxc/zxcxzczxczxc/zxczxczxczx/zxczxczxct");
		return AmazonS3ClientBuilder
				.standard()
				.withRegion("sa-east-1")
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}
}
