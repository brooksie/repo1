/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern2;

import java.util.Observable;

/**
 *
 * @author Steve
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
    }
    
    public void measurementsChanged() {
        setChanged();
        this.notifyObservers(); //use pull method
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        measurementsChanged();
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        measurementsChanged();
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        measurementsChanged();
    }
    
    
    
}
