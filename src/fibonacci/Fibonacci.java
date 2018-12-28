/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
public class Fibonacci {    
    
    /**
     *default constructor
     */
    public Fibonacci() {
        
    }
    
    /**
     *Recursive Fibonacci Generator 
     * @param n int parameter entered
     * @return fibonacci number for int n entered
     */
    public int fibGenerate(int n) {
        if (n <= 1) {
            return n;
        }
        return fibGenerate(n - 1) + fibGenerate(n - 2);
    }

}
