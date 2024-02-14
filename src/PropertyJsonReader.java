import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PropertyJsonReader {
	 
     public PropertyJsonReader(){
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("C:\\Users\\Public\\Documents\\eclipse-workspace\\Assignment2\\src\\property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Lands = (JSONArray) jsonfile.get("1");
             for(Object i:Lands)
             {
				 //You can reach items by using statements below:
				 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
				 String name = (String)((JSONObject)i).get("name");
				 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
				 //And you can add these items to any data structure (e.g. array, linkedlist etc.
				 Land.Land_dict.put(id, new Land(id, name, cost));
             }
             
             for (Property property : Land.Land_dict.values()) 
             {
            	 Property.Property_dict.put(property.getId(), property); 
             }
             
             JSONArray RailRoads = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoads)
             {
				 //You can reach items by using statements below:
            	int id = Integer.parseInt((String)((JSONObject)i).get("id"));
            	String name = (String)((JSONObject)i).get("name");
            	int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
				//And you can add these items to any data structure (e.g. array, linkedlist etc.
            	Railroad.Railroads_dict.put(id, new Railroad(id, name, cost));
             }
             
             for (Property property : Railroad.Railroads_dict.values()) 
             {
            	 Property.Property_dict.put(property.getId(), property); 
             }
			 
             JSONArray Companies = (JSONArray) jsonfile.get("3");
             for(Object i:Companies)
             {
				 //You can reach items by using statements below:
            	 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
            	 String name = (String)((JSONObject)i).get("name");
            	 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
            	 Company.Company_dict.put(id, new Company(id, name, cost));
             }
             
             for (Property property :Company.Company_dict.values()) 
             {
            	 Property.Property_dict.put(property.getId(), property); 
             }
             
             for (Square square : Property.Property_dict.values()) 
             {
            	 Square.Square_dict.put(square.getId(), square); 
             }
             
         } catch (IOException e){
             e.printStackTrace();
         } catch (ParseException e){
             e.printStackTrace();
         }
     }
     //You can add function(s) if you want
}