package com.tqs.apirest.model;

import javax.persistence.*;

@Entity(name="cities")
@Table(name="city")
public class City {

    //Cidade

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String timestamp;

    @Column(nullable = false)
    private Double airQuality;

    //Temperatura

    @Column(nullable = true)
    private Double temperature;

    @Column(nullable = true)
    private Double humidity;

    @Column(nullable = true)
    private Double wind;

    @Column(nullable = true)
    private Double pressure;

    //Gases

    @Column(nullable = true)
    private Double ozone;               //O3

    @Column(nullable = true)
    private Double nitrogenDioxide;     //Dióxido de Azoto (NO2)

    @Column(nullable = true)
    private Double sulfurDioxide;       //Dióxido de Enxofre (SO2)

    @Column(nullable = true)
    private Double pm10;

    @Column(nullable = true)
    private Double pm25;

    public City(Long id, String name, String timestamp, Double airQuality, Double temperature, Double humidity,
                Double wind, Double pressure, Double ozone, Double nitrogenDioxide, Double sulfurDioxide, Double pm10,
                Double pm25) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.airQuality = airQuality;
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.pressure = pressure;
        this.ozone = ozone;
        this.nitrogenDioxide = nitrogenDioxide;
        this.sulfurDioxide = sulfurDioxide;
        this.pm10 = pm10;
        this.pm25 = pm25;
    }

    public City() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Double getAirQuality() {
        return airQuality;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWind() {
        return wind;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getOzone() {
        return ozone;
    }

    public Double getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public Double getSulfurDioxide() {
        return sulfurDioxide;
    }

    public Double getPm10() {
        return pm10;
    }

    public Double getPm25() {
        return pm25;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", airQuality=" + airQuality +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind=" + wind +
                ", pressure=" + pressure +
                ", ozone=" + ozone +
                ", nitrogenDioxide=" + nitrogenDioxide +
                ", sulfurDioxide=" + sulfurDioxide +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                '}';
    }
}
