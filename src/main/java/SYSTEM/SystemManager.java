/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import Collections.BST;
import Collections.SimpleLinkeList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author Fanny Brenes
 */
public class SystemManager {

    //BST<Partitions> part[];
    BST<Partitions> part = new BST<>();
    
    List< BST<Partitions>> tree = new SimpleLinkeList<>();
    BST<String> bstree = new BST<>();
    List< BST<String>> lit = new SimpleLinkeList<>();

    List<Partitions> partitions = new SimpleLinkeList<>();

    List<HDD> hdd = new SimpleLinkeList<>();
    List<TextEdition> txtedition = new SimpleLinkeList<>();

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

    public BST getTreeString() {
        return bstree;
    }

    public String getTreeString(int index) {
        String selectedtree1 = bstree.Gettreenod(index);
        return selectedtree1;
    }

    public void addNode(String text) {
        bstree.insert(text);
    }

    public String getNode(int index) {
        String t = bstree.Gettreenod(index);
        return t;

    }

    public int NodeCounter() {
        int t = bstree.nodecounter();
        return t;

    }

    public void addTree(BST<Partitions> hdd) {
        this.tree.add(hdd);
    }

    public List<BST<Partitions>> getTree() {
        return tree;
    }

    public void removeTree(int index) {
        tree.remove(index);
    }

    public void removeTreee(int index) {
        partitions.remove(index);
    }

    public BST<Partitions> getTree(int index) {
        BST<Partitions> selectedtree = tree.get(index);
        return selectedtree;
    }
    //Métodos para añadir y eliminar un elemento de tipo Order. 

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

    public void addTextEdition(TextEdition txt) {
        this.txtedition.add(txt);
    }

    public void removeTextEdition(int index) {
        txtedition.remove(index);
    }

    public List<TextEdition> getTextEdition() {
        return txtedition;
    }

    public TextEdition getTextEditor(int index) {
        TextEdition txt1 = txtedition.get(index);
        return txt1;
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

    public void createTree(String content) {

        if (content != null) {
            //
            // Remove the punctuation from the content
            //
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split(" ");
            
            for (int i = 0; i < words.length; i++) {
                bstree.insert(words[i]);
            }
        }
        

    }
    
    
    
}

    