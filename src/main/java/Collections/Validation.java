/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author Fanny Brenes
 */
public class Validation {
public void Validar(){}
public boolean Validate(String cadena){
  int num;
  try{
  num=Integer.parseInt(cadena);
  return true;
  }
  catch (Exception e){
  return false;
  }
}
}
