/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

/**
 *
 * @author Fanny Brenes
 */
public class Partitions {

 
int quantity;
float size;

   
String root;


public Partitions(int quantity,String root,float size){
this.quantity=quantity;
this.root=root;
this.size=size;
}
public Partitions(){
}
   public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
   public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
