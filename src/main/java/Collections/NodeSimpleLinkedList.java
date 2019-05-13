/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;


public class NodeSimpleLinkedList<T> {
    NodeSimpleLinkedList <T> next;
    T value;

    public NodeSimpleLinkedList(NodeSimpleLinkedList<T> next, T value) {
        this.next = next;
        this.value = value;
    }
    public NodeSimpleLinkedList(T value) {
        this.next = null;
        this.value = value;
    }
    public NodeSimpleLinkedList() {
       this.value=null;
       this.next=null;
    }

    public NodeSimpleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(NodeSimpleLinkedList<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
    
}
