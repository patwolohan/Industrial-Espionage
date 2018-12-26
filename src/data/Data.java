/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author PatWolohan
 */
public class Data {
    private static int fibSize = 40;

    /**
     *
     * @return
     */
    public static int getFibSize() {
        return fibSize;
    }
    private Integer[] fibArray = new Integer[fibSize];
        
    /**
     *
     */
    public Data() {
    }

    /**
     *
     * @return
     */
    public Integer[] getFibArray() {
        return fibArray;
    }

    /**
     *
     * @return
     */
    public int getFibArrayLength() {
        int l = fibArray.length;
        return l;
    }

    /**
     *
     * @param n
     * @param fib
     */
    public void setFibArray(int n, int fib){
        fibArray[n] = fib;
    }
    
    
    
}
