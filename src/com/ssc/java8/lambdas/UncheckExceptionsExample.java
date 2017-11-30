/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UncheckExceptionsExample {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("Zzz");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UncheckExceptionsExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }
    
    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception ex) {
                Logger.getLogger(UncheckExceptionsExample.class.getName()).log(Level.SEVERE, null, ex);
                
                throw new RuntimeException(ex);
            }
        };
    }
    
    @FunctionalInterface
    public interface RunnableEx {

        public void run() throws Exception;

    }

}
