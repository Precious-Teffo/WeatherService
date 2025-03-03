
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class WeatherDAO {
    private static final String OPENWAETHERMAP_API_URL="http://api.openweathermap.org/data/2.5/weather";
    private static final String OPENWAETHERMAP_API_KEY="e12d5c3786bb06efb55d9882d554c50";
    
    public String getWeatherData(String city) throws MalformedURLException{
        try{
            URL url=new URL(OPENWAETHERMAP_API_URL +"?q"+city +"&appid"+OPENWAETHERMAP_API_KEY);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode=connection.getResponseCode();
            if(responseCode==200){
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
                 StringBuilder response= new StringBuilder();
                 String line;
                 while((line=reader.readLine())!=null){
                     response.append(line);
                 }
                 reader.close();
                 return response.toString();
            }else{
               return null; 
            }
        }catch (Exception e){
            return null;
        }
    }
}
