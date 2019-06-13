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
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    
    private final Observable weatherData;
    private float temperature;
    private float humidity;
    //private float pressure;

    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            this.temperature = wd.getTemperature();
            this.humidity = wd.getHumidity();
            //this.pressure = wd.getPressure();
            display();
        }
    }
    
    @Override
    public void display() {
//        System.out.println("Current conditions: " + temperature + " deg.C and "
//            + humidity + "% humidity");
    }

    public float getTemperature() {
        return temperature;
    }

//    public void setTemperature(float temperature) {
//        this.temperature = temperature;
//    }

    public float getHumidity() {
        return humidity;
    }

//    public void setHumidity(float humidity) {
//        this.humidity = humidity;
//    }

//    public float getPressure() {
//        return pressure;
//    }

//    public void setPressure(float pressure) {
//        this.pressure = pressure;
//    }

}
