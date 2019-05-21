/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MyHeap() {
        heap = new ArrayList<T>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T top() {
        return heap.size() > 0 ? heap.get(0) : null;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T res = heap.get(0);
        T te = heap.get(size() - 1);
        heap.remove(size() - 1);
        int curr = 0, son = 1;
        while (son < size() - 1) {
            T ficha = heap.get(son);
            T ficha2 = heap.get(son + 1);
            T ficha3 = te;
            if (son + 1 < size() && ficha2.compareTo(ficha) < 0) {
                son++;
            }
            if (ficha3.compareTo(ficha) <= 0) {
                break;
            }
            heap.set(curr, heap.get(son));
            curr = son;
            son = 2 * curr + 1;
        }
//        heap.set(curr, te);
        return res;
    }

    public void insert(T e) {
        int curr = size();       //Tamaño del arreglo
        int parent;             //Padre del nodo
        while (curr > 0) {                     
            parent = (curr - 1) / 2;
            T ficha = e;
            T ficha2 = heap.get(parent);
            if (ficha2.compareTo(ficha) <= 0) {
                break;
            }
            heap.get(parent);
            curr = parent;
        }
        heap.add(curr, e);
    }

    public Iterator<T> iterator() {
        return heap.iterator();
    }
    
    public T getNext(){
        if (isEmpty()) {
            return null;
        }
        return heap.get(1);
    }

    @Override
    public String toString() {
        return "MyHeap{" + "heap=" + heap + '}';
    }
}