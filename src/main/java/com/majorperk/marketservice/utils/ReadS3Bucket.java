package com.majorperk.marketservice.utils;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_FOLDER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

@Service
public class ReadS3Bucket {

	@Autowired
	AmazonS3 s3client;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	public S3ObjectInputStream readS3FileAsStream(String filepath) {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + filepath);
		return s3object.getObjectContent();
	}
}