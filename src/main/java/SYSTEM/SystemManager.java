/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import Collections.BinarySearchTree;
import Collections.SimpleLinkeList;
import Collections.DoubleLinkedList;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Fanny Brenes
 */
public class SystemManager {
    
    
    
    BinarySearchTree<Partitions> part[];
     
    List<Partitions> partitions = new SimpleLinkeList<>();
    List<HDD> hdd = new SimpleLinkeList<>();

    public static SystemManager instance;

    public static final SystemManager getInstance() {
        return instance;
    }

    static {
        instance = new SystemManager();
        instance.partitions.add(new Partitions() {
            {
                setRoot("hola");
                setQuantity(2);

            }

        });
    instance.partitions.clear();
    }
    
   public void NumberofTrees(){
    
    part[0] =new BinarySearchTree<>();
   }

    //Métodos para añadir y eliminar un elemento de tipo Order. 
    public boolean addPart(Partitions partition) {
        
        this.part[0].insertarNodo(partition);
        return true;
    }
    public boolean treeisempty(){
    
    boolean factor = false;
    if(this.part[0].height()>-1){
    factor=false;
    }
    if(this.part[0].height()==-1){
    factor=true;
    }
    return factor;
    }
    public int nodecounter(){
    
    int count=this.part[0].nodecounter();
    return count;
    }
    public boolean verifyPartition(Partitions searchTo) { 
        //Search Node
        if (part[0].buscarNodo(searchTo)) {
            return true;
        }
        return false;
    }
    public Partitions getPart(int index){
     
    return part[0].Gettreenode(index);
    }
    //Método para obtener todos los elementos de la lista Order.
    public Partitions getPartition(Partitions partitionToGet) {
         
        return part[0].getNode(partitionToGet);
    }

    public Partitions deleteParts(Partitions partitionToDelete) {
         
        if (verifyPartition(partitionToDelete)) {
            part[0].eliminarNodo(partitionToDelete);
        }
        return null;
    }

    public void addPartition(Partitions partition) {
        this.partitions.add(partition);
    }

    public void removePartition(Partitions partition) {
        this.partitions.remove(partition);
    }

    public List<Partitions> getPartition() {
        return partitions;
    }

    public void addHDD(HDD hdd) {
        this.hdd.add(hdd);
    }

    public void removeHDD(int index) {
        hdd.remove(index);
    }

    public void removePartition(int index) {
        partitions.remove(index);
    }

    public List<HDD> getHDD() {
        return hdd;
    }

    public HDD getHDD(int index) {
        HDD hdds = hdd.get(index);
        return hdds;
    }

    public Partitions getPartition(int index) {
        Partitions partition = partitions.get(index);
        return partition;
    }
}
