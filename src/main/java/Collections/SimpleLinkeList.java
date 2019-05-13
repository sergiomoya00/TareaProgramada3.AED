/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleLinkeList<T> implements List<T> {

    NodeSimpleLinkedList<T> head;
    private int size;
    
    

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            
            NodeSimpleLinkedList<T> current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
               T result = current.getValue();
               current = current.getNext();
               return result;
            }
        };
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        this.add(size(), e);
        return true;
    }

    @Override
    public boolean remove(Object o) {

        NodeSimpleLinkedList current = this.head;

        if (this.head == null) {
            return false;
        }
        
        if (this.head.getValue().equals(o)){
            size--;
            head = current.getNext();
            return true;
        }

        while (current.getNext() != null && !current.getNext().value.equals(o)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());

        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);

        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        size = 0;
        head = null;

    }

    
    public T get(int index) {
        NodeSimpleLinkedList<T> current = head;
        while (index-- > 0) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public T set(int index, T element) {
        NodeSimpleLinkedList<T> current = head;
        while (index-- > 0) {
            current = current.getNext();

        }
        T previous = current.getValue();
        current.setValue(element);
        return previous;
    }

    @Override
    public void add(int index, T element) {
        NodeSimpleLinkedList<T> current = this.head;
        NodeSimpleLinkedList<T> newNode = new NodeSimpleLinkedList<T>(null, element);

        if (isEmpty()) {
            this.head = newNode;

        } else {
            if (size == 0) {
                this.head = newNode;
                newNode.setNext(current);
            } else {

                NodeSimpleLinkedList<T> previous = current;
                current = previous.getNext();

                while (--index > 0) {
                    previous = current;
                    current = previous.getNext();

                }

                previous.setNext(newNode);
                newNode.setNext(current);

            }
        }
        size++;

    }

    @Override
    public T remove(int index) {
        
        
        NodeSimpleLinkedList<T> current = head;
        
        if (index == 0){
            head = current.getNext();
            size --;
            return current.value;
        }
        
        while (--index > 0) {
            current = current.getNext();

        }

        if (current.getNext() == null) {
            return null;
        }

        T oldValue = current.getNext().value;

        current.setNext(current.getNext().getNext());

        size--;
        return oldValue;

    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
