package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            sum = sum + temperature.getValue();
        }
        return sum/temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        List<Double> resultList = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
                resultList.add(temperature.getValue());
        }
        Collections.sort(resultList);

        int j = resultList.size() / 2;
        if (resultList.size() % 2 == 0) {
            return (resultList.get(j-1) + resultList.get(j)) / 2;
        } else {
            return resultList.get(j);
        }
    }
}
