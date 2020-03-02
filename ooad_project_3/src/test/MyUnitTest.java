package test;

import patterns.Decorator;
import patterns.CustomerFactory;
import patterns.CategoryFactory;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import classes.BusinessCustomer;
import classes.Car;
import classes.CasualCustomer;
import classes.ChildSeat;
import classes.Customer;
import classes.Economy;
import classes.GPS;
import classes.Luxury;
import classes.MiniVan;
import classes.RegularCustomer;
import classes.RentalRecord;
import classes.SatelliteRadio;
import classes.Standard;
import junit.framework.TestCase;
import classes.SUV;

	


	



	//This test class contains
	public class MyUnitTest extends TestCase{

	Car  t;


	public void setUp(){
	//
	  }


	// This test method checks if right instance of car is created for right type (Method name : getCar)
	@Test
	public void test_1(){
	assertTrue(CategoryFactory.getCar("Economy","Economy 1", 2,"EC1") instanceof Economy &&
	CategoryFactory.getCar("Standard","Standard 1", 2,"SD1") instanceof Standard &&
	CategoryFactory.getCar("Luxury","Luxury 1", 2,"LX1") instanceof Luxury &&
	CategoryFactory.getCar("SUV","SUV 1", 2,"SU1") instanceof SUV &&
	CategoryFactory.getCar("MiniVan","MiniVan 1", 2,"MV1") instanceof MiniVan &&
	CategoryFactory.getCar("MiniFan","RandomTool 1", 2,"MF1")==null);
	  }


	//This test method checks if right instance of add on car is created for right type  (Method name : addonoption)
	@Test
	 public void test_2(){
	 
	 assertTrue(CategoryFactory.addonoption("GPS","GPS 1",t, 3)
	   instanceof GPS &&
	   CategoryFactory.addonoption("ChildSeat","ChildSeat 1",t, 3) instanceof
	   ChildSeat &&
	   CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio 1",t, 3)
	   instanceof SatelliteRadio &&
	   CategoryFactory.addonoption("childbed","childbed 1",t, 3)==null);
	 }

	 
	//This test method check whether particular car  is moved out of inventory after purchase  (Method name : createInstance)
	@Test
	public void test_3(){

	int before = Luxury.count;
	//System.out.println(Economy.count);
	Luxury.createInstance("Luxury", 3,"LX1");
	//System.out.println(Economy.count);
	   assertTrue((before-1) == Luxury.count);
	  }

	//This test method checks price of decorated option is valid or not  (Method name : getTotalPrice)
	@Test
	public void test_4(){
	     Car t1 = CategoryFactory.getCar("Economy","Economy 1", 3,"EC1") ;
	     Decorator dc = (Decorator) CategoryFactory.addonoption("ChildSeat","ChildSeat 1",t1, 3) ;
	     RentalRecord rr = new RentalRecord(3);
	     rr.addDecoratorOptions(dc);
	   
	     assertTrue(rr.getTotalPrice() == 10*3+20);
	  }
	//This test method checks for return are properly handles by increasing the inventory count (Method name : returnCar)
	@Test
	public void test_5(){
	Customer c = CustomerFactory.getCustomer("BusinessCustomer","BusinessCustomer 1");
	Car t1 = CategoryFactory.getCar("Economy","Economy 1", 3,"EC1") ;
	   Decorator dc = (Decorator) CategoryFactory.addonoption("ChildSeat","ChildSeat 1",t1, 3) ;
	   RentalRecord rr = new RentalRecord(3);
	    rr.addDecoratorOptions(dc);
	    int countBeforeReturing = Economy.count;
	    List<String> idds = new ArrayList<String>() {{
	    	add("EC0");
	    	
	    }
	    };
	     rr.returnCar(c,idds);
	     int countAfterReturning = Economy.count;
	     assertTrue(countBeforeReturing+1 == countAfterReturning);
	  }

	//This test method checks for price of decorated option only (Method name : quotePrice)
	@Test
	public void test_6(){
	     
	 Car t1 = CategoryFactory.getCar("Economy","Economy 1", 3,"EC1") ;
	     Car dc = CategoryFactory.addonoption("ChildSeat","ChildSeat 1",t1, 3) ;
	     
	     int price = dc.quotePrice();
	     
	     assertTrue(price == 10*3+20);

	  }

	//This test method checks for price of  car only (Method name : quotePrice)
	@Test
	public void test_7(){
	Car t1 = CategoryFactory.getCar("Economy","Economy 1", 3,"EC1") ;
	assertTrue(t1.quotePrice()==Economy.price*3);
	  }

	//This test method checks if right instance of Customer is created for right type (Method name : getCustomer)
	@Test
	public void test_8(){
	assertTrue(CustomerFactory.getCustomer("RegularCustomer","Regular Customer 1") instanceof RegularCustomer &&
	CustomerFactory.getCustomer("BusinessCustomer","Business Customer 1") instanceof BusinessCustomer &&
	CustomerFactory.getCustomer("CasualCustomer","Casual Customer 1") instanceof CasualCustomer &&
	CustomerFactory.getCustomer("Yardhjsjdbwork","Random Cutomser 1")==null);  

	  }

	//This test method check whether particular car  is moved out of inventory after purchase  (Method name : getInstance)
	@Test
	public void test_9(){
	int before = MiniVan.count;
	MiniVan.createInstance("MiniVan", 3,"MV0");
	   assertTrue((before-1) == MiniVan.count);
	  }

	//This test method check for validity of number of cars rented by customer (Method name : getNumberOfToolsRented)
	@Test
	public void test_10(){

	 Car t1 = CategoryFactory.getCar("Economy","Economy 1", 3,"EC1") ;
	     Decorator dc = (Decorator) CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio 1",t1, 3) ;
	     
	     Car t2 = CategoryFactory.getCar("Luxury","Luxury 1", 3,"LX1") ;
	     Decorator dc2 = (Decorator) CategoryFactory.addonoption("GPS","GPS 1",t2, 3) ;
	     
	     Customer c = CustomerFactory.getCustomer("BusinessCustomer","Business Customer 1");
	     
	     RentalRecord rr = new RentalRecord(3);
	     rr.addDecoratorOptions(dc);
	     
	     RentalRecord rr2 = new RentalRecord(3);
	     rr2.addDecoratorOptions(dc2);
	     
	     c.addRentalRecord(rr);
	     c.addRentalRecord(rr2);
	     
	    assertTrue(c.getNumberOfOptionsRented()==2);
	     
	     
	  }

	}



