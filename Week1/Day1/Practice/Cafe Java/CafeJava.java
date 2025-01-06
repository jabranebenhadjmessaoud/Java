

public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice=4.5 ;
        double lattePrice = 4.5;
        double cappuccinoPrice=5.5 ;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        if (isReadyOrder1==true)
            System.out.println("You "+customer1+": Your Order a is ready ");
            else
            System.out.println("You "+customer1+": Your Order is not ready Yet ");
        
        if (isReadyOrder4==true)
            System.out.println("You "+customer4+": Your Order is ready  and total is: "+ cappuccinoPrice + " $");
            else
            System.out.println("You "+customer4+": Your Order is not ready Yet ");    

        double samtotal=lattePrice*2 ;
        if (isReadyOrder2==true)
        {
            System.out.println("You "+customer2+": Your Order is ready  and total is: "+ samtotal + " $");
            isReadyOrder2=!isReadyOrder2 ;

        }
        else
        {
            System.out.println("You "+customer2+": Your Order is not ready Yet ");
        isReadyOrder2=!isReadyOrder2 ;
        }
        System.out.println(isReadyOrder2);
        
        double jimmydiff=lattePrice-dripCoffeePrice ;
        System.out.println("Hey "+customer3+" You owes :"+jimmydiff+"$");
        cappuccinoPrice=cappuccinoPrice+2 ;
        System.out.println(cappuccinoPrice);
    }

    
    }

