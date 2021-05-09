package com.tqs.apirest.model;

import javax.persistence.*;

@Entity(name="cities")
@Table(name="city")
public class Cities {

    //Station | City | Region
    //Id Generated
    @Id
    @GeneratedValue
    private Long id;

    //Id that identifies a certain station | city | region
    private Long idx;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String timestamp;

    @Column(nullable=false)
    private Double airQuality;



    @Column(nullable=true)
    private Double temperature;             //Temperature

    @Column(nullable=true)
    private Double humidity;                //Humidity

    @Column(nullable=true)
    private Double wind;                    //Wind

    @Column(nullable=true)
    private Double pressure;                //Pressure



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
        return "City {" +
                "id =" + id +
                ", idx =" + idx +
                ", Name ='" + name + '\'' +
                ", Timestamp='" + timestamp + '\'' +
                ", Air Quality=" + airQuality +
                ", Nitrogen Dioxide (NO2)=" + nitrogenDioxide +
                ", Sulfur Dioxide (SO2) =" + sulfurDioxide +
                ", Ozone =" + ozone +
                ", PM25=" + pm25 +
                ", PM10=" + pm10 +
                ", Temperature=" + temperature +
                ", Humidity=" + humidity +
                ", Wind=" + wind +
                ", Pressure=" + pressure +
                '}';
    }
}

