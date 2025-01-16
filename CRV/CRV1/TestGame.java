
public class TestGame {
    public static void main(String[] args) {

        System.out.println("Welcome to the GameAttack!");
        // getting the fighter name
        System.out.print("enter the name of Your figther : ");

        String fightername=System.console().readLine();
        // creating instance 
        Fighter fighter =new Fighter(fightername);
         
        // creating enemy and add three attacks to it 
        Enemy enemy= new Enemy("Goblin") ;
        enemy.addAttack(new Attack("Slash", 20));
        enemy.addAttack(new Attack("Stab", 15));
        enemy.addAttack(new Attack("Punch", 25));

        while (fighter.getHealth()>0 && enemy.getHealth()>0) {
            System.out.println("\n Your turn Choose an Attack :");
            fighter.displayAttacks();
            System.out.println("Enter number of your attacks ");
            int choice =Integer.parseInt(System.console().readLine());
            fighter.attack(choice-1, enemy);
            if (enemy.getHealth()<=0) {
                System.out.println("You Win ! ");
                break ;
            }
            // Enemy Turn 
            enemy.randomAttack(fighter);
            if (fighter.getHealth()<=0) {
                System.out.println("You Lose ! ");
                break ;
            }
        }
        // ask the player if he want to play again 
        System.out.println("Play again ? ");
        String again =System.console().readLine();
        if (again.equalsIgnoreCase("yes")) {
            main(args);
        }
        System.out.println("Thank You for Playing ");

    }
}
