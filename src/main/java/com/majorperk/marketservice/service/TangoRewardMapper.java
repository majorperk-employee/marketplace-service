package com.majorperk.marketservice.service;

import java.util.List;

import com.majorperk.marketservice.model.Catalog;
import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.model.tango.TangoOrder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.yml")
public class TangoRewardMapper {

    @Value("${tangocard.baseUrl}")
    private String baseUrl;

    @Value("${tangocard.username}")
    private String username;

    @Value("${tangocard.password}")
    private String password;
    
    public Object redeemRewardLink(Long userid) {
		return userid;
	}

    public List<Brand> getRewardLink() {
        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
        return restTemplate.getForObject(baseUrl + "/catalogs?verbose={verbose}", Catalog.class, verbose).getBrands();
    }

    public List<Brand> getCatalog(Boolean verbose) {
        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
        return restTemplate.getForObject(baseUrl + "/catalogs?verbose={verbose}", Catalog.class, verbose).getBrands();
    }

    public Object createOrder(TangoOrder order) {
        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
        return restTemplate.postForObject(baseUrl + "/orders", order, Object.class);
    }
}