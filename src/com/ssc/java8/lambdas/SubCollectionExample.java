/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Jesus_Serrato
 */
public class SubCollectionExample {
    
    public static void main(String[] args) {
        LinkedList2<String> linkedList2 = new LinkedList2<>();
        linkedList2.add("Hola");
        linkedList2.add("Hello");
        linkedList2.add("Pepe pecas pica papas con un pico pepe pecas pica papas");
        linkedList2.add("Peter Piper picked a peck of pickled peppers");
        
        linkedList2.forEachIf(System.out::println, s -> {
            return s.length() > 10;
        });
    }
    
}

interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        forEach((e) -> {
            if (filter.test(e)) {
                action.accept(e);
            }
        });
    }

}

class LinkedList2<T> extends LinkedList<T> implements Collection2<T> {

}
