package com.tqs.apirest.model;

import javax.persistence.*;

@Entity(name="cities")
@Table(name="city")
public class Cities {

    @Id
    @GeneratedValue
    private Long idgerated;

    // Cidade
    private Long idx;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String timestamp;

    // Valores
    @Column(nullable=false)
    private Double airQuality;


    // Valores gases

    @Column(nullable=true)
    private Double pm25;                    //PM 2.5

    @Column(nullable=true)
    private Double pm10;                    //PM 10

    @Column(nullable=true)
    private Double ozone;                   //Ozono

    @Column(nullable=true)
    private Double nitrogenDioxide;         //Dióxido de nitrogénio

    @Column(nullable=true)
    private Double sulfurDioxide;           //Dióxido de enxofre


    // Valores temperatura
    @Column(nullable=true)
    private Double temperature;             //Temperature

    @Column(nullable=true)
    private Double pressure;                //Pressure

    @Column(nullable=true)
    private Double humidity;                //Humidity

    @Column(nullable=true)
    private Double wind;                    //Wind

    public Cities(Long idx, String name, String timestamp, Double airQuality, Double pm25, Double pm10, Double ozone,
                  Double nitrogenDioxide, Double sulfurDioxide, Double temperature, Double pressure, Double humidity, Double wind) {
        this.idx = idx;
        this.name = name;
        this.timestamp = timestamp;
        this.airQuality = airQuality;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.ozone = ozone;
        this.nitrogenDioxide = nitrogenDioxide;
        this.sulfurDioxide = sulfurDioxide;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    public Cities() {}

    public Long getIdgerated() {
        return idgerated;
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

    public Double getPm25() {
        return pm25;
    }

    public Double getPm10() {
        return pm10;
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

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "idgerated=" + idgerated +
                ", idx=" + idx +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", airQuality=" + airQuality +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", ozone=" + ozone +
                ", nitrogenDioxide=" + nitrogenDioxide +
                ", so2=" + sulfurDioxide +
                ", temperature=" + temperature +
                ", p=" + pressure +
                ", humidity=" + humidity +
                ", wind=" + wind +
                '}';
    }
}

