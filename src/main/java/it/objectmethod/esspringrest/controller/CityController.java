package it.objectmethod.esspringrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.esspringrest.dao.ICityDao;
import it.objectmethod.esspringrest.dao.impl.CityDaoImpl;
import it.objectmethod.esspringrest.model.CityModel;

@RestController
public class CityController {

	@GetMapping("/city")
	public CityModel getCity(@RequestParam("name") String cityName) {

		ICityDao c = new CityDaoImpl();
		CityModel city = c.getCityByName(cityName);

		return city;
	}

	@PostMapping("/city/post")
	public CityModel postCity(

			@RequestParam("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("country-code") String countryCode, 
			@RequestParam("district") String district,
			@RequestParam("population") Long population) 
	{

		ICityDao c = new CityDaoImpl();
		CityModel city = c.postCity(id, name, countryCode, district, population);
		
		return city;
	}
}
