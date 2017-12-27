/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Jesus_Serrato
 */
public class StreamExamples {

    public static void main(String[] args) {
        //collect
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        collected.forEach(System.out::println);
        
        //map
        Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList())
                .forEach(System.out::println);
        
        //filter
        Stream.of("1abc", "abc", "12345", "aaa8").filter(item -> Character.isDigit(item.charAt(0)))
                .forEach(System.out::println);
        
        //flatmap
        Stream.of(Arrays.asList("C", "Ruby"), Arrays.asList("Java", "Lisp", "Python"))
                .flatMap(List::stream).forEach(System.out::println);
        
        //max and min
        List<Integer> numbers = Arrays.asList(10, 3, 5, 1, 2, 3, 9);
        int min = numbers.stream().min(Comparator.comparing(i -> i)).get();
        System.out.println(min);
        int max = numbers.stream().max(Comparator.comparing(i -> i)).get();
        System.out.println(max);
        
        //reduce
        int count = Stream.of(1, 2, 3, 4, 5).reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println(count);
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int sum = accumulator.apply(
                        accumulator.apply(
                            accumulator.apply(1, 2), 
                        3), 
                  4);
        System.out.println(sum);
    }
    
}
