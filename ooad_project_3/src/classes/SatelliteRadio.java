package classes;

import patterns.Decorator;
//Addon option SatelliteRadio 
public class SatelliteRadio extends Decorator{
    public static int price = 22;
    public SatelliteRadio(int num_days,Car car,String name){
    	//Calling Decorator class
    	super(num_days,car,name,price);
    }
}