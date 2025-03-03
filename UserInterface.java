
import java.util.Scanner;
import javax.ws.rs.core.Response;

public class UserInterface {
   /**
    * The main entry point of the application
    * 
     * 
     * @param args Command-line arguments(not used in this application)
    */
    
    public static void main(String[] args){
       //Create  a new a scanner object to read input from the user
       Scanner scanner=new Scanner(System.in);
       
       //Create  a new WeatherService object to retrieve weather data.
       WeatherService weatherService=new WeatherService();
       
       //Display  a welcome message to the yser
       System.out.println("welcome to the weather services");
       
       //Enter the loop where we repeatedly prompt the ussr for input they choose to exit
       while(true){
           //Prompt the user to enter the city name to get the whether data, or 'exit' to quite
           System.out.println("Enter the city name to get the waether data, or 'exit' to quit:");
           String city=scanner.nextLine();
           
           //Check if the user wants to exit the application
           if(city.equalsIgnoreCase("exit")){
           //Break out of the loop and exit the application
           
           break;
          }
           //Retrieve the weather data for the specified city
           Response response=weatherService.getWeather(city);
           
           //Check if  chec if the weather was retrieved successfully
           if(response !=null){
               //Display the weather data to the user
               System.out.println(response);
           }else{
               //Display an error message to the user if the weather data could not be retrieved
               System.out.println("Error:unable to retrieve waether data for" + city);
           }
       }
       //Close the scanner object to r=prevent resourse leaks
       scanner.close();
       
       //Display a goodbye message to the user
       System.out.println("Goodbye!");
    }
}
