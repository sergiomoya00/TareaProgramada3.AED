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
public class Partitions implements Comparable<Partitions> {

    int quantity;
    float size;
    FileSystem file;

    String root;

    public Partitions(int quantity, String root, float size) {
        this.quantity = quantity;
        this.root = root;
        this.size = size;
    }

    public Partitions(int quantity, String root, float size, FileSystem file) {
        this.quantity = quantity;
        this.root = root;
        this.size = size;
        this.file = file;
    }

    public Partitions() {
    }

    public FileSystem getFile() {
        return file;
    }

    public void setFile(FileSystem file) {
        this.file = file;
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

    @Override
    public int compareTo(Partitions o) {
        if (SystemManager.getInstance().getTree().size() > SystemManager.getInstance().getTree(0).nodecounter()) {
            return -1;
        } else if (SystemManager.getInstance().getTree().size() < SystemManager.getInstance().getTree(0).nodecounter()) {
            return 1;
        } else {
            return 0;
        }
    }

}
