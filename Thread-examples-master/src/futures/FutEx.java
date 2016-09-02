/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author sofus
 */
public class FutEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
         ExecutorService executor = Executors.newFixedThreadPool(1);
         Callable<String> c = new Callable<String>() {
             @Override
             public String call() throws Exception {
                 Thread.sleep(1000*5);
                 return "Done sleeping";
             }
         };
         
         
        Future<String> out= executor.submit(c);
        System.out.println("Task submitted");
        System.out.println(out.get());
        executor.shutdown();
    }
}
