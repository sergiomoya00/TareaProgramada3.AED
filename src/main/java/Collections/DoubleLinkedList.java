package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoubleLinkedList<T> implements List<T>{

    private Node<T> head;
    private Node<T> current;
    private Node<T> tail;
    private int position;
    private int size;

    public DoubleLinkedList() {
        this.head = new Node<T>();
        this.current = this.head;
        this.tail = this.head;
        this.size = 0;
        this.position = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
            return new Iterator<T>(){
            
            Node<T> current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
               T result = current.getElement();
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
        
        Node current = this.head;

        if (this.head == null) {
            return false;
        }
        
        if (this.head.getElement().equals(o)){
            size--;
            head = current.getNext();
            return true;
        }

        while (current.getNext() != null && ! current.getNext().getElement().equals(o)) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        Node<T> current = this.head;
        Node<T> newNode = new Node<T>(element);

        if (isEmpty()) {
            this.head = newNode;

        } else {
            if (size == 0) {
                this.head = newNode;
                newNode.setNext(current);
            } else {

                Node<T> previous = current;
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
        
        Node<T> current = head;
        
        if (index == 0){
            head = current.getNext();
            size --;
            return current.element;
        }
        
        while (--index > 0) {
            current = current.getNext();

        }

        if (current.getNext() == null) {
            return null;
        }

        T oldValue = (T) current.getNext().element;

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