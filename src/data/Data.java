/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author PatWolohan & Eanna Ryan
 */
public class Data {

    private static int fibSize = 40;
    private Integer[] fibArray = new Integer[fibSize];

    /**
     *
     * @return fibSize
     */
    public static int getFibSize() {
        return fibSize;
    }

    /**
     *default constructor
     */
    public Data() {
    }

    /**
     *
     * @return fibArray
     */
    public Integer[] getFibArray() {
        return fibArray;
    }

    /**
     *
     * @return fibArray Length
     */
    public int getFibArrayLength() {
        int l = fibArray.length;
        return l;
    }

    /**
     *
     * @param n array index
     * @param fib Fibonacci Number
     */
    public void setFibArray(int n, int fib) {
        fibArray[n] = fib;
    }

}
