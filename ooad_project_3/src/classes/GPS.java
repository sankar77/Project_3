package classes;

import patterns.Decorator;
//Addon option GPS
public class GPS extends Decorator{
    public static int price = 25;
    public GPS(int num_days,Car car,String name){
    	//Calling Decorator class constructor
    	super(num_days,car,name,price);
    }
}
