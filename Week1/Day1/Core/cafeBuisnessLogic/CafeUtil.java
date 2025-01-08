import java.util.ArrayList;

public class CafeUtil {


    //constructor 
public CafeUtil (){}

    //methods 
public Integer getStreakGoal(int numWeeks){
    int sum=0;
    for (int i=1;i<=numWeeks;i++){
        sum+=i ;
    }
    return sum ;
}   
public double getOrderTotal(double[] prices){
        double total=0.0;
        for (int i=0;i<prices.length;i++){
            total+=prices[i] ;
        }
        return total ;
    }

public void displayMenu(ArrayList<String> menuItems){
    int count=0;
    for (String val : menuItems) {

        System.out.println(count +" " + val);
        count++ ;
    }
}
public void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name:");
    String username = System.console().readLine();
    System.out.println("Hello "+username+" !");
    System.out.println("There are "+customers.size()+" People in front of you");
    customers.add(username);

}
}