import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava PJ=new PuzzleJava() ;
		System.out.println(PJ.getTenRolls());
		System.out.println(PJ.getRandomLetter());
        System.out.println(PJ.generatePassword());
        System.out.println(PJ.getNewPasswordSet(3));
    	        //..
		// Write your other test cases here.
		//..
	}
}
