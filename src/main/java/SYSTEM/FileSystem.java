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
public class FileSystem {

    private String name="null";
    private float size;

    public FileSystem(String name, float size) {
        this.name = name;
        this.size = size;
    }

    public FileSystem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public float getSize(){
        return size;
    }
    
    public void setSize(float size) {
        this.size = size;
    }

}
