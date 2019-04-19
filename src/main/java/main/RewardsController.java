package main;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.RewardItem;
import domain.RewardLoader;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	
    RewardLoader rewardLoader = new RewardLoader();
    
    @RequestMapping("/getRewardList")
    public List<RewardItem> getRewardList() throws IOException {
    	
        return rewardLoader.createRewardsList(rewardLoader.getRewards());
    }
}