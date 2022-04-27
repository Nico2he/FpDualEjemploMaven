package edu.fpdual.jdbc.ejemplojdbc.controller;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryManager;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CountryManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class CountryController {

    private CountryManager countryManager;

    public CountryController (final CountryManager countryManager){
        this.countryManager = countryManager;
    }

    public Set<Country> findAllCountries() throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        Set<Country> countries = countryManager.findAllCountries(connection);

        for(Country country : countries){
            country.setName(country.getName().toUpperCase());
        }

        return countries;
    }

    public Set<Country> findCountriesByCountryCode(String countryCode)
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        return countryManager.findCountriesByCountryCode(connection, countryCode);
    }

    public void modifyCountry()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryManager.modifyCountry(connection);
    }

    public void insertCountry()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryManager.insertCountry(connection);
    }

    public void deleteCountry()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryManager.deleteCountry(connection);
    }

}