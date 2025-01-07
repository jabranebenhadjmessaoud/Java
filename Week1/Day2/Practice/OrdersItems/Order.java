
import java.util.ArrayList;

public class Order {
    private String name ;
    private Double total=0.0 ;
    private Boolean ready=false;
    private ArrayList<Item>items ;
    public Order (){} ;

    public String getName(){
        return this.name;
     }
    public void setName(String name) {
        this.name = name;
    }
    public Double getTotal(){
        return this.total;
     }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Boolean getReady(){
        return this.ready;
     }
    public void setReady (Boolean ready) {
        this.ready = ready;
    }
    public ArrayList <Item> getItems(){
        return this.items;
     }
    public void setItems(ArrayList <Item> items) {
        this.items = items;
    }
}
