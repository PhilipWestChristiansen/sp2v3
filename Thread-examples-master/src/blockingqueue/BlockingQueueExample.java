/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author sofus
 */
public class BlockingQueueExample {
    //checks whether an int is prime or not.



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> start = new ArrayBlockingQueue<Integer>(1_000_000);
        BlockingQueue<Integer> odd = new ArrayBlockingQueue<Integer>(1_000_000);
        Filler f = new Filler(start);
        System.out.println("done filling");
        
        for (int i = 0; i < 5; i++) {
        OddCalculator pc = new OddCalculator(start, odd);
        new Thread(pc).start();
            System.out.println("Prime calc started");
        }
        
     Thread.sleep(10*1000);
        System.out.println(odd.size());
        
    }
    
}
