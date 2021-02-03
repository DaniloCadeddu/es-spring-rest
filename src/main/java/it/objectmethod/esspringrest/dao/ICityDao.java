package it.objectmethod.esspringrest.dao;

import it.objectmethod.esspringrest.model.CityModel;

public interface ICityDao {

	public CityModel getCityByName(String name);

	public CityModel postCity(Long id, String name, String countryCode, String district, Long population);
}
