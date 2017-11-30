/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

/**
 *
 * @author Jesus_Serrato
 */
public class AndThenExercise {

    public static void main(String[] args) {
        andThen(
            () -> { 
                System.out.println("First"); 
            }, 
            () -> {
                System.out.println("Second");
            }
        ).run();
    }
    
    public static Runnable andThen(Runnable runner1, Runnable runner2) {
        return () -> {
            runner1.run();
            runner2.run();
        };
    }
    
}
