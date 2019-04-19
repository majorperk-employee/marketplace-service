package main;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.RewardItem;
import domain.RewardLoader;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/rewards")
public class RewardsController {
	
    RewardLoader rewardLoader = new RewardLoader();
    
    @RequestMapping("/getRewardList")
    public List<RewardItem> getRewardList() throws IOException {
    	
        return rewardLoader.createRewardsList(rewardLoader.getRewards());
    }
}