package classes;

import java.util.ArrayList;
import java.util.List;

import patterns.Decorator;
//RentalRecord stores rental information per customer.
public class RentalRecord {
    public int dayofBuying;
    boolean status;
    public List<String> ides = new ArrayList<String>();
    public RentalRecord(int buyDay){
        this.dayofBuying=buyDay;
        this.status=true;
    }
    public List<Decorator> decoratorOptions=new ArrayList<Decorator>();

    public List<Decorator> getDecoratorOptions() {
        return decoratorOptions;
    }

    public void addDecoratorOptions(Decorator decoratorOption){
        decoratorOptions.add(decoratorOption);
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status=status;
    }
    public void addCars(String id) {
    	ides.add(id);
    }
    public List<String> getIds(){
    	return ides;
    }

    public int getTotalPrice(){
        int total=0;
        for (int i=0;i<decoratorOptions.size();i++){
            total=total+decoratorOptions.get(i).quotePrice();
        }
        return total;
    }
    //Function for returning Car
    public void returnCar(Customer cus,List<String> ids){
        for(int i=0;i<decoratorOptions.size();i++){
            Decorator dec=decoratorOptions.get(i);
            //System.out.println(dec.getClass().getSimpleName());
            while (!dec.getClass().getSimpleName().equals("Economy") || !dec.getClass().getSimpleName().equals("SUV") ||
                    !dec.getClass().getSimpleName().equals("MiniVan") || !dec.getClass().getSimpleName().equals("Luxury") ||
                    !dec.getClass().getSimpleName().equals("GPS")) {
                        if(dec.car instanceof Decorator) {
                            dec=(Decorator) dec.car;
                        }
                        else {
                            break;
                        }
            }
            //Processing return of Car
            dec.car.onReturn(ids);
            System.out.println(dec.car.name+" returned by customer"+ cus.name);
                    }
        }
        
    }
