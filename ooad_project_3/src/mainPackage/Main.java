package mainPackage;
import java.util.Random;

import classes.Car;
import classes.Customer;
import classes.Economy;
import classes.Luxury;
import classes.MiniVan;
import classes.RentalRecord;
import classes.SUV;
import classes.Standard;
import patterns.CategoryFactory;
import patterns.CustomerFactory;
import patterns.Decorator;

import java.util.List;
import java.util.ArrayList;

//Main Class for program execution
public class Main{
    public static void main(String[] args) {
        //Creation of Rental Store to store records
    	RentalStore rs = new RentalStore();
        for(int i = 0;i<12;i++){
        Random rand = new Random();
        int num = rand.nextInt(3)+1;
        //Storing Customers
        if(num==1){
        Customer customer = CustomerFactory.getCustomer("CasualCustomer", "CasualCustomer"+(i));
        rs.addCustomer(customer);
        }
        else if(num==2){
            Customer customer = CustomerFactory.getCustomer("RegularCustomer","RegularCustomer"+(i));
            rs.addCustomer(customer);
        }
        
        else if(num==3){
            Customer customer = CustomerFactory.getCustomer("BusinessCustomer", "BusinessCustomer"+(i));
            rs.addCustomer(customer);
        }
    }
        int total = 0;

       
        //Simulation for 34 days
        for(int i = 0;i<34;i++){
            if(Luxury.count>=0){
                System.out.println("Total number of luxury vehicles remaining in the store " +Luxury.count);
                System.out.println("Luxury vehicles license ids remaining in the store are " +Luxury.ids);
            }
            if(MiniVan.count>=0){
                System.out.println("Total number of MiniVan vehicles remaining in the store " +MiniVan.count);
                System.out.println("MiniVan vehicles license ids remaining in the store are " +MiniVan.ids);
            }
            if(Standard.count>=0){
                System.out.println("Total number of Standard vehicles remaining in the store " +Standard.count);
                System.out.println("Standard vehicles license ids remaining in the store are " + Standard.ids);
            }
            if(SUV.count>=0){
                System.out.println("Total number of SUV vehicles remaining in the store " +SUV.count);
                System.out.println("SUV vehicles license ids remaining in the store are " + SUV.ids);
            }
            if(Economy.count>=0){
                System.out.println("Total number of MiniVan vehicles remaining in the store " +Economy.count);
                System.out.println("MiniVan vehicles license ids remaining in the store are " + Economy.ids);
            }
            //Handling the return of Cars
            List<Customer> customers = rs.returnCustomer();
            for(Customer customer:customers){
                List<RentalRecord> rrlist = customer.getRentalRecord();
                for(int k = 0;k<rrlist.size();k++){
                int buyingDay = rrlist.get(k).dayofBuying;
                int numberOfDaysRented=0;
                if(rrlist.get(k).getDecoratorOptions().size() > 0) 
                	numberOfDaysRented = rrlist.get(k).getDecoratorOptions().get(0).num_days;
                //System.out.println("Rented Days");
                //System.out.println(numberOfDaysRented);
                //System.out.println("I"+i);
                //System.out.println(buyingDay+numberOfDaysRented);
                List<String> iids = rrlist.get(k).getIds();
                if(i==(buyingDay+numberOfDaysRented)){
                	//System.out.println("Hellllo");
                    rrlist.get(k).returnCar(customer,iids);
                    rrlist.get(k).setStatus(false);
                }
                else{
                    //do nothing
                }
            }

        
            }
            System.out.println("-----Day NUmber "+ (i+1)+"-------");
            Random randomGen=new Random();
            int randomNumber=randomGen.nextInt(11)+1;
            int totalPrice=0;
            //int total=0;
            int noOfCars = 0;
            int noOfDays = 0;
            Customer customer=customers.get(randomNumber);
            System.out.println("Customer "+customer.getCustomerName() + " enters the store");
            String typeofCus = customer.getClass().getSimpleName();
      
            switch (typeofCus) {
                case "BusinessCustomer":
                    noOfCars=3;
                    noOfDays=7;
                    
                    break;
                case "CasualCustomer":
                    noOfCars=1;
                    noOfDays=2;

                    break;
                case "RegularCustomer":
                    noOfCars=2;
                    noOfDays=5;

                    break;                  
                default:
                    break;
            }
            // if (customer.getClass().getSimpleName().equals("BusinessCustomer")) {
            //         int noOfCars=3;
            //         int noOfDays=7;
                    RentalRecord rentalRecord=new RentalRecord(i);
                    int cond = 0;
                    int cusKind = 0;
                    if(typeofCus.equals("CasualCustomer")) {
                    	cond = noOfDays;
                    	cusKind = 0;
                    }
                    else {
                    	cond = noOfCars;
                    	if(typeofCus.equals("BusinessCustomer"))
									cusKind = 1;
                    	else
                    		cusKind = 2;
                    }
                    //Using Factory for initialization of Cars and Decorator for addonproperty.
                    for (int j=0;j<cond;j++){
                        int carno=randomGen.nextInt(5)+1;
                        //System.out.println(carno);
                        Car cartype = null;
                        Car addonproperty = null;
                        String type = null;
                        String id = null;
                        //int flag = 1;
                        if (carno==1) {
                        	id = "SD"+j;
                        	if(Standard.ids.contains(id)) {
                            cartype=CategoryFactory.getCar("Standard", "Standard"+(carno+1), noOfDays,id);
                            
                            type="Standard";
                            
                           // cartype=CategoryFactory.getCar("Standard", "Standard"+(carno+1), noOfDays);
                            addonproperty=CategoryFactory.addonoption("GPS","GPS"+(carno+1),cartype,noOfDays);
                            
                            CategoryFactory.licensePlatePurchased(type, id);
                            rentalRecord.addCars(id);
                            //CustomerFactory.insertCarsPurchased(cusKind,id);
                        	
                            
                            
                        }
                        	else {
                        		Random rg= new Random();
                        		if(!Standard.ids.isEmpty()) {
                        		int rn=rg.nextInt(Standard.ids.size());
                        		id = (String)Standard.ids.get(rn);
                        		
                            	if(Standard.ids.contains(id)) {
                                cartype=CategoryFactory.getCar("Standard", "Standard"+(carno+1), noOfDays,id);
                                
                                type="Standard";
                                
                               // cartype=CategoryFactory.getCar("Standard", "Standard"+(carno+1), noOfDays);
                                addonproperty=CategoryFactory.addonoption("GPS","GPS"+(carno+1),cartype,noOfDays);
                                
                                CategoryFactory.licensePlatePurchased(type, id);
                                rentalRecord.addCars(id);
                            	
                        	}
                        		}
                        }
                        }
                        else if (carno==2) {
                        	id = "EC"+j;
                        	if(Economy.ids.contains(id)) {
                            cartype=CategoryFactory.getCar("Economy", "Economy"+(carno+1), noOfDays,id);
                            type="Economy";
                            // cartype=CategoryFactory.getCar("Economy", "Economy"+(carno+1), noOfDays);
                            addonproperty=CategoryFactory.addonoption("ChildSeat","childSeat"+(carno+1),cartype,noOfDays);
                            
                            CategoryFactory.licensePlatePurchased(type,id);
                            rentalRecord.addCars(id);
                        	}
                            else {
                            	Random rg= new Random();
                            	if(!Economy.ids.isEmpty()) {
                            	int rn=rg.nextInt(Economy.ids.size());
                        		id = Economy.ids.get(rn);
                            	if(Economy.ids.contains(id)) {
                                cartype=CategoryFactory.getCar("Economy", "Economy"+(carno+1), noOfDays,id);
                                type="Economy";
                                // cartype=CategoryFactory.getCar("Economy", "Economy"+(carno+1), noOfDays);
                                addonproperty=CategoryFactory.addonoption("ChildSeat","childSeat"+(carno+1),cartype,noOfDays);
                                
                                CategoryFactory.licensePlatePurchased(type,id);
                                rentalRecord.addCars(id);
                            	}
                            }
                            
                            
                        }
                        }
                        else if (carno==3) {
                        	id = "LX"+j;
                        	if(Luxury.ids.contains(id)) {
                            cartype=CategoryFactory.getCar("Luxury", "Luxury"+(carno+1), noOfDays,id);
                            type="Luxury";
                            // cartype=CategoryFactory.getCar("Luxury", "Luxury"+(carno+1), noOfDays);
                            addonproperty=CategoryFactory.addonoption("GPS","GPS"+(carno+1),cartype,noOfDays);
                            
                            CategoryFactory.licensePlatePurchased(type, id);
                            rentalRecord.addCars(id);
                        	}
                            else {
                            	Random rg= new Random();
                            	if(!Luxury.ids.isEmpty()) {
                        		int rn=rg.nextInt(Luxury.ids.size());
                        		id = Luxury.ids.get(rn);
                            	if(Luxury.ids.contains(id)) {
                                cartype=CategoryFactory.getCar("Luxury", "Luxury"+(carno+1), noOfDays,id);
                                type="Luxury";
                                // cartype=CategoryFactory.getCar("Luxury", "Luxury"+(carno+1), noOfDays);
                                addonproperty=CategoryFactory.addonoption("GPS","GPS"+(carno+1),cartype,noOfDays);
                                
                                CategoryFactory.licensePlatePurchased(type, id);
                                rentalRecord.addCars(id);
                            }
                            	}
                            
                        }
                        }
                        else if (carno==4) {
                        	id = "SU"+j;
                        	if(SUV.ids.contains(id)) {
                            cartype=CategoryFactory.getCar("SUV", "SUV"+(carno+1), noOfDays,id);
                            type="SUV";
                           // cartype=CategoryFactory.getCar("SUV", "SUV"+(carno+1), noOfDays);
                            addonproperty=CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio"+(carno+1),cartype,noOfDays);
                            
                            CategoryFactory.licensePlatePurchased(type, id);
                            rentalRecord.addCars(id);
                        	}
                        	else {
                        		Random rg= new Random();
                        		if(!SUV.ids.isEmpty()) {
                        		int rn=rg.nextInt(SUV.ids.size());
                        		id = SUV.ids.get(rn);
                            	if(SUV.ids.contains(id)) {
                                cartype=CategoryFactory.getCar("SUV", "SUV"+(carno+1), noOfDays,id);
                                type="SUV";
                               // cartype=CategoryFactory.getCar("SUV", "SUV"+(carno+1), noOfDays);
                                addonproperty=CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio"+(carno+1),cartype,noOfDays);
                                
                                CategoryFactory.licensePlatePurchased(type, id);
                                rentalRecord.addCars(id);
                        	}
                        		}
                            
                        
                        }
                        }
                        else {
                        	//System.out.println("Car Number");
                        	//System.out.println(carno);
                        	id = "MV"+j;
                        	if(MiniVan.ids.contains(id)) {
                        	
                            cartype=CategoryFactory.getCar("MiniVan", "MiniVan"+(carno+1), noOfDays,id);
                            type="MiniVan";
                          //  cartype=CategoryFactory.getCar("Minivan", "Minivan"+(carno+1), noOfDays);
                            addonproperty=CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio"+(carno+1),cartype,noOfDays);
                            
                            CategoryFactory.licensePlatePurchased(type, id);
                            rentalRecord.addCars(id);
                        	}
                        	else {
                        		Random rg= new Random();
                        		if(!MiniVan.ids.isEmpty()) {
                        		int rn=rg.nextInt(MiniVan.ids.size());
                        		//System.out.println(MiniVan.ids);
                        		id = MiniVan.ids.get(rn);
                            	if(MiniVan.ids.contains(id)) {
                            	
                                cartype=CategoryFactory.getCar("MiniVan", "MiniVan"+(carno+1), noOfDays,id);
                                type="MiniVan";
                              //  cartype=CategoryFactory.getCar("Minivan", "Minivan"+(carno+1), noOfDays);
                                addonproperty=CategoryFactory.addonoption("SatelliteRadio","SatelliteRadio"+(carno+1),cartype,noOfDays);
                                
                                CategoryFactory.licensePlatePurchased(type, id);
                                rentalRecord.addCars(id);
                        	}
                        		}
                        }
                        }
                        if (cartype!=null){
                            rentalRecord.addDecoratorOptions((Decorator)addonproperty);
                            }
                        if (cartype==null){
                            System.out.println("customer not able to purchase car of type " + type);
                        }
                        else {
                            System.out.println("customer purchases cartype " + cartype.name);
                            System.out.println("License Plate of car purchased is "+ id);
                            System.out.println("Addons: " + addonproperty.name);
                        }
                        
                    //System.out.println("Hello");
                    //System.out.println(rentalRecord);  
                    customer.addRentalRecord(rentalRecord);
                    //System.out.println(customer.getRentalRecord());
                    totalPrice=rentalRecord.getTotalPrice();
                    total=total+totalPrice;
                    System.out.println("Price of RentalRecord is " + totalPrice);
                        
                    }

                if(totalPrice !=0){
                    System.out.println("Total price the store made that day " + totalPrice);
                }
            

            }
            List<Customer> customers = rs.returnCustomer();//					System.out.println("type is " +type);

            System.out.println("total number of completed rentals");
            int totalCompletedRentals = 0;
            int countBusiness = 0;
            int countRegular = 0;
            int countCasual = 0; 
            for(Customer customer:customers)
            {
                String type = customer.getClass().getSimpleName();
                
                List<RentalRecord> crr = customer.getRentalRecord();
                int temp=-1;
                for (RentalRecord rentalRecord: crr) {
                    if (rentalRecord.getStatus() == false ) {
                        totalCompletedRentals++;
    
                        if (type.equals("RegularCustomer")){
                            countRegular++;
                        }
                        else if (type.equals("BusinessCustomer")) {
                            countBusiness++;
                        }
                        else if (type.equals("CasualCustomer")) {
                            countCasual++;
                        }
                    }
                }
    
            }
            
            //Summary of 34 days
            System.out.println("+++++++++++++++++++++++++++++++++++++ Summary +++++++++++++++++++++++++++++");
            System.out.println("Total completed rentals is " +totalCompletedRentals);
            System.out.println("Total completed rentals for regular customer is " +countRegular);
            System.out.println("Total completed rentals for business customer is " +countBusiness);
            System.out.println("Total completed rentals for casual customer is " +countCasual);
            System.out.println("Total profit of store for the entire period " +total);


        }
    }



 















