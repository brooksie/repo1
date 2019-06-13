/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import observerPattern.CurrentConditionsDisplay;
import observerPattern.ForecastDisplay;
import observerPattern.HeatIndexDisplay;
import observerPattern.WeatherData;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class ObserverBean implements Serializable {

    private WeatherData weatherData;
    private CurrentConditionsDisplay currentConditionsDisplay;
    private ForecastDisplay forecastDisplay;
    private HeatIndexDisplay heatIndexDisplay;
    
    private Float temperature;
    private Float humidity;
    private Float pressure;

    private observerPattern2.WeatherData weatherData2;
    private observerPattern2.CurrentConditionsDisplay currentConditionsDisplay2;
    private observerPattern2.ForecastDisplay forecastDisplay2;
    private observerPattern2.HeatIndexDisplay heatIndexDisplay2;

    
    /**
     * Creates a new instance of DesignPatternsBean2
     */
    public ObserverBean() {
    }
    
    @PostConstruct
    public void init() {
        weatherData = new WeatherData();
        
        currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        this.temperature = Float.valueOf(0);
        this.humidity = Float.valueOf(0);
        this.pressure = Float.valueOf(0);
        
        forecastDisplay = new ForecastDisplay(weatherData);
        heatIndexDisplay = new HeatIndexDisplay(weatherData);
        
        weatherData2 = new observerPattern2.WeatherData();
        currentConditionsDisplay2 = new observerPattern2.CurrentConditionsDisplay(weatherData2);
        forecastDisplay2 = new observerPattern2.ForecastDisplay(weatherData2);
        heatIndexDisplay2 = new observerPattern2.HeatIndexDisplay(weatherData2);
        
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
        weatherData.setTemperature(this.temperature);
        weatherData2.setTemperature(this.temperature);
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
        weatherData.setHumidity(this.humidity);
        weatherData2.setHumidity(this.humidity);
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
        weatherData.setPressure(this.pressure);
        weatherData2.setPressure(this.pressure);
    }
    
    public String updateObservation() {
        return null;    // do nothing
    }
    
    
    public Float getCCTemperature() {
        return currentConditionsDisplay.getTemperature();
    }
    
    public Float getCCHumidity() {
        return currentConditionsDisplay.getHumidity();
    }
    
    public Float getFPressure() {
        return forecastDisplay.getPressure();
    }
    
    public Float getHIndex() {
        return heatIndexDisplay.getHeatIndex();
    }
    
    
    // observeable / observer versions
    public Float getCCTemperature2() {
        return currentConditionsDisplay2.getTemperature();
    }
    
    public Float getCCHumidity2() {
        return currentConditionsDisplay2.getHumidity();
    }
    
    public Float getFPressure2() {
        return forecastDisplay2.getPressure();
    }
    
    public Float getHIndex2() {
        return heatIndexDisplay2.getHeatIndex();
    }
}
