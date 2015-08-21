
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Naeem
 */
public class Tree<T> implements Iterable<Tree<T>> {

    T data;
    Tree<T> parent;
    List<Tree> children;

    Tree(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public Tree<T> addChild(T child) {
        Tree newborn = new Tree<>(child);
        newborn.parent = this;
        this.children.add(newborn);
        return newborn;
    }

    @Override
    public Iterator iterator() {
        return this.children.listIterator();
    }

    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("{ \"text\" : \"").append(this.data.toString()).append("\" ");
        if (this.children != null && !children.isEmpty()) {
            Iterator vIter = this.children.listIterator();
            retval.append(", \"children\" : [ ");
            while (vIter.hasNext()) {
                Tree<T> child = (Tree<T>) vIter.next();
                retval.append(child.toString()).append(vIter.hasNext()?",":"");
            }
            retval.append("]");
        }
        retval.append("}");
        return retval.toString();
    }

    /*    class TreeIterator implements Iterator<T>{

     @Override
     public boolean hasNext() {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public T next() {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
        
     }
    
     */

}
