package classes;
import java.util.ArrayList;
//Economy class extending base class Car
import java.util.List;
public class Economy extends Car{

    public static int count = 5;

    public static int price = 10;
    //static member for storing Car ids for licenseplates
    public static List<String> ids = new ArrayList<String>() {{
    	add("EC0");
    	add("EC1");
    	add("EC2");
    	add("EC3");
    	add("EC4");
    }
    };
    public static void removeLicensePlateFromList(String id) {
    	ids.remove(id);
    }
    

    private Economy(String name,int num_days,String id){
        this.name = name;
        this.num_days = num_days;
        

    }
    // Decrementing the count of vehicles present in the store whenever a customer takes a vehicle.
    public static Economy createInstance(String name,int num_days,String id){
            if(count>=1){
                count = count-1;
                return new Economy(name,num_days,id);
                
            }
            else{
                return null;
            }
    }
    //TO calculate the base price of the car
    public int quotePrice(){
        return price*(this.num_days);
    }

    public int getCount(){
        return count;
    }
    //Handling return of Cars
    public void onReturn(List<String> idss){
    		System.out.println("Economy");
        	
        	
        	if(count<5) {
        		for(String i:idss) {
        			//System.out.println("In-For-LOOP");
        			if(i.substring(0,2).equals("EC")) {
        				if(!ids.contains(i))
        					ids.add(i);
        			}
        		}
        		count = count+1;
        		
        	}
    }
}