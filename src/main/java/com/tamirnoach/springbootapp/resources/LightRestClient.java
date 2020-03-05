package com.tamirnoach.springbootapp.resources;

import com.tamirnoach.springbootapp.service.LightService;

public class LightRestClient {

    private LightService lightService;


    public LightRestClient() {
        try {
            lightService = new LightService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllLight(){
        lightService.getAllLights();
    }
}
