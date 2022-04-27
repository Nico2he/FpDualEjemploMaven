package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CountryManagerImpl implements CountryManager {

    @Override
    public Set<Country> findAllCountries(Connection connection){

        try(Statement stm = connection.createStatement()) {

            ResultSet result = stm.executeQuery("SELECT * FROM country");

            Set<Country> countrySet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                Country country = new Country(result);
                countrySet.add(country);
            }

            return countrySet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<Country> findCountriesByCountryCode(Connection connection, String countryCode) {
        try(PreparedStatement stm = connection.prepareStatement("SELECT * FROM country WHERE CountryCode like ?")) {

            stm.setString(1, countryCode);

            ResultSet result = stm.executeQuery();

            Set<Country> countrySet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                Country country = new Country(result);
                countrySet.add(country);
            }

            return countrySet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyCountry(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("UPDATE country SET Name = 'Aruba' WHERE Code = ABW");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void insertCountry(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("INSERT INTO country values('ZNN', 'Zinonia', 'Europe', 'Southern Europe', 130000, 1900, 11000000, 70, 6000, 6001, 'Zinonia', 'Republic', 'Zinonio Zinzono', 3201, 'ZN')");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void deleteCountry(Connection con) throws SQLException {

        try (Statement stm = con.createStatement()) {

            stm.executeUpdate("DELETE FROM country WHERE Code = ZWE");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}