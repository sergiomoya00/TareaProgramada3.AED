/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import SYSTEM.Partitions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<X extends Comparable<X>> implements Iterable<X> {
	/**
	 * Al ser recursivo es totalmente necesario que el nodo se encuentre dentro de la clase
	 * Debido a que debe tener acceso directo a los parámetros de memoria dentro del código
	 * @author jearo
	 *
	 * @param <X>
	 */
	@SuppressWarnings("hiding")
	

        //NODO PARA LOS ELEMENTOS DEL ÁRBOL (ROOT Y COMPARATOR)
        private class Node<X> {
		private X elemento;
		private Node<X> izq, der;

		public Node(X data, Node<X> izq, Node<X> der) {
			this.izq = izq;
			this.der = der;
			this.elemento = data;
		}

		public Node(X data) {
			this(data, null, null);
		}

		public String toString() {
			return elemento.toString();
		}
	}
	
	/**
	 * Atributos de la clase Árbol
	 */
	private Node<X> raiz;
	private Comparator<X> comparator;

	public Node<X> getRoot() {
		return raiz;
	}

	public void setRoot(Node<X> root) {
		this.raiz = root;
	}

	public Comparator<X> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<X> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Constructir de la clase
	 */
	public BinarySearchTree() {
		raiz = null;
		comparator = null;
	}

	public BinarySearchTree(Comparator<X> comp) {
		raiz = null;
		comparator = comp;
	}

        
        //COMPARA LOS ELEMENTOS PARA VER DONDE SE INSERTA EL NUEVO ELEMENTO
	private int compare(X elemA, X elemB) {
		if (comparator == null)
			return elemA.compareTo(elemB);
		else
			return comparator.compare(elemA, elemB);
	}

	/**
	 * Insertar
	 * 
	 * @param data
	 */
        
        //PARA INSERTAR Y ALAMACENAR EL DATO   //ESTE ES EL QUE SE TIENE QUE LLAMAR EN EL MANAGER
	public void insertarNodo(X data) {
		raiz = insert(raiz, data);
	}

        
        //PARA DETERMINAR LA POSICIÓN 
	private Node<X> insert(Node<X> nuevoNodo, X nodoInsertado) {
		if (nuevoNodo == null)
			return new Node<X>(nodoInsertado);

		if (compare(nodoInsertado, nuevoNodo.elemento) == 0)
			return nuevoNodo;

		if (compare(nodoInsertado, nuevoNodo.elemento) < 0)
			nuevoNodo.izq = insert(nuevoNodo.izq, nodoInsertado);
		else
			nuevoNodo.der = insert(nuevoNodo.der, nodoInsertado);

		return nuevoNodo;
	}

	/**
	 * Buscar
	 * 
	 * @param toSearch
	 * @return
	 */
        //PARA BUSCAR UN ELEMENTO DE TIPO GÉNERICO. //ESTE ES EL QUE SE PONE EN MANAGER
	public boolean buscarNodo(X toSearch) {
		return search(raiz, toSearch);
	}
        
        
        //PARA UTILIZAR EL COMPARATOR Y ENCONTAR EL ELEMENTO DESEADO
	private boolean search(Node<X> p, X toSearch) {
		if (p == null)
			return false;
		else if (compare(toSearch, p.elemento) == 0)
			return true;
		else if (compare(toSearch, p.elemento) < 0)
			return search(p.izq, toSearch);
		else
			return search(p.der, toSearch);
	}
        
        
        public X getNode(X element){
            return searchGetNode(raiz, element);
        }

	private X searchGetNode(Node<X> p, X toSearch) {
		if (p == null)
			return null;
		else if (compare(toSearch, p.elemento) == 0)
			return p.elemento;
		else if (compare(toSearch, p.elemento) < 0)
			return searchGetNode(p.izq, toSearch);
		else
			return searchGetNode(p.der, toSearch);
	}

	/**
	 * Eliminar
	 * 
	 * @param eliminarNodo
	 */
        
        
        //PARA ELIMINAR UN ELEMENTO, ESTA ES LA FUNCIÓN QUE SE LLAMA EN EL MANAGER
	public void eliminarNodo(X eliminarNodo) {
		raiz = delete(raiz, eliminarNodo);
	}
        
        //FUNCION AUXILIAR DEL BORRADO DEL ELEMENTO
	private Node<X> delete(Node<X> nodoTemp, X nodoElim) {
		if (nodoTemp == null)
			throw new RuntimeException("cannot delete.");
		else if (compare(nodoElim, nodoTemp.elemento) < 0)
			nodoTemp.izq = delete(nodoTemp.izq, nodoElim);
		else if (compare(nodoElim, nodoTemp.elemento) > 0)
			nodoTemp.der = delete(nodoTemp.der, nodoElim);
		else {
			if (nodoTemp.izq == null)
				return nodoTemp.der;
			else if (nodoTemp.der == null)
				return nodoTemp.izq;
			else {
				// Obtiene los datos por el lado derecho
				nodoTemp.elemento = obtenerDato(nodoTemp.izq);
				// Obtiene los datos del lado izquierdo
				nodoTemp.izq = delete(nodoTemp.izq, nodoTemp.elemento);
			}
		}
		return nodoTemp;
	}
        
        //PARA OBTENER UN DATO
	private X obtenerDato(Node<X> p) {
		while (p.der != null)
			p = p.der;

		return p.elemento;
	}

	/**
	 * TO STRING
	 */
	public String toString(int index) {
                
		StringBuffer sb = new StringBuffer();
		for (X data : this)
                    sb.append(data.toString());
          
                    
			

		return sb.toString();
	}
       public Partitions Gettreenode(int index) {
                Partitions partition = null;
		StringBuffer sb = new StringBuffer();
		for (X data : this)
                    for(int i=0;i<=index;i++){
                    sb.append(data.toString());
                    partition=(Partitions) data;
                    }
			

		return partition;
	}
       public int nodecounter() {
                int counter=0;
		StringBuffer sb = new StringBuffer();
		for (X data : this){
                    sb.append(data.toString());
                    counter=counter+1;}
                    
			

		return counter;
	}
	/**
	 * PreordenS
	 */
        //RECORRIDO PREORDEN
	public void preOrder() {
		preOrderHelper(raiz);
	}
        
        //RECORRIDO PREORDEN
	private void preOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			System.out.print(nodoTemp + " ");
			preOrderHelper(nodoTemp.izq);
			preOrderHelper(nodoTemp.der);
		}
	}

	/**
	 * En orden
	 */
	public void inOrder() {
		inOrderHelper(raiz);
	}

	private void inOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			inOrderHelper(nodoTemp.izq);
			System.out.print(nodoTemp + " ");
			inOrderHelper(nodoTemp.der);
		}
	}

	/**
	 * Post Orden
	 */
	public void posOrder() {
		postOrderHelper(raiz);
	}

	private void postOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			inOrderHelper(nodoTemp.izq);
			inOrderHelper(nodoTemp.der);
			System.out.print(nodoTemp + " ");
		}
	}

	/**
	 * Clonado
	 */
        //UNA CLONACIÓN RARA QUE SE SACÓ ESE HP DEL CULO
	public BinarySearchTree<X> clone() {
		BinarySearchTree<X> twin = null;

		if (comparator == null)
			twin = new BinarySearchTree<X>();
		else
			twin = new BinarySearchTree<X>(comparator);

		twin.raiz = cloneHelper(raiz);
		return twin;
	}

	private Node<X> cloneHelper(Node<X> p) {
		if (p == null)
			return null;
		else
			return new Node<X>(p.elemento, cloneHelper(p.izq), cloneHelper(p.der));
	}

	/**
	 * Altura del árbol
	 * 
	 * @return
	 */
        
        //ALTURA DEL ÁRBOL
	public int height() {
		return height(raiz);
	}

	private int height(Node<X> p) {
		if (p == null)
			return -1;
		else
			return 1 + Math.max(height(p.izq), height(p.der));
	}

	/**
	 * Contar las horas del árbol
	 * 
	 * @return
	 */
        //CONTAR LAS HOJAS
	public int countLeaves() {
		return countLeaves(raiz);
	}
        
	private int countLeaves(Node<X> p) {
		if (p == null)
			return 0;
		else if (p.izq == null && p.der == null)
			return 1;
		else
			return countLeaves(p.izq) + countLeaves(p.der);
	}

	/**
	 * Restaura el árbol en orden y preorden
	 * 
	 * @param pre
	 * @param in
	 */
        
        //RESTAURAR EL ÁRBOL EN ORDEN Y EN PREORDEN
	public void restore(X[] pre, X[] in) {
		raiz = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node<X> restore(X[] pre, int preL, int preR, X[] in, int inL, int inR) {
		if (preL <= preR) {
			int count = 0;
			// find the root in the inorder array
			while (pre[preL] != in[inL + count])
				count++;

			Node<X> tmp = new Node<X>(pre[preL]);
			tmp.izq = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
			tmp.der = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
			return tmp;
		} else
			return null;
	}

	/**
	 * Corresponde al máximo número de elementos en un nivel del árbol
	 * 
	 * @return
	 */
        
        ///ANCHURA DEL ÁRBOL
	public int width() {
		int max = 0;
		for (int k = 0; k <= height(); k++) {
			int tmp = width(raiz, k);
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	/**
	 * Retorna el número de nodos de un determinado nivel
	 * 
	 * @param p
	 * @param depth
	 * @return
	 */
       
	public int width(Node<X> p, int depth) {
		if (p == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(p.izq, depth - 1) + width(p.der, depth - 1);
	}

	/**
	 * El diametro del árbol es el número de nodos El camino más largo entre dos
	 * hojas
	 * 
	 * @return
	 */
        
        // CAMINO MÁS LARGO ENTRE TODAS LAS HOJAS
	public int diameter() {
		return diameter(raiz);
	}

	private int diameter(Node<X> p) {
		if (p == null)
			return 0;

		// El camino va por la raíz
		int len1 = height(p.izq) + height(p.der) + 3;

		// El camino no pasa por la raíz
		int len2 = Math.max(diameter(p.izq), diameter(p.der));

		return Math.max(len1, len2);
	}

	public Iterator<X> iterator() {
		return new IteradorBST();
	}

	// pre-order
	private class IteradorBST implements Iterator<X> {
		Stack<Node<X>> stk = new Stack<Node<X>>();

		public IteradorBST() {
			if (raiz != null)
				stk.push(raiz);
		}

		public boolean hasNext() {
			return !stk.isEmpty();
		}

		public X next() {
			Node<X> cur = stk.peek();
			if (cur.izq != null) {
				stk.push(cur.izq);
			} else {
				Node<X> tmp = stk.pop();
				while (tmp.der == null) {
					if (stk.isEmpty())
						return cur.elemento;
					tmp = stk.pop();
				}
				stk.push(tmp.der);
			}

			return cur.elemento;
		}

		public void remove() {

		}
	}
}