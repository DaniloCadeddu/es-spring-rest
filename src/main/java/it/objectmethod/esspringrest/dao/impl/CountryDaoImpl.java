package it.objectmethod.esspringrest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.esspringrest.dao.ICountryDao;
import it.objectmethod.esspringrest.model.CountryModel;

public class CountryDaoImpl extends DbConnection implements ICountryDao {

	public CountryModel getCountry(String name, String continent) {

		CountryModel country = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			String sql = "SELECT Code, Name, SurfaceArea, Population FROM country WHERE Name = ? AND Continent = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, continent);
			rs = stmt.executeQuery();

			while (rs.next()) {
				country = new CountryModel();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setSurface(rs.getFloat("SurfaceArea"));
				country.setPopulation(rs.getInt("Population"));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return country;
	}
}
