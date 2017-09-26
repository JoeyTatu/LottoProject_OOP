/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottogui;

/**
 *
 * @author x15015556
 */
public class DuplicatesRange {
   
    private int[][] num;
    private boolean outOfRange;
    private boolean hasDuplicates;
    private int[][] saved;
    
    public DuplicatesRange(){
        num = new int[3][5];
        saved = new int[3][5];
        outOfRange = false;
        hasDuplicates = false;
    }

    public DuplicatesRange(int[][] num, boolean outOfRange, boolean hasDuplicates, int[][] saved) {
        this.num = num;
        this.outOfRange = outOfRange;
        this.hasDuplicates = hasDuplicates;
        this.saved = saved;
    }

    public void setNum(int[][] num) {
        this.num = num;
    }

    public boolean setOutOfRange(){

        boolean outOfRange  = false;
        // for each line in num

            for(int i = 0; i < num.length && !outOfRange; i++)
            {
                // for every number in the row
                for(int j = 0; j < num[0].length; j++)
                {
                    // check if number is in range
                    if((num[i][j]<1)||(num[i][j]>40)){
                        
                            outOfRange = true; // we have found a number not in range
                            break; // no need to keep checking; break the loop and return
                        
                    }
                }
            }
        return outOfRange;
    }
    
    public boolean setHasDuplicates(){

        boolean hasDuplicate  = false;
        // for each line in num
        for(int[] line : num)
        {
            // for every number in the row
            for(int i = 0; i < line.length && !hasDuplicate; i++)
            {
                // for every number in the row
                for(int j = 0; j < line.length; j++)
                {
                    // if we are not comparing the same number
                    if(i != j)
                    {
                        // check for equality
                        if(line[i] == line[j])
                        {
                            hasDuplicate = true; // we have found a duplicate
                            break; // no need to keep checking; break the loop and return
                        }
                    }
                }
            }
        }
        return hasDuplicate;
    }
}



