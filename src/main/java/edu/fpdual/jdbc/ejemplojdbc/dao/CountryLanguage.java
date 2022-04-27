package edu.fpdual.jdbc.ejemplojdbc.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CountryLanguage {

    private String countryCode;
    private String language;
    private boolean isOfficial;
    private float percentage;

    public CountryLanguage(ResultSet result) throws SQLException {
        setCountryCode(result.getString("CountryCode"));
        setLanguage(result.getString("Language"));
        setOfficial(result.getBoolean("IsOfficial"));
        setPercentage(result.getFloat("Percentage"));
    }


}