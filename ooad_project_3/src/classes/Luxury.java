package classes;

import java.util.ArrayList;
import java.util.List;
//Luxury class extending base class Car
public class Luxury extends Car{
    public static int price = 10;

    public static int count = 6;
  //static member for storing Car ids for licenseplates
    public static List<String> ids = new ArrayList<String>() {{
    	add("LX0");
    	add("LX1");
    	add("LX2");
    	add("LX3");
    	add("LX4");
    	add("LX5");
    	
    }
    };
    public static void removeLicensePlateFromList(String id) {
    	ids.remove(id);
    }

    private Luxury(String name,int num_days,String id){
        this.name = name;
        this.num_days = num_days;
        
    }
    public static Luxury createInstance(String name,int num_days,String id){
        if(count>=1){
            count = count-1;
            return new Luxury(name,num_days,id);
        }
        else{
            return null;
        }

    }
    public int quotePrice(){
        return price*num_days;
    }
  //Handling return of Cars
    public void onReturn(List<String> idss){
    	System.out.println("Luxury");
    	if(count<6) {
    		for(String i:idss) {
    			//System.out.println("In-For-LOOP");
    			if(i.substring(0, 2).equals("LX")) {
    				if(!ids.contains(i))
    					ids.add(i);
    			}
    		}
            count = count+1;
    	}
    }
}