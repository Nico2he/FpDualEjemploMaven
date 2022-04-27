package edu.fpdual.jdbc.ejemplojdbc.controller;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.dao.CountryLanguage;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryLanguageManager;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CountryLanguageManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class CountryLanguageController {

    private CountryLanguageManager countryLanguageManager;

    public CountryLanguageController (final CountryLanguageManager countryLanguageManager){
        this.countryLanguageManager = countryLanguageManager;
    }

    public Set<CountryLanguage> findAllCountryLanguages() throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        Set<CountryLanguage> countryLanguages = countryLanguageManager.findAllCountryLanguages(connection);

        for(CountryLanguage countryLanguage : countryLanguages){
            countryLanguage.setLanguage(countryLanguage.getLanguage().toUpperCase());
        }

        return countryLanguages;
    }

    public Set<CountryLanguage> findCountryLanguagesByCountryCode(String countryCode)
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        return countryLanguageManager.findCountryLanguagesByCountryCode(connection, countryCode);
    }

    public void modifyCountryLanguage()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryLanguageManager.modifyCountryLanguage(connection);
    }

    public void insertCountryLanguage()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryLanguageManager.insertCountryLanguage(connection);
    }

    public void deleteCountryLanguage()
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        countryLanguageManager.deleteCountryLanguage(connection);
    }

}
