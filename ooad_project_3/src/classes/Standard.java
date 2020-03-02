package classes;

import java.util.ArrayList;
import java.util.List;
//Derived class extending Car
public class Standard extends Car{
    public static int price = 7;

    public static int count = 6;
    //static member ids for handing license plate numbers.
    public static List<String> ids = new ArrayList<String>() {{
    	add("SD0");
    	add("SD1");
    	add("SD2");
    	add("SD3");
    	add("SD4");
    	add("SD5");
    }
    };
    public static void removeLicensePlateFromList(String id) {
    	ids.remove(id);
    }
    private Standard(String name,int num_days,String id){
        this.name = name;
        this.num_days = num_days;
        
    }
    public static Standard createInstance(String name,int num_days,String id){
        if(count>=1){
            count = count-1;
            return new Standard(name,num_days,id);
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
    	System.out.println("Standard");
    	
    	if(count<6) {
    		for(String i:idss) {
    			//System.out.println("In-For-LOOP");
    			if(i.substring(0, 2).equals("SD")) {
    				if(!ids.contains(i))
    					ids.add(i);
    		}
    		}
            count = count+1;
    	}
    }
}