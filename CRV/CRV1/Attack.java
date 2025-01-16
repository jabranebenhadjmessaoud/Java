
public class Attack {
    private String name ;
    private int damageamount;

    // constructor to initialize the attack 
    public Attack (String name , int damageamount){
        if (damageamount<5||damageamount>25){
            throw new IllegalArgumentException("Damage amount must be between 5 and 25") ;
        }
        this.name=name ;
        this.damageamount=damageamount ;
    }
    // methods 
    // creating getters for attack name and damageamount
    public String getName(){
        return name;
    } 
    public int getDamageamount(){
        return damageamount;
    } 

}
