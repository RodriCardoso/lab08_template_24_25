/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.pa.patterns.memento.model;

import java.util.*;

public class Caretaker {
    Stack<Memento> memento = new Stack<>();
    Originator originator;

    public Caretaker(Originator originator){
        this.originator = originator;
    }

    void saveState(){
        memento.push(originator.createMemento());
    }

    void restoreState(){
        if(this.memento == null){
            throw new NoMementoException("No saved memento");
        }
        this.originator.setMemento(memento.pop());
    }
}
