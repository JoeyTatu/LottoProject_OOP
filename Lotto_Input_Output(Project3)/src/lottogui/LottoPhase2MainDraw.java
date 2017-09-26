/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottogui;

import java.util.Random;

/**
 *
 * @author x15015556
 */
public class LottoPhase2MainDraw  {

    private int[] secret; // create lotto result - 1D
    private int[][] num; //creates num 2D array
    private int correctL1; //correct line 1 -- checking if a number matches
    private int correctL2;
    private int correctL3;
    private String input;

    public LottoPhase2MainDraw(){
        secret = new int[5];
        num = new int[3][5];
        correctL1 = 0;
        correctL2 = 0;
        correctL3 = 0;
        input = new String();
    }

    public LottoPhase2MainDraw(int[] secret, int[][] num, int correctL1, int correctL2, int correctL3, String input, Integer n) {
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
    
//    public void createSecret(){
//        for(int i = 0; i<secret.length; i++){
//            secret = new Random().ints(1, 40).distinct().limit(5).toArray(); // -------- Will only work on JDK8 or higher -----------
//        }
//        
//        //Printing secret numbers - hide for real game.
//        //System.out.println(Arrays.toString(secret));
//    }
    
    public void computeCheckInput(){
        //Checking if numbers in each line (user-input) maches secret number
        for (int i = 0; i <num.length; i++){
            for(int j = 0; j <num[0].length; j++){

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

