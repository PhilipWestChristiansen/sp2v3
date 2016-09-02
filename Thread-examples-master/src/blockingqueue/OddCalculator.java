/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofus
 */
public class OddCalculator implements Runnable {
BlockingQueue<Integer> seed;
BlockingQueue<Integer> odd;
    public OddCalculator(BlockingQueue<Integer> seed ,BlockingQueue<Integer> prime) {
    this.seed=seed;
    this.odd=prime;
    }
    
    boolean isOdd(int n) {
        if(n%2==0)
            return false;
    return true;
    }

    @Override
    public void run() {
        while(true){
        
            try {
                Integer in =seed.poll(1, TimeUnit.SECONDS);
                if (in==null)
                    break;
                if(isOdd(in))
                    odd.put(in);
            } catch (InterruptedException ex) {
                Logger.getLogger(OddCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Done calc");
        
    }
}
