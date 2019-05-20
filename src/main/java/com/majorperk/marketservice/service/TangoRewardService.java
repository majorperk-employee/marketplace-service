package com.majorperk.marketservice.service;

import java.util.List;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Catalog;
import com.majorperk.marketservice.model.SandPMetrics;
import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.model.tango.TangoContactInfo;
import com.majorperk.marketservice.model.tango.TangoOrder;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.SandPMetricsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.yml")
public class TangoRewardService {

    @Value("${tangocard.baseUrl}")
    private String baseUrl;

    @Value("${tangocard.username}")
    private String username;

    @Value("${tangocard.password}")
    private String password;

    @Value("${tangocard.accountIdentifier}")
    private String accountIdentifier;

    @Value("${tangocard.customerIdentifier}")
    private String customerIdentifier;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
	private SandPMetricsRepository sandpRepository;

    public Object redeemRewardLink(Long userid, int amount) {

        SandPMetrics accountSP;
        Account accountMP;

        try {
            accountSP = sandpRepository.findById(userid).get();
            accountMP = accountRepository.findById(userid).get();
        } catch (Exception e) {
            System.out.println("Unable to find account::: " + userid);
            return null;
        }

        TangoOrder tangoOrder = new TangoOrder(
            accountIdentifier, //accountIdentifier
            customerIdentifier, //customerIdentifier
            amount, //amount
            "U561593", //utid
            true, //sendEmail
            new TangoContactInfo("noreply@majorperk.com"), //sender
            // new TangoContactInfo(accountMP.getEmail(), accountSP.getFirstname(), accountSP.getLastname())
            new TangoContactInfo("sergeiahanka@gmail.com", accountSP.getFirstname(), accountSP.getLastname())
        );

		return tangoOrder;
	}

    public Object redeemRewardLink(TangoOrder order) {
        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
        return restTemplate.postForObject(baseUrl + "/orders", order, Object.class);
    }

    public List<Brand> getCatalog(Boolean verbose) {
        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
        return restTemplate.getForObject(baseUrl + "/catalogs?verbose={verbose}", Catalog.class, verbose).getBrands();
    }
}