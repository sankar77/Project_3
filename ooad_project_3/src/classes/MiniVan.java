package classes;

import java.util.ArrayList;
import java.util.List;
//MiniVan class extending base class Car
public class MiniVan extends Car{
    public static int price = 8;

    public static int count = 6;
  //static member for storing Car ids for licenseplates
    public static List<String> ids = new ArrayList<String>() {{
    	add("MV0");
    	add("MV1");
    	add("MV2");
    	add("MV3");
    	add("MV4");
    	add("MV5");
    }
    };
    public static void removeLicensePlateFromList(String id) {
    	ids.remove(id);
    }

    private MiniVan(String name,int num_days,String id){
        this.name = name;
        this.num_days = num_days;
        
    }
    public static MiniVan createInstance(String name,int num_days,String id){
        if(count>=1){
            count = count-1;
            return new MiniVan(name,num_days,id);
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
    	System.out.println("MiniVan");
    	if(count<6) {
    		for(String i:idss) {
    			//System.out.println("In-For-LOOP");
    			if(i.substring(0, 2).equals("MV")) {
    				if(!ids.contains(i))
    					ids.add(i);
    			}
    		}
            count = count+1;
    	}
    }
}