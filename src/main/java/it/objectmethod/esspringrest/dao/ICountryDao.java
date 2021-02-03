package it.objectmethod.esspringrest.dao;

import it.objectmethod.esspringrest.model.CountryModel;

public interface ICountryDao {
	public CountryModel getCountry(String name, String continent);
}
