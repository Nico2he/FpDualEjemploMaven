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
public class Country {

    private String code;
    private String name;
    private String continent;
    private String region;
    private float surfaceArea;
    private int indepYear;
    private int population;
    private float lifeExpectancy;
    private float gnp;
    private float gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private int capital;
    private String code2;


    public Country(ResultSet result) throws SQLException {
        setCode(result.getString("Code"));
        setName(result.getString("Name"));
        setContinent(result.getString("Continent"));
        setRegion(result.getString("Region"));
        setSurfaceArea(result.getFloat("SurfaceArea"));
        setIndepYear(result.getInt("IndepYear"));
        setPopulation(result.getInt("Population"));
        setLifeExpectancy(result.getFloat("LifeExpectancy"));
        setGnp(result.getFloat("Gnp"));
        setGnpOld(result.getFloat("GnpOld"));
        setLocalName(result.getString("LocalName"));
        setGovernmentForm(result.getString("GovernmentForm"));
        setHeadOfState(result.getString("HeadOfState"));
        setCapital(result.getInt("Capital"));
        setCode2(result.getString("Code2"));
    }


}
