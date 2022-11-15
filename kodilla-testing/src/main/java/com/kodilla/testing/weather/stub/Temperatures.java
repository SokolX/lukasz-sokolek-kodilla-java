package com.kodilla.testing.weather.stub;

import java.util.Map;

public interface Temperatures {

    Map<City, Double> getTemperatures();
    double calculateAverageTemperature();
    double calculateMedianTemperature();

}
