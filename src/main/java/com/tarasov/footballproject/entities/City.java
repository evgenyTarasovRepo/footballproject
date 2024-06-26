package com.tarasov.footballproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "city_name")
    private String name;

    @Column(name = "country_name")
    private String countryName;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "city", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stadium> stadiums;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "city", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    private List<Team> teams;

    public City() {
    }

    public City(String cityName, String countryName) {
        this.name = cityName;
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String cityName) {
        this.name = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public void addStadium(Stadium stadium) {
        if (stadiums == null) {
            stadiums = new ArrayList<>();
        }
        stadiums.add(stadium);
        stadium.setCity(this);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
