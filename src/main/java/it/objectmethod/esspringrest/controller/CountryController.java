package it.objectmethod.esspringrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.esspringrest.dao.ICountryDao;
import it.objectmethod.esspringrest.dao.impl.CountryDaoImpl;
import it.objectmethod.esspringrest.model.CountryModel;

@RestController
public class CountryController {

	@GetMapping("/country")
	public CountryModel getCity(@RequestParam("name") String countryName, @RequestParam("continent") String continent) {

		ICountryDao c = new CountryDaoImpl();
		CountryModel country = c.getCountry(countryName, continent);

		return country;
	}
}
