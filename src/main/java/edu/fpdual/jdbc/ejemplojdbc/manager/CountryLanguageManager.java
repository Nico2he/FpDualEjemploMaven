package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.CountryLanguage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * Interface that contains all query to country language entity.
 * @author nicolas.b.gonzalez
 */
public interface CountryLanguageManager {

    /**
     * Find all country languages
     * @param connection the db connection
     * @return {@code Set} of {@code CountryLanguage}
     */
    public Set<CountryLanguage> findAllCountryLanguages(Connection connection);

    /**
     * Find all country languages by country code
     * @param connection the db connection
     * @param countryCode the country code
     * @return {@code Set} of {@code CountryLanguage}
     */
    public Set<CountryLanguage> findCountryLanguagesByCountryCode(Connection connection, String countryCode);

    /**
     * Modify country language
     * @param con the db connection
     */
    public void modifyCountryLanguage(Connection con) throws SQLException;

    /**
     * Insert country language
     * @param con the db connection
     */
    public void insertCountryLanguage(Connection con) throws SQLException;

    /**
     * Delete country language
     * @param con the db connection
     */
    public void deleteCountryLanguage(Connection con) throws SQLException;
}