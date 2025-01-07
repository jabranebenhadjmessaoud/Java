import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls(){
        Random randMachine = new Random();
        ArrayList<Integer> tenrolls =new ArrayList<Integer> ();
        for (int i=0;i<10;i++){
            tenrolls.add(randMachine.nextInt(1,20)) ;
            
        }
        return tenrolls ;
    }
    public char getRandomLetter(){

        Random randMachine = new Random();
        
        int letterindex=randMachine.nextInt(0,25) ;
        String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        char charac=allLetters.charAt(letterindex) ;
        return  charac;
    }
    public String generatePassword (){
        String password="";
        for (int i=0; i<8;i++){
            password =password+ getRandomLetter() ;
        }

        return password ;
    }
    public ArrayList<String>getNewPasswordSet(int num){
        ArrayList<String> passwordlist =new ArrayList<String> ();
        for(int i=0;i<num;i++){
            passwordlist.add(generatePassword());
        }
        return passwordlist;
    }




}
