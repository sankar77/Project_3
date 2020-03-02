package patterns;

import classes.Car;
import classes.ChildSeat;
import classes.Economy;
import classes.GPS;
import classes.Luxury;
import classes.MiniVan;
import classes.SUV;
import classes.SatelliteRadio;
import classes.Standard;
//CategoryFactory for initialization of various kinds of Cars.
public class CategoryFactory{
    public static Car getCar(String type, String name,int num_days,String id) {
            if(type.equals("Economy"))
                return Economy.createInstance(name,num_days,id);
            else if(type.equals("Standard"))
                return Standard.createInstance(name,num_days,id);
            else if(type.equals("Luxury"))
                return Luxury.createInstance(name,num_days,id);
            else if(type.equals("SUV"))
                return SUV.createInstance(name,num_days,id);
            else if(type.equals("MiniVan"))
                return MiniVan.createInstance(name,num_days,id);
            else
            return null;

        
    }
    //Addon options.
    public static Car addonoption(String type,String name,Car car,int numDays){
        if(type.equals("ChildSeat"))
            return new ChildSeat(numDays,car,name);
        else if(type.equals("GPS"))
            return new GPS(numDays,car,name);
        else if(type.equals("SatelliteRadio"))
            return new SatelliteRadio(numDays,car,name);
        else
		return null;
    }
    //Static function for purchase of a car based on a LicensePlate
    public static void licensePlatePurchased(String type,String id) {
    	if(type.equals("Economy"))
    		Economy.removeLicensePlateFromList(id);
    	else if(type.equals("Luxury"))
    		Luxury.removeLicensePlateFromList(id);
    	else if(type.equals("SUV"))
    		SUV.removeLicensePlateFromList(id);
    	else if(type.equals("Standard"))
    		Standard.removeLicensePlateFromList(id);
    	else if(type.equals("MiniVan"))
    		MiniVan.removeLicensePlateFromList(id);
    	
    }
}
