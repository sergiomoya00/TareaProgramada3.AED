/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.Comparator;

class Composition implements Comparator<Integer>
//MÉTODO PARA EL COMPARATOR
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}
