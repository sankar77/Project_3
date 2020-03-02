package classes;

import java.util.ArrayList;
import java.util.List;
//Derived class SUV extending Car
public class SUV extends Car{
    public static int price = 9;

    public static int count = 5;
  //static member for storing Car ids for licenseplates
    public static List<String> ids = new ArrayList<String>() {{
    	add("SU0");
    	add("SU1");
    	add("SU2");
    	add("SU3");
    	add("SU4");
    }
    };
    public static void removeLicensePlateFromList(String id) {
    	ids.remove(id);
    }

    private SUV(String name,int num_days,String id){
        this.name = name;
        this.num_days = num_days;
        
    }
    public static SUV createInstance(String name,int num_days,String id){
        if(count>=1){
            count = count-1;
            return new SUV(name,num_days,id);
        }
        else{
            return null;
        }

    }
    public int quotePrice(){
        return price*num_days;
    }
    public int getCount(){
        return count;
    }
    //Handling return of Cars
    public void onReturn(List<String> idss){
    	System.out.println("SUV");
    	if(count<5) {
    		for(String i:idss) {
    			//System.out.println("In-For-LOOP");
    			if(i.substring(0, 2).equals("SU")) {
    				if(!ids.contains(i))
    					ids.add(i);
    		}
    		}
            count = count+1;
    }
    }
}