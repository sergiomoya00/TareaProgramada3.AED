
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import Collections.BST;
import GUI.EditorTxt;
import GUI.Ventanainicial;

/**
 *
 * @author chech
 */
public class TextEdition implements Comparable<TextEdition> {

    private String text;

    public TextEdition() {
    }

    public TextEdition(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(TextEdition t) {
        if (this.getText() == "cac") {
            return -1;
        } else if (this.getText() == "ff") {
            return 1;
        } else {
            return 0;
        }
    }

}

/*NewTree.InsertarNodo();
        countSize==0;
        while(countS!=NewTree.){
        for (int countS=0, countS == NewTree.preOrder(), countS ++) {
            Object WordS = NewTree.buscarNodo(jTextField1.getText());
            int CountW = 0;
            if (WordS == (jTextField1).getText()) {
                CountW++;
 */
