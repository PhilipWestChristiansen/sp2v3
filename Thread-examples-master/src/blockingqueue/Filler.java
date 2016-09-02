/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author sofus
 */
public class Filler {

    public Filler(BlockingQueue<Integer> start) {
        for (int i = 1; i < 1_000_000; i++) {
            start.add(i);
        }
        
    }
    
}
