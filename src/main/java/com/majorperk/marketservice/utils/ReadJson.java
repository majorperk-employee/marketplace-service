package com.majorperk.marketservice.utils;

import java.io.File;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReadJson {

	public String readFileAsString(String filepath) {

		File file = new File(filepath);

		ObjectMapper mapper = new ObjectMapper();

		try {

			JsonNode node = mapper.readValue(file, JsonNode.class);

			return node.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}