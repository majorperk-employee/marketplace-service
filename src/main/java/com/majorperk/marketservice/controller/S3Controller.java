package com.majorperk.marketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("s3")
class S3Controller {

    @Autowired
    private AmazonS3 s3client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @ResponseBody
    @GetMapping("/getBuckets")
    public List<Bucket> getBuckets() {

        List<Bucket> buckets = s3client.listBuckets();
        for(Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
        return buckets;
    }

    @ResponseBody
    @GetMapping("/file")
    public List<Object> getFile(@RequestParam(value = "filename", required = true) String filename) {
        S3Object s3object = s3client.getObject(bucket,"default_data/" + filename);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            List<Object> something = jsonMapper.readValue(inputStream, new TypeReference<List<Object>>(){});
            return something;
        } catch (Exception e) {
            inputStream.abort();
            System.out.println("Error getting file "+ filename + "::: " + e);
            return null;
        }
    }
}