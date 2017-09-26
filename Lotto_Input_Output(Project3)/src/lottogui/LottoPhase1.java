package lottogui;

/**
 * @filename Lottery.java (Phase 1)
 * @author Keith Feeney - 15015556
 * @author Cedric Vecchionacce - 15011071
 * @author Chaman Ali - 15016005
 * @date 21 October 2016
 */

import java.io.Serializable;
import java.util.Random;

public class LottoPhase1 implements Serializable{
    
    private int[] secret;
    private int[][] num;
    private int correctL1; //correctL1 (correct Line 1 -- checking if a number matches secret/result
    private int correctL2;
    private int correctL3;

    public LottoPhase1(){
        secret = new int[5];
        num = new int[3][5];
        correctL1 = 0;
        correctL2 = 0;
        correctL3 = 0;
    }

    public LottoPhase1(int[] secret, int[][] num, int correctL1, int correctL2, int correctL3, String input, Integer n) {
        this.secret = secret;
        this.num = num;
        this.correctL1 = correctL1;
        this.correctL2 = correctL2;
        this.correctL3 = correctL3; //added overloaded constructor if needed in the future (real world future)
    }
    
    
    public void setNum(int[][] num) {
        this.num = num;
    }
    
    public int[][] getNum(){
        return num;
    }
    
    public int[] getSecret() {
        return secret;
    }

    public void setSecret(int[] secret) {
        this.secret = secret;
    }

    public int getCorrectL1() {
        return correctL1;
    }

    public void setCorrectL1(int correctL1) {
        this.correctL1 = correctL1;
    }

    public int getCorrectL2() {
        return correctL2;
    }

    public void setCorrectL2(int correctL2) {
        this.correctL2 = correctL2;
    }

    public int getCorrectL3() {
        return correctL3;
    }

    public void setCorrectL3(int correctL3) {
        this.correctL3 = correctL3;
    }
    
    //creats lotto results
//    public void createSecret(){
//        for(int i = 0; i<5; i++){ //can also be for(int i = 0; i < secret.length; i++)...
//            secret = new Random().ints(1, 40).distinct().limit(5).toArray(); // -------- Will only work on JDK8 or higher -----------
//        }
//        
//        //Printing secret numbers - hide for real game.
//        //System.out.println(Arrays.toString(secret));
//    }
    
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
}
