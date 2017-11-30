/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus_Serrato
 */
public class LambdaCapturesExample {

    public static void main(String[] args) {
        String[] names = { "Peter" , "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        
        runners.get(0).run();
        runners.get(1).run();
        runners.get(2).run();
        
        runners.clear();
        
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        
        runners.get(0).run();
        runners.get(1).run();
        runners.get(2).run();
    }
    
}
