package lottery;

/**
 * @filename Lottery.java (Phase 1)
 * @author Keith Feeney - 15015556
 * @author Cedric Vecchionacce - 15011071
 * @author Chaman Ali - 15016005
 * @date 21 October 2016
 */

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lottery {
    
    private int[] secret;
    private final int[][] num;
    private int correctL1; //correctL1 (correct Line 1 -- checking if a number matches secret/result
    private int correctL2;
    private int correctL3;

    public Lottery(){
        secret = new int[5];
        num = new int[3][5];
        correctL1 = 0;
        correctL2 = 0;
        correctL3 = 0;
    }

    public Lottery(int[] secret, int[][] num, int correctL1, int correctL2, int correctL3, String input, Integer n) {
        this.secret = secret;
        this.num = num;
        this.correctL1 = correctL1;
        this.correctL2 = correctL2;
        this.correctL3 = correctL3; //added overloaded constructor if needed in the future (real world future)
    }

//-------GETTERS AND SETTERS ARE NOT NEEDED, NOT GETTING/SETTING ANYTHING TO/FROM APP-------
    
    //Create 2D array from user-input
    public void computeUserInput(){
       for (int i= 0; i < num.length; i++) {

            for (int j = 0; j < num[0].length; j++) {
                
                int k = i+1; // shows user's lines as 1, 2, 3, and not 0, 1, 2. (User-interface only)
                int l = j+1;
                
                num[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter value for Line " + k + ", position " + l));
            }
        }
    }
    
    //creats lotto results
    public void createSecret(){
        for(int i = 0; i<5; i++){ //can also be for(int i = 0; i < secret.length; i++)...
            secret = new Random().ints(1, 40).distinct().limit(5).toArray(); // -------- Will only work on JDK8 or higher -----------
        }
        
        //Printing secret numbers - hide for real game.
        System.out.println(Arrays.toString(secret));
    }
    
    //Checks if numbers in each line (user-input) maches secret number
    public void computeCheckInput(){
        
        for (int i = 0; i < 5; i++){ //can also be for(int i = 0; i < num.length; i++)...
            for(int j = 0; j < 5; j++){ //can also be for(int i = 0; i < num[0].length; i++)...

                if((num[0][j] == secret[i])){
                    correctL1 = correctL1 + 1;
                }

                if((num[1][j] == secret[i])){
                    correctL2 = correctL2 + 1;
                }

                if((num[2][j] == secret[i])){
                    correctL3 = correctL3 + 1;
                }
            }
        }
    }

    //Prints secret number (results), the user's numbers (input), and how many are matched on each line
    public String printDetails(){
 
        return "You have " + correctL1 + " numbers on Line 1.\n" +
                "You have " + correctL2 + " numbers on Line 2.\n" +
                "You have " + correctL3 + " numbers on Line 3." +
                "\n\nSecret: " + Arrays.toString(secret) + 
                "\nYour numbers - " +
                "\nLine 1: " + Arrays.toString(num[0]) + 
                "\nLine 2: " + Arrays.toString(num[1]) +
                "\nLine 3: " + Arrays.toString(num[2])
                ;
    }
}
