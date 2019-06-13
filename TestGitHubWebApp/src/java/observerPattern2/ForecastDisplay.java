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
public class ForecastDisplay implements DisplayElement {

    private final Observable weatherData;
    //private float temperature;
    //private float humidity;
    private float pressure;

    public ForecastDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(new MyObserver());
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        if (o instanceof WeatherData) {
//            WeatherData wd = (WeatherData) o;
//            //this.temperature = wd.getTemperature();
//            //this.humidity = wd.getHumidity();
//            this.pressure = wd.getPressure();
//            display();
//        }
//    }
    @Override
    public void display() {
//        System.out.println("Current conditions: " + temperature + " deg.C and "
//            + humidity + "% humidity");
    }

//    public float getTemperature() {
//        return temperature;
//    }
//    public float getHumidity() {
//        return humidity;
//    }
    public float getPressure() {
        return pressure;
    }

    class MyObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof WeatherData) {
                WeatherData wd = (WeatherData) o;
                //this.temperature = wd.getTemperature();
                //this.humidity = wd.getHumidity();

                pressure = wd.getPressure();
                display();
            }
        }

    }
}
