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
    private Double o3;                      //Ozono

    @Column(nullable=true)
    private Double no2;                     //Dióxido de nitrogénio

    @Column(nullable=true)
    private Double so2;                     //Dióxido de enxofre


    // Valores temperatura
    @Column(nullable=true)
    private Double temperature;             //Temperature

    @Column(nullable=true)
    private Double pressure;                //Pressure

    @Column(nullable=true)
    private Double h;                       //Humidity

    @Column(nullable=true)
    private Double w;                       //Wind

    public Cities(Long idx, String name, String timestamp, Double airQuality, Double pm25, Double pm10, Double o3, Double no2, Double so2, Double temperature, Double pressure, Double h, Double w) {
        this.idx = idx;
        this.name = name;
        this.timestamp = timestamp;
        this.airQuality = airQuality;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.o3 = o3;
        this.no2 = no2;
        this.so2 = so2;
        this.temperature = temperature;
        this.pressure = pressure;
        this.h = h;
        this.w = w;
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

    public Double getO3() {
        return o3;
    }

    public Double getNo2() {
        return no2;
    }

    public Double getSo2() {
        return so2;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getH() {
        return h;
    }

    public Double getW() {
        return w;
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
                ", o3=" + o3 +
                ", no2=" + no2 +
                ", so2=" + so2 +
                ", temperature=" + temperature +
                ", p=" + pressure +
                ", h=" + h +
                ", w=" + w +
                '}';
    }
}

