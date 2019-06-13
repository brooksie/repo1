/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern2;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Steve
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

    private final Observable weatherData;
    //private float pressure;
    private float heatIndex;

    private static final double C1 = 16.923;
    private static final double C2 = 1.85212E-1;
    private static final double C3 = 5.37941;
    private static final double C4 = -1.00254E-1;
    private static final double C5 = 9.41695E-3;
    private static final double C6 = 7.28898E-3;
    private static final double C7 = 3.45372E-4;
    private static final double C8 = -8.14971E-4;
    private static final double C9 = 1.02102E-5;
    private static final double C10 = -3.8646E-5;
    private static final double C11 = 2.91583E-5;
    private static final double C12 = 1.42721E-6;
    private static final double C13 = 1.97483E-7;
    private static final double C14 = -2.18429E-8;
    private static final double C15 = 8.43296E-10;
    private static final double C16 = -4.81975E-11;

    public HeatIndexDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        float temperature;
        float humidity;

        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            temperature = wd.getTemperature();
            humidity = wd.getHumidity();
            //this.pressure = wd.getPressure();
            calculateHeatIndex(temperature, humidity);
            display();
        }
    }

    protected void calculateHeatIndex(double temp, double humidity) {
        double hI;
        double tempF;
        double humid;
        if (temp == 0 || humidity == 0) {
            this.heatIndex = 0;
        } else {
            tempF = temp * 1.8 + 32;    // convert deg.C to deg.F
            humid = humidity;
            hI = C1
                 + C2 * tempF
                 + C3 * humid
                 + C4 * tempF * humid
                 + C5 * tempF * tempF
                 + C6 * humid * humid
                 + C7 * tempF * tempF * humid
                 + C8 * tempF * humid * humid
                 + C9 * tempF * tempF * humid * humid
                 + C10 * tempF * tempF * tempF
                 + C11 * humid * humid * humid
                 + C12 * tempF * tempF * tempF * humid
                 + C13 * tempF * humid * humid * humid
                 + C14 * tempF * tempF * tempF * humid * humid
                 + C15 * tempF * tempF * humid * humid * humid
                 + C16 * tempF * tempF * tempF * humid * humid * humid;
            // now convert back to C
            this.heatIndex = (float) ((hI - 32) / 1.8);
        }
        display();
    }

    @Override
    public void display() {
//        System.out.println("Current conditions: " + temperature + " deg.C and "
//            + humidity + "% humidity");
    }

    public float getHeatIndex() {
        return this.heatIndex;
    }

}
