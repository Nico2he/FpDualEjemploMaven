package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * Interface that contains all query to country entity.
 * @author nicolas.b.gonzalez
 */
public interface CountryManager {

    /**
     * Find all countries of a country
     * @param connection the db connection
     * @return {@code Set} of {@code Country}
     */
    public Set<Country> findAllCountries(Connection connection);

    /**
     * Find all cities of a country by country code
     * @param connection the db connection
     * @param countryCode the country code
     * @return {@code Set} of {@code Country}
     */
    public Set<Country> findCountriesByCountryCode(Connection connection, String countryCode);

    /**
     * Modify country
     * @param con the db connection
     */
    public void modifyCountry(Connection con) throws SQLException;

    /**
     * Insert country
     * @param con the db connection
     */
    public void insertCountry(Connection con) throws SQLException;

    /**
     * Delete country
     * @param con the db connection
     */
    public void deleteCountry(Connection con) throws SQLException;
}
