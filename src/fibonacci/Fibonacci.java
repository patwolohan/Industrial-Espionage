/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/** Responsible for creating Fibonacci numbers. 
 *  The Fibonacci sequence is a set of numbers that starts with a one or a zero, followed by a one, and proceeds based on the rule 
 that each number (called a Fibonacci number) is equal to the sum of the preceding two numbers.
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
