package classes;

import patterns.Decorator;
//Addon option ChildSeat
public class ChildSeat extends Decorator{
    public static int price = 20;
    public ChildSeat(int num_days,Car car,String name){
        //Calling Decorator class constructor
    	super(num_days,car,name,price);
    }

}