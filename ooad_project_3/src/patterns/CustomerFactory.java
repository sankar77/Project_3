package patterns;

import classes.BusinessCustomer;
import classes.CasualCustomer;
import classes.Customer;
import classes.RegularCustomer;
//CustomerFactory for creation of different customers.used the factory design pattern here.
public class CustomerFactory{
    public static Customer getCustomer(String type,String name) {
        if (type.equalsIgnoreCase("RegularCustomer")) return new RegularCustomer(name);
        if (type.equalsIgnoreCase("BusinessCustomer")) return new BusinessCustomer(name);
        if (type.equalsIgnoreCase("CasualCustomer")) return new CasualCustomer(name);
        else 
        return null;
    }
    
    
}