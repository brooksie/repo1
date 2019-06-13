/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Steve
 */
public class WeatherData implements Subject {

    private final Collection<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        observers = new ArrayList();
    }
    
    @Override
    public boolean registerObserver(Observer observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers(float temp, float humidity, float pressure) {
        observers.forEach((o) -> {
            o.update(temp, humidity, pressure);
        });
    }
    
    public void measurementsChanged() {
        notifyObservers(getTemperature(), getHumidity(), getPressure());
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
