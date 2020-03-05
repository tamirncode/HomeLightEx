package com.tamirnoach.springbootapp.service;

import com.tamirnoach.springbootapp.dao.LightDao;
import com.tamirnoach.springbootapp.model.Light;
import io.logz.logback.LogzioLogbackAppender;
import io.logz.sender.LogzioSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

public class LightService implements LightDao {

    private RestTemplate restTemplate;

    private LogzioSender logzioSender;

    Logger logger =  LoggerFactory.getLogger(LogzioLogbackAppender.class);

    public LightService() throws Exception{
        restTemplate = new RestTemplate();
        logzioSender = LogzioSender.builder().build();
    }

    @Override
    public void getAllLights() {
        String url = "http://demo.openhab.org:8080/rest/items";
        ResponseEntity<Light[]> response = restTemplate.getForEntity(url, Light[].class);
        Light[] lights = response.getBody();

        Stream.of(lights)
                .filter(light -> light.getName().startsWith("light_"))
                .filter(light -> light.getCategory().equalsIgnoreCase("light"))
                .forEach(light -> {
                    logger.info(light.toString());
                });

    }
}
