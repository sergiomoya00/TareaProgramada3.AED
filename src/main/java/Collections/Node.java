/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author Shirley
 */
class Node<T> {
    
    T element;
    private Node next;
    private Node previous;

    public Node() {
        this.element = null;
        this.next = null;
        this.previous = null;
    }

    public Node(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public Node(T element, Node previous, Node next) {
        this.element = element;
        this.previous = previous;
        this.next = next;

    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}


