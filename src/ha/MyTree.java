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
 * @param <K> Type of Keys
 * @param <T> Type of Values
 */
public class MyTree<K extends Comparable<K>, T> implements de.tu_bs.ips.Tree, Comparable<K>{
    
    private K parentKey;
    private T parentValue;
    private MyTree leftchild;
    private MyTree rightchild;

    public MyTree(K Key, T Value){
        this.parentKey = Key;
        this.parentValue = Value;
    }
    
    public K getParentKey() {
        return this.parentKey;
    }

    public void setParentKey(K parentKey) {
        this.parentKey = parentKey;
    }

    public T getParentValue() {
        return this.parentValue;
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
        return this.parentKey == null;
    }

    @Override
    public int size() {
        if(!this.isEmpty()){
            return 1 + (this.getLeftchild() != null ? this.getLeftchild().size() : 0) + (this.getRightchild() != null ? this.getRightchild().size() : 0);
        }else{
            return 0;
        }
    }

    @Override
    public Object get(Comparable key) {
        if(!this.isEmpty()){
            int currentCompare = this.getParentKey().compareTo((K) key);
            if(currentCompare == 0){
                return this.parentValue;
            }else if(currentCompare > 0){
                return (this.getLeftchild() != null ? this.getLeftchild().get((K) key) : null);
            }else{
                return (this.getRightchild() != null ? this.getRightchild().get((K) key) : null);
            }
        }else{
            return null;
        }
    }
    
    @Override
    public boolean containsKey(Comparable key) {
        if(!this.isEmpty()){
            int currentCompare = this.getParentKey().compareTo((K) key);
            if(currentCompare == 0){
                return true;
            }else if(currentCompare > 0){
                return (this.getLeftchild() != null ? this.getLeftchild().containsKey((K) key) : false);
            }else{
                return (this.getRightchild() != null ? this.getRightchild().containsKey((K) key) : false);
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        if(!this.isEmpty()){
            if(this.getParentValue().equals(value)){
                return true;
            }else{
                Boolean existsInLeft = (this.getLeftchild() != null ? this.getLeftchild().containsValue(value) : false);
                Boolean existsInRight = (this.getLeftchild() != null ? this.getLeftchild().containsValue(value) : false);
                return (existsInLeft != false || existsInRight != false);
            }
        }else{
            return false;
        }
    }

    @Override
    public Object put(Comparable key, Object value) {
        if(!this.isEmpty()){
            int currentCompare = this.getParentKey().compareTo((K) key);
            if(currentCompare == 0){
                return null;
            }else if(currentCompare > 0){
                if(this.getLeftchild() != null){
                    return this.getLeftchild().put(key, value);
                }else{
                    MyTree InsertTree = new MyTree((K) key,(T) value);
                    this.setLeftchild(InsertTree);
                    return value;
                }
            }else{
                if(this.getRightchild() != null){
                    return this.getRightchild().put(key, value);
                }else{
                    MyTree InsertTree = new MyTree((K) key,(T) value);
                    this.setRightchild(InsertTree);
                    return value;
                }
            }
        }else{
            this.setParentKey((K) key);
            this.setParentValue((T) value);
            return value;
        }
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

    /**
     * Compare Trees' Parent Keys
     * @param t
     * @return 
     */
    @Override
    public int compareTo(K t) {
        MyTree tree = (MyTree) t;
        return this.parentKey.compareTo((K) tree.getParentKey());
    }    
}