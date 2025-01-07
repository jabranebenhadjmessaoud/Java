import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        Item item1=new Item();
        Item item2=new Item();
        Item item3=new Item();
        Item item4=new Item();

        item1.setName("mocha");
        item2.setName("latte");
        item3.setName("drip coffee");
        item4.setName("cappuccino");

        item1.setPrice(3.25);
        item2.setPrice(4.5);
        item3.setPrice(2.15);
        item4.setPrice(3.5);

        Order order1=new Order();
        Order order2=new Order();
        Order order3=new Order();
        Order order4=new Order();
        order1.setName("Cindhuri");
        order2.setName("Jimmy");
        order3.setName("Noah");
        order4.setName("Sam");

        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %s\n", order2.getTotal());
        System.out.printf("Ready: %s\n", order2.getReady());
        ArrayList <Item> listofitems2=new ArrayList<>() ;
        listofitems2.add(item1) ;
        order2.setItems(listofitems2); 
        order2.setTotal(order2.getTotal()+item1.getPrice());
        ArrayList <Item> listofitems3=new ArrayList<>() ;
        listofitems3.add(item4) ;
        order3.setItems(listofitems3); 
        order3.setTotal(order3.getTotal()+item4.getPrice());
        ArrayList <Item> listofitems4=new ArrayList<>() ;
        listofitems4.add(item2) ;
        order4.setItems(listofitems4); 
        order4.setTotal(order4.getTotal()+item2.getPrice());
        order1.setReady(true);

        listofitems4.add(item2) ;
    
        order4.setItems(listofitems4); 
        order4.setTotal(order4.getTotal()+(item2.getPrice()*2));



        order2.setReady(true);

        // Menu items
    
        // Order variables -- order1, order2 etc.
        
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %s\n", order1.getTotal());
        System.out.printf("Ready: %s\n", order1.getReady());


        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %s\n", order2.getTotal());
        System.out.printf("Ready: %s\n", order2.getReady());

        System.out.println("******************");
        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getTotal());
        System.out.printf("Ready: %s\n", order3.getReady());
        System.out.println("******************");
        System.out.printf("Name: %s\n", order4.getName());
        System.out.printf("Total: %s\n", order4.getTotal());
        System.out.printf("Ready: %s\n", order4.getReady());
    }
}
