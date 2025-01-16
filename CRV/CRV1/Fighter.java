import java.util.ArrayList;

public class Fighter {

    // Attributes

    private String name ;
    private int health ;
    private ArrayList <Attack> attacklist ;

    // Constructor 
    public Fighter(String name){
        this.name=name;
        this.health=100;
        this.attacklist=new ArrayList<>();
        this.attacklist.add(new Attack("Punch", 20)) ;
        this.attacklist.add(new Attack("Kick", 15)) ;
        this.attacklist.add(new Attack("Tackle", 25)) ;
    }
    // Getters 
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }

    // Methods 
        // Method To display the attacks
        public void displayAttacks(){
            for (Attack attack:attacklist){
                System.out.println(attack.getName()+"--- damage : "+attack.getDamageamount());
            }
        }
        // Method to perform an attack on an enemy 
        public void attack (int index ,Enemy enemy){
            if (index>0 && index <attacklist.size()) {
                Attack chosenAttack=attacklist.get(index);
                enemy.reduceHealth(chosenAttack.getDamageamount());
                System.out.println("You Choosed "+chosenAttack.getName()+"--- damage : "+enemy.getHealth());
            }
        }
        public void reduceHealth(int amount){
            this.health-=amount ;
            if (this.health<0) {
                this.health=0;
            }
        }
}
