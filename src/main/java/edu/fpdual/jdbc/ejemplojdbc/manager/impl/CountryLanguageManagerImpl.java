package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.CountryLanguage;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryLanguageManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CountryLanguageManagerImpl implements CountryLanguageManager {

    @Override
    public Set<CountryLanguage> findAllCountryLanguages(Connection connection){

        try(Statement stm = connection.createStatement()) {

            ResultSet result = stm.executeQuery("SELECT * FROM countrylanguage");

            Set<CountryLanguage> countryLanguageSet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                CountryLanguage countryLanguage = new CountryLanguage(result);
                countryLanguageSet.add(countryLanguage);
            }

            return countryLanguageSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<CountryLanguage> findCountryLanguagesByCountryCode(Connection connection, String countryCode) {
        try(PreparedStatement stm = connection.prepareStatement("SELECT * FROM countrylanguage WHERE CountryCode like ?")) {

            stm.setString(1, countryCode);

            ResultSet result = stm.executeQuery();

            Set<CountryLanguage> countryLanguageSet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                CountryLanguage countryLanguage = new CountryLanguage(result);
                countryLanguageSet.add(countryLanguage);
            }

            return countryLanguageSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyCountryLanguage(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("UPDATE countrylanguage SET Percentage = 9 WHERE CountryCode = 'ABW' AND Language = 'Dutch'");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void insertCountryLanguage(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("INSERT INTO countrylanguage values('ZNN', 'Spanish', true, 4)");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void deleteCountryLanguage(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("DELETE FROM countrylanguage WHERE CountryCode = 'ZNN'");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
