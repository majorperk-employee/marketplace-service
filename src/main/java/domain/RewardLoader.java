package domain;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utils.ReadJson;

@Service
public class RewardLoader {

	public String getRewards() throws IOException {
		ReadJson readJson = new ReadJson();
		File directory = new File("./src/main/java/data/defaultRewards.json");
		return readJson.readFileAsString(directory.getAbsolutePath());
	}

	public List<RewardItem> createRewardsList(String jsonRewardList) throws IOException {
		List<RewardItem> rewardItems = new ArrayList<RewardItem>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			System.out.println("Fetched:" + jsonRewardList.length() + " reward items.");
			rewardItems = jsonMapper.readValue(jsonRewardList, new TypeReference<List<RewardItem>>() {
			});
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			System.out.println("Error caught in RewardLoader.createRewardsList()");
			e.printStackTrace();
		}
		return rewardItems;
	}
}