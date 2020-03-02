package com.recipe.s3;

import java.io.InputStream;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;

public class S3Config {
	private static BasicAWSCredentials credentials = new BasicAWSCredentials(
			  "AKIAR5CSJOBSHDWPXU6F", 
			  "9NgB0QG9gQxxefD52mcOUlm4utI7s99OwRMGrphW"
			);
	private static AmazonS3 s3client = AmazonS3ClientBuilder
			  .standard()
			  .withRegion(Regions.US_EAST_1)
			  .withCredentials(new AWSStaticCredentialsProvider(credentials))
			  .build();
	public static void uploadImage(String bucketName,String key,InputStream input) {
		PutObjectResult result = s3client.putObject(bucketName, key, input, null);
	}
	
	
	
}



