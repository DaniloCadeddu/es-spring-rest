package it.objectmethod.esspringrest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.esspringrest.dao.ICityDao;
import it.objectmethod.esspringrest.model.CityModel;

public class CityDaoImpl extends DbConnection implements ICityDao {

	public CityModel getCityByName(String nameCity) {

		CityModel city = null;

		Connection conn = null;
		DbConnection cn = new DbConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = cn.getConnection();
			String sql = "SELECT * FROM city WHERE Name = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nameCity);
			rs = stmt.executeQuery();

			while (rs.next()) {
				city = new CityModel();
				city.setId(rs.getLong("ID"));
				city.setCountry(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getLong("Population"));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

	public CityModel postCity(Long id, String name, String countryCode, String district, Long population) {

		Connection conn = null;
		DbConnection cn = new DbConnection();
		PreparedStatement stmt = null;

		try {

			conn = cn.getConnection();
			String sql = "INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.setString(2, name);
			stmt.setString(3, countryCode);
			stmt.setString(4, district);
			stmt.setLong(5, population);

			stmt.executeUpdate();

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		CityModel city = new CityModel();
		city.setId(id);
		city.setName(name);
		city.setCountry(countryCode);
		city.setDistrict(district);
		city.setPopulation(population);

		return city;
	}

}
