/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author PatWolohan patwolohan.org
 */
public class Fibonacci {    
    
    /**
     *
     */
    public Fibonacci() {
        
    }
    
    /**
     *
     * @param n
     * @return
     */
    public int fibGenerate(int n) {
        if (n <= 1) {
            return n;
        }
        return fibGenerate(n - 1) + fibGenerate(n - 2);
    }

}
