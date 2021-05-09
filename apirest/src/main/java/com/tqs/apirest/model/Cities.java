package com.tqs.apirest.model;

import javax.persistence.*;

@Entity(name="cities")
@Table(name="city")
public class Cities {

    // Cidade
    @Id
    @GeneratedValue
    private Long id;

    private Long idx;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String timestamp;

    @Column(nullable=false)
    private Double airQuality;

    // Temperatura
    @Column(nullable=true)
    private Double temperature;             //Temperature

    @Column(nullable=true)
    private Double humidity;                //Humidity

    @Column(nullable=true)
    private Double wind;                    //Wind

    @Column(nullable=true)
    private Double pressure;                //Pressure



    // Gases
    @Column(nullable=true)
    private Double nitrogenDioxide;         //Dióxido de nitrogénio

    @Column(nullable=true)
    private Double sulfurDioxide;           //Dióxido de enxofre

    @Column(nullable=true)
    private Double ozone;                   //Ozono

    @Column(nullable=true)
    private Double pm25;                    //PM 2.5

    @Column(nullable=true)
    private Double pm10;                    //PM 10


    public Cities(Long idx, String name, String timestamp, Double airQuality,
                  Double nitrogenDioxide, Double sulfurDioxide, Double ozone, Double pm25, Double pm10, Double temperature, Double humidity, Double wind, Double pressure) {
        this.idx = idx;
        this.name = name;
        this.timestamp = timestamp;
        this.airQuality = airQuality;
        this.nitrogenDioxide = nitrogenDioxide;
        this.sulfurDioxide = sulfurDioxide;
        this.ozone = ozone;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.pressure = pressure;
    }

    public Cities() {}

    public Long getId() {
        return id;
    }

    public Long getIdx() {
        return idx;
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

    public Double getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public Double getSulfurDioxide() {
        return sulfurDioxide;
    }

    public Double getOzone() {
        return ozone;
    }

    public Double getPm25() {
        return pm25;
    }

    public Double getPm10() {
        return pm10;
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


    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", idx=" + idx +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", airQuality=" + airQuality +
                ", nitrogenDioxide=" + nitrogenDioxide +
                ", so2=" + sulfurDioxide +
                ", ozone=" + ozone +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind=" + wind +
                ", p=" + pressure +
                '}';
    }
}

