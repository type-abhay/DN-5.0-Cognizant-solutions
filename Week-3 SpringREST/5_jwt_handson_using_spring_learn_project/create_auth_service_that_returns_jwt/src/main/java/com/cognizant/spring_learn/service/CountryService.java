package com.cognizant.spring_learn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    private List<Country> countryList;

    public CountryService() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        countryList = List.of(
                context.getBean("countryIN", Country.class),
                context.getBean("countryUS", Country.class),
                context.getBean("countryDE", Country.class),
                context.getBean("countryJP", Country.class)
        );
    }
    
    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountry(String code) {

        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}