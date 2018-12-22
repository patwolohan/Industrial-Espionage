/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author PatWolohan <patwolohan.org>
 */
public class Data {
    private static int fibSize = 40;

    public static int getFibSize() {
        return fibSize;
    }
    private Integer[] fibArray = new Integer[fibSize];
        
    public Data() {
    }

    public Integer[] getFibArray() {
        return fibArray;
    }
    public int getFibArrayLength() {
        int l = fibArray.length;
        return l;
    }

    public void setFibArray(int n, int fib){
        fibArray[n] = fib;
    }
    
    
    
}
