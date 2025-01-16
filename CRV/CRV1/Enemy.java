import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    // attributes
    private String name ;
    private int health ;
    private ArrayList <Attack> attacklist ;
    // constructor 
 public Enemy (String name){
    this.name=name;
    this.health=100;
    this.attacklist=new ArrayList<>();
 }

 // creating Getters for name , health and attacklist 
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
// Methods 
    // Method to perform a random attack on a  fighter 
    public void randomAttack(Fighter fighter){
        if (!attacklist.isEmpty()){
            Random random = new Random();
            int index = random.nextInt(attacklist.size());
            Attack chosenAttack=attacklist.get(index);
            fighter.reduceHealth(chosenAttack.getDamageamount());
            System.out.println("Enemy used "+chosenAttack.getName()+" ! Remaining Health is :  "+fighter.getHealth());
        }
    }
    // Method  to reduce health of the enemy 
    public void reduceHealth(int amount){
        this.health-=amount ;
        if (this.health<0) {
            this.health=0;
        }
    }
     // 
     public void addAttack (Attack attack){
        attacklist.add(attack);
     }
}
