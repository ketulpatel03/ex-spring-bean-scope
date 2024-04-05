package com.java.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Question: How to inject a prototype bean into a singleton bean
    // Answer: 3 possible ways but always prefer to use: @Lookup annotation

    // by doing so, WeatherService is a prototype bean but as UserService is a singleton bean,
    // injecting WeatherService bean in UserService, it makes WeatherService as a singleton
    // @Autowired
    // private WeatherService weatherService;

    // 1st way to inject a prototype bean into a singleton bean without changing the scope of a prototype bean
    // using ApplicationContext
    // this way it violates the principle of Inversion of Control
    // @Autowired
    // private ApplicationContext context;

    // 2nd way to inject a prototype bean into a singleton bean without changing the scope of a prototype bean
    // using ObjectFactory
    // this is also not a preferable way
    // @Autowired
    // private ObjectFactory<WeatherService> objectFactory;

    // 3rd way to inject a prototype bean into a singleton bean without changing the scope of a prototype bean
    // using @Lookup annotation
    @Lookup
    public WeatherService getWeatherService() {
        return null;
    }

    public String getWeatherDetails() {
        // return weatherService.getTodaysTemp();
        // return context.getBean(WeatherService.class).getTodaysTemp();
        // return objectFactory.getObject().getTodaysTemp();
        return getWeatherService().getTodaysTemp();
    }


}
