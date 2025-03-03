/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HC
 */
public class WeatherResponse {
 private String city;
 private String weather;
 private double temperature;
   

   public WeatherResponse(String city,String weather, double temperature){
    this.city=city;
    this.weather=weather;
    this.temperature=temperature;
  }

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
   @Override
   public String toString(){
       return "WeatherResponse{" +
               "city='" +city +'\'' +
               ",weather='"+ 
               weather + '\''+
               ",temperature=" + temperature+
               '}';
   }
}
