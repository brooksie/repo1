/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

/**
 *
 * @author Steve
 */
public class HeatIndexDisplay implements Observer, DisplayElement {
    
    private Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;
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
    

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        double heatIndex;
        double tempF;
        double humid;
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        if ( this.temperature == 0 || this.humidity == 0) {
            this.heatIndex = 0;
        } else {
            tempF = temp * 1.8 + 32;
            humid = humidity;
            heatIndex = C1 
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
            this.heatIndex = (float) ((heatIndex - 32)/1.8);
        }
        display();
    }

    @Override
    public void display() {
//        System.out.println("Current conditions: " + temperature + " deg.C and "
//            + humidity + "% humidity");
    }

//    public float getTemperature() {
//        return this.temperature;
//    }
//
//    public float getHumidity() {
//        return this.humidity;
//    }
//
//    public float getPressure() {
//        return this.pressure;
//    }

    public float getHeatIndex() {
        return this.heatIndex;
    }
    
}
