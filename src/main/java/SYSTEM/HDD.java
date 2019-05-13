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
public class HDD {
float size;

   
float freespace;
float spaceused;
public HDD(float size,float freespace,float spaceused){
this.freespace=freespace;
this.size=size;
this.spaceused=spaceused;
}
public HDD(){}
     public float getFreespace() {
        return freespace;
    }

    public void setFreespace(float freespace) {
        this.freespace = freespace;
    }

    public float getSpaceused() {
        return spaceused;
    }

    public void setSpaceused(float spaceused) {
        this.spaceused = spaceused;
    }
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }


}
