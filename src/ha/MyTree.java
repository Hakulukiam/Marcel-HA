/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

import java.util.Iterator;
/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class MyTree<K extends Comparable<K>, T> implements de.tu_bs.ips.Tree, Comparable<T>{
    
    private K parentKey;
    private T parentValue;
    private MyTree leftchild;
    private MyTree rightchild;

    public K getParentKey() {
        return this.parentKey;
    }

    public void setParentKey(K parentKey) {
        this.parentKey = parentKey;
    }

    public T getParentValue() {
        return parentValue;
    }

    public void setParentValue(T parentValue) {
        this.parentValue = parentValue;
    }
    
    public MyTree getLeftchild() {
        return this.leftchild;
    }
    
    public void setLeftchild(MyTree leftchild) {
        this.leftchild = leftchild;
    }

    public MyTree getRightchild() {
        return this.rightchild;
    }

    public void setRightchild(MyTree rightchild) {
        this.rightchild = rightchild;
    }    
    
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Comparable key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Comparable key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object put(Comparable key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(Comparable key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object replace(Comparable key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
