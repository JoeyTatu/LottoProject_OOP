package lotto;

/**
 * @filename LotteryPhase2App.java (Phase 2)
 * @author Keith Feeney - 15015556
 * @author Cedric Vecchionacce - 15011071
 * @author Chaman Ali - 15016005
 * @date 28 October 2016
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


public class LotteryPhase2App {

    public static void main(String[] args) {
        
        String input;
        int[][] num = new int[3][5];
        int[] secretMain;
        int[] secretPlus1;
        int[] secretPlus2;
        
        //Gets user input // Cannot put into ins. classes as user input should
        //be the same for all draws. It would not make sense if it was in each ins. class
        Set<Integer> data = new HashSet<>();//Uning array list

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {

                boolean isNotDuplicate = false;

                int k = i+1; //shows user's lines as 1, 2, 3, and not 0, 1, 2. (User-interface only)
                int l = j+1;

                while (!isNotDuplicate ) { //in English; while 'is duplicate', do the following:
                    input = JOptionPane.showInputDialog(null, "Please enter value for line " + k + " and position " + l + ".");

                    Integer n = Integer.parseInt(input); //converts input to int and allocates 'input' to 'n' (n = input)

                    if (data.contains(n)) { //if valid, throws user back to input, requests same number again
                        JOptionPane.showMessageDialog(null, "ERROR! No duplicates!");
                    }
                    
                    else if((n<1) || (n>40)){ //if valid, throws user back to input, requests same number again
                        JOptionPane.showMessageDialog(null, "ERROR! Numbers must be from 1 to 40. Try again.");
                    }
                    else {
                        num[i][j] = n; //if valid, adds number to num[i][j]
                        isNotDuplicate  = data.add(n);
                    }
                }
            }
        }
        
        MainDraw m = new MainDraw(); //declare and create object
        m.setNum(num); //sets num in MainDraw
        m.createSecret(); //creates lotto result
        m.computeCheckInput(); //checks if numbers match
        secretMain = m.getSecret(); //allocates 'secretMain' to show in final message
        
        Plus1 p1 = new Plus1();
        p1.setNum(num);
        p1.createSecret();
        p1.computeCheckInputP1();
        secretPlus1 = p1.getSecret();
        
        Plus2 p2 = new Plus2();
        p2.setNum(num);
        p2.createSecret();
        p2.computeCheckInputP2();
        secretPlus2 = p2.getSecret();
        
        Arrays.sort(num[0]); //to show user-inputs in ascendidng order
        Arrays.sort(num[1]);
        Arrays.sort(num[2]);
        
        Arrays.sort(secretMain); //to show results in ascending order
        Arrays.sort(secretPlus1);
        Arrays.sort(secretPlus2);
        
        JOptionPane.showMessageDialog(null,
            "Your numbers \n" + // prints user input
            "Line 1: " + Arrays.toString(num[0]) + "\n" +
            "Line 2: " + Arrays.toString(num[1]) + "\n" +
            "Line 3: " + Arrays.toString(num[2]) +
            "\n \n" +
            "****" + "\n" + 
            "Lotto results" + //prints all secrets / lotto results
            "\n" + "Main:   " + Arrays.toString(secretMain) +  
            "\n" + "Plus 1: " + Arrays.toString(secretPlus1) +
            "\n" + "Plus 2: " + Arrays.toString(secretPlus2) +
            "\n" + "****" +
            "\n \n" + m.printDetailsMain() + //prints the additional information from each ins class (if numbers match)
            "\n \n" + p1.printDetailsP1() +
            "\n \n" + p2.printDetailsP2()
        );
    }       
}