/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import Collections.BinarySearchTree;

import Collections.SimpleLinkeList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Fanny Brenes
 */
public class SystemManager {

    BinarySearchTree<Partitions> part= new BinarySearchTree<>();
    List< BinarySearchTree<Partitions>> tree = new SimpleLinkeList<>();
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
        //instance.partitions.clear();
    }

      public void addTree( BinarySearchTree<Partitions> hdd) {
        this.tree.add(hdd);
    }

    public void removeTree(int index) {
        tree.remove(index);
    }

    public void removeTreee(int index) {
        partitions.remove(index);
    }

    public List<HDD> getTree() {
        return hdd;
    }

    public HDD getTree(int index) {
        HDD hdds = hdd.get(index);
        return hdds;
    }
    //Métodos para añadir y eliminar un elemento de tipo Order. 
    public boolean addPart(Partitions partition) {
        
        part.insertarNodo(partition);
        return true;
    }

    public void addPartition(Partitions partition) {
        this.partitions.add(partition);

    }

    public boolean treeisempty() {

        boolean factor = false;
        if (this.part.height() > -1) {
            factor = false;
        }
        if (this.part.height() == -1) {
            factor = true;
        }
        return factor;
    }

    public void removePartition(Partitions partition) {
        this.partitions.remove(partition);

    }

    public int nodecounter() {

        int count = this.part.nodecounter();
        return count;
    }

    public boolean verifyPartition(Partitions searchTo) {
        //Search Node
        if (part.buscarNodo(searchTo)) {
            return true;
        }
        return false;
    }

    public Partitions getPart(int index) {

        return part.Gettreenode(index);
    }

    //Método para obtener todos los elementos de la lista Order.
    public Partitions getPartition(Partitions partitionToGet) {
        return part.getNode(partitionToGet);
    }

    public Partitions deleteParts(Partitions partitionToDelete) {

        if (verifyPartition(partitionToDelete)) {
            part.eliminarNodo(partitionToDelete);
        }
        return null;
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
    
    public Collection<Partitions> searchRaffle(Partitions newPartition) {

        List<Partitions> results = new ArrayList<>();

        boolean byName = newPartition.getRoot() != null && newPartition.getRoot().length() > 0;

        for (Partitions part : partitions) {
            boolean add = !(byName);
            if (!add && byName && part.getRoot().contains(newPartition.getRoot())) {
                add = true;
            }
            if (add) {
                results.add(part);
            }
        }
        return results;

    }

}
