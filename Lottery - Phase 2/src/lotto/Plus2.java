
package lotto;

/**
 * @filename Plus2.java (Phase 2)
 * @author Keith Feeney - 15015556
 * @author Cedric Vecchionacce - 15011071
 * @author Chaman Ali - 15016005
 * @date 28 October 2016
 */

import java.util.Random;

public class Plus2{

    private int[] secret;
    private int[][] num;
    private int correctL1;
    private int correctL2;
    private int correctL3;
    private String input;

    public Plus2(){
        secret = new int[5];
        num = new int[3][5];
        correctL1 = 0;
        correctL2 = 0;
        correctL3 = 0;
        input = new String();
    }

    public Plus2(int[] secret, int[][] num, int correctL1, int correctL2, int correctL3, String input) {
        this.secret = secret;
        this.num = num;
        this.correctL1 = correctL1;
        this.correctL2 = correctL2;
        this.correctL3 = correctL3;
        this.input = input;
    }


    public int[] getSecret() {
        return secret;
    }


    public void setSecret(int[] secret) {
        this.secret = secret;
    }


    public int[][] getNum() {
        return num;
    }


    public void setNum(int[][] num) {
        this.num = num;
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

 
    public String getInput() {
        return input;
    }

    
    public void setInput(String input) {
        this.input = input;
    }



    public void createSecret(){
        for(int i = 0; i<5; i++){
            secret = new Random().ints(1, 40).distinct().limit(5).toArray();
        }
        

        //System.out.println(Arrays.toString(secret));
    }
    
    public void computeCheckInputP2(){

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

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

    public String printDetailsP2(){
         //Prints secret number and each user line to screen
        return "In the Lotto PLUS 2 draw," +
                "\nLine 1 - Numbers matched: " + correctL1 +
                "\nLine 2 - Numbers matched: " + correctL2 +
                "\nLine 3 - Numbers matched: " + correctL2
        ;
    }
}
