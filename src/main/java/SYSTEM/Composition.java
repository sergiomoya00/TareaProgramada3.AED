/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import java.util.Comparator;

/**
 *
 * @author Fanny Brenes
 */
public class Composition implements Comparator<Integer> {
   public int compare(Integer x, Integer y){
   return x-y;
   } 
}
