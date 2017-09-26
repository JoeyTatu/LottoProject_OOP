/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery;

/**
 * @filename LotteryPhase1App.java (Phase 1)
 * @author Keith Feeney - 15015556
 * @author Cedric Vecchionacce - 15011071
 * @author Chaman Ali - 15016005
 * @date 21 October 2016
 */

import javax.swing.JOptionPane;

public class LotteryPhase1App { //Phase 1

    public static void main(String[] args) {    

        //creates and declares object
        Lottery l = new Lottery();
        
        l.createSecret(); //requests ins class to run createSecret
        l.computeUserInput(); //requests ins class to run computeUserInput
        l.computeCheckInput(); //resuests ins class to run computeCheckInput
        
        JOptionPane.showMessageDialog(null, l.printDetails()); //prints results
        
    }
        
}   
    
