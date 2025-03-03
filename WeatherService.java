
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

//Define the weatherService class, which will handle incoming request for weather 
@Path("/weather")
public class WeatherService {
   //Define the method for getting the weather data, which will handle GET request to "/waether/{city}" endpoint
    
    @GET
    @Path("/{city}")
    @Produces("text/plain")
    public Response getWeather(@PathParam("city") String city){
      
        //Set up the openWeatherMap API URL,which willl be used t retrieve the weather
        String apiKey="e12d5c3786bb06efb55d9882d554c50";
        String url="http://api.openweathermap.org/data/2.5/weather?q" +city +"apid=" + apiKey;
        try{
            //Create a URL object,which will be used to connect to the OpenWeatherMap API
            java.net.URL obj=new java.net.URL(url);
            
            //Open a connection to the URL,which willl be used tos end a GET request to the OpenWeatherMap API
            java.net.HttpURLConnection con=(java.net.HttpURLConnection) obj.openConnection();
            
            //Set the request methos to GET, which will be used to retriev the weather data from the OpenWeatherMap API
            con.getRequestMethod();
            
            //Get the response code from the openWeatherMap APIwhich will indicate wheather the request was successful
            int responseCode=con.getResponseCode();
            
            //Check if the response code 200(OK),which indicate that the request was successful
            if(responseCode==200){
                //Create a BufferedReader, which will be used to read the response from the OpenWeatherMap API
                BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
                
                //Read the response into  stringf,whic will be used to store the weather data
                String inputLine;
                StringBuilder  response=new StringBuilder();
                
                while ((inputLine=in.readLine()) !=null){
                    response.append(inputLine);
                }
                in.close();
                
                //Extract the weather data from the response
                String weatherData=response.toString();
                String weather=weatherData.split("main\":\"")[1].split("\",")[0];
                double temperature=Double.parseDouble(weatherData.split("temp\":")[1].split(",")[0]);
                
                //Create a weatherResponse object to hold the waether data
                WeatherResponse weatherResponse= new WeatherResponse (city,weather,temperature);
                
                //Return the WeatherResponse object as a plain text response
                return Response.ok(weatherResponse.toString()).build();
            }else{
                //If the respons ecode is not 2000(OK), return an error response withe response code
                return Response.status(responseCode).entity("Error:"+responseCode).build();
            }
        }catch(Exception e){
            //If there is an error,return an error message
            return Response.serverError().entity("Error:" + e.getMessage()).build();
        }
    }
}
