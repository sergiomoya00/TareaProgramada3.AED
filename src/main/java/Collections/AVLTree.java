/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author Fanny Brenes
 */

public class AVLTree{

    
private NodeTreeAVL root;
public AVLTree() {
    root=null;
    }
public NodeTreeAVL buscar(int d,NodeTreeAVL r){
if(root==null){
return null;
}
else if(r.object==d){
return r;
}
else if(r.object<d){
return buscar(d,r.rightson);
}
else {
return buscar(d,r.leftson);
}
}
public int obtenerfactorequilibrio(NodeTreeAVL x){
if(x==null){
return -1;
}
else {
return x.balancefactor;
}
}
public NodeTreeAVL leftrotation(NodeTreeAVL c){
NodeTreeAVL aux=c.leftson;
c.leftson=aux.rightson;
aux.rightson=c;
c.balancefactor=Math.max(obtenerfactorequilibrio(c.leftson), obtenerfactorequilibrio(c.rightson))+1;
aux.balancefactor=Math.max(obtenerfactorequilibrio(aux.leftson), obtenerfactorequilibrio(aux.rightson))+1;
return aux;
}
public NodeTreeAVL rightrotation(NodeTreeAVL c){
NodeTreeAVL aux=c.rightson;
c.rightson=aux.leftson;
aux.leftson=c;
c.balancefactor=Math.max(obtenerfactorequilibrio(c.leftson), obtenerfactorequilibrio(c.rightson))+1;
aux.balancefactor=Math.max(obtenerfactorequilibrio(aux.leftson), obtenerfactorequilibrio(aux.rightson))+1;
return aux;
}

public NodeTreeAVL doubleleftrotation(NodeTreeAVL c){
NodeTreeAVL aux;
c.leftson=rightrotation(c.leftson);
aux=leftrotation(c);
return aux;
}
public NodeTreeAVL doublerightrotation(NodeTreeAVL c){
NodeTreeAVL aux;
c.rightson=leftrotation(c.rightson);
aux=rightrotation(c);
return aux;
}
public NodeTreeAVL insertAVL(NodeTreeAVL nuevo,NodeTreeAVL subtree){
NodeTreeAVL newParent=subtree;
if(nuevo.object<subtree.object){
if(subtree.leftson==null){
subtree.leftson=nuevo;
}
else{
subtree.leftson=insertAVL(nuevo,subtree.leftson);
if((obtenerfactorequilibrio(subtree.leftson)-obtenerfactorequilibrio(subtree.rightson))==2){
  if(nuevo.object<subtree.leftson.object){
  newParent=leftrotation(subtree);
  }
  else{
   newParent=doubleleftrotation(subtree);
  }
}
}
}
else if(nuevo.object>subtree.object){
if(subtree.rightson==null){
subtree.rightson=nuevo;
}
else{
subtree.rightson=insertAVL(nuevo,subtree.rightson);
if((obtenerfactorequilibrio(subtree.rightson)-obtenerfactorequilibrio(subtree.leftson))==2){
 if(nuevo.object>subtree.rightson.object){
  newParent=rightrotation(subtree);
  }
 else{
   newParent=doublerightrotation(subtree);
  }
}
}
}
else{
System.out.print("Nodo duplcado");
}
if((subtree.leftson==null)&&(subtree.rightson!=null)){
subtree.balancefactor=subtree.rightson.balancefactor+1;
}
else if((subtree.rightson==null)&& (subtree.leftson!=null)){
subtree.balancefactor=subtree.leftson.balancefactor+1;
}
else{
subtree.balancefactor=Math.max(obtenerfactorequilibrio(subtree.leftson), obtenerfactorequilibrio(subtree.rightson))+1;

}
return newParent;
}

public void insert(int d){
NodeTreeAVL nuevo=new NodeTreeAVL(d);
if(root==null){
root=nuevo;
}
else{
root=insertAVL(nuevo,root);
}
}
public NodeTreeAVL getroot(){
return root;
}
public void ver(NodeTreeAVL r){
if(r!=null){
    ver(r.rightson);
System.out.print(r.object);
ver(r.leftson);

}
}
public void remove(int id){
root=removeAux(id,root);
}
public NodeTreeAVL removeAux(int id,NodeTreeAVL node){
if(node==null){
return null;
}
else{
if(node.getObject()<id){
node.setRightson(removeAux(id,node.getRightson()));
}
else if(node.getObject()>id){
node.setLeftson(removeAux(id,node.getLeftson()));
}
else if(node.getLeftson()==null){
node=node.getRightson();
}
else if(node.getRightson()==null){
node=node.getLeftson();
}
else if(obtenerfactorequilibrio(node.getLeftson())>obtenerfactorequilibrio(node.getRightson())){
node=rightrotation(node);
node.setLeftson(removeAux(id,node.getLeftson()));
}
else{
node=leftrotation(node);
node.setRightson(removeAux(id,node.getRightson()));
}

if(node!=null){
node.balancefactor=obtenerfactorequilibrio(node.getLeftson())+obtenerfactorequilibrio(node.getRightson());
}
}
return  node;
}

}

