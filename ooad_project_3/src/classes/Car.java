package classes;
import java.util.List;
//Abstract class Car that provides methods to be implemented by the derived classes.
public abstract class Car{
    public String name;
    public int num_days;
    
    public abstract int quotePrice();
    public abstract void onReturn(List<String> ids);
    
}