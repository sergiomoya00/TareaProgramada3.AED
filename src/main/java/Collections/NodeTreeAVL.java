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
public class NodeTreeAVL {
int object, balancefactor;
    NodeTreeAVL leftson;
    NodeTreeAVL rightson;

    public NodeTreeAVL getLeftson() {
        return leftson;
    }

    public void setLeftson(NodeTreeAVL leftson) {
        this.leftson = leftson;
    }

    public int getObject() {
        return object;
    }

    public void setObject(int object) {
        this.object = object;
    }

    public int getBalancefactor() {
        return balancefactor;
    }

    public void setBalancefactor(int balancefactor) {
        this.balancefactor = balancefactor;
    }

    public NodeTreeAVL getRightson() {
        return rightson;
    }

    public void setRightson(NodeTreeAVL rightson) {
        this.rightson = rightson;
    }
    public NodeTreeAVL() {
    }
    public NodeTreeAVL(int object) {
        this.object=object;
        this.balancefactor=0;
        this.leftson=null;
        this.rightson=null;
    }
  

   
}
