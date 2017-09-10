/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos1;

import java.util.Arrays;

/**
 *
 * @author brianbrookwell
 */
public class ArrayChange {
    
    public static void main (String[] args) {
        int[] grades = {5, 10, 8, 9}; 
        System.out.println ("Before: " + Arrays.toString(grades));
        modify (grades);
        System.out.println ("After: " + Arrays.toString(grades));
    }
    
    public static void modify (int[] numbers) {
        int []array = {5, 4, 3, 2, 1};
        numbers = array;
        System.out.println ("Inside: " + Arrays.toString(numbers));
    }
}

