package classes;
import java.util.ArrayList;
import java.util.List;

//Customer class for adding RentalRecords for each customer
public abstract class Customer {
        String name;
        List<RentalRecord> record=new ArrayList<RentalRecord>();
        public String getCustomerName() {
            return this.name;
        }
        public void addRentalRecord (RentalRecord rentalrecord) {
            record.add(rentalrecord);
        }
        //TO Retrieve the rental record for a particular customer.
        public List<RentalRecord> getRentalRecord(){
            return record;
        }
        //To return the numbe rof options rented by a customer.
        public int getNumberOfOptionsRented() {
            int sum=0;
            for (int i=0;i<record.size();i++){
                    sum=sum+record.get(i).getDecoratorOptions().size();
            }
            return sum;
        }

}