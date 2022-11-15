package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {

    @Override
    public Map<City, Double> getTemperatures() {
        Map<City, Double> stubResult = new HashMap<>();
        stubResult.put(City.KRAKOW, 26.2);
        stubResult.put(City.WROCLAW, 24.8);
        stubResult.put(City.RZESZOW, 25.5);
        stubResult.put(City.WARSZAWA, 25.2);
        stubResult.put(City.GDANSK, 26.1);

        return stubResult;
    }

    @Override
    public double calculateAverageTemperature() {
        return 0;
    }

    @Override
    public double calculateMedianTemperature() {
        return 0;
    }
}
