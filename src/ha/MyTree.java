/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

import java.util.HashSet;
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
    private MyTree root;

    public MyTree(){
        this.parentKey = null;
        this.parentValue = null;
        this.root = null;
    }
    
    public MyTree(K Key, T Value){
        this.parentKey = Key;
        this.parentValue = Value;
        this.root = null;
    }
    
    public MyTree(K Key, T Value, MyTree root){
        this.parentKey = Key;
        this.parentValue = Value;
        this.root = root;
    }

    public MyTree getRoot() {
        return this.root;
    }

    public void setRoot(MyTree root) {
        this.root = root;
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
    
    public MyTree getBiggestChild(){
        if(!this.isEmpty()){            
            return (this.getRightchild() != null ? this.getRightchild().getBiggestChild() : this);
        }else{
            return null;
        }
    }
    
    public MyTree getSmallestChild(){
        if(!this.isEmpty()){            
            return (this.getLeftchild() != null ? this.getLeftchild().getSmallestChild() : this);
        }else{
            return null;
        }
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
                    MyTree InsertTree = new MyTree((K) key,(T) value, this);
                    this.setLeftchild(InsertTree);
                    return value;
                }
            }else{
                if(this.getRightchild() != null){
                    return this.getRightchild().put(key, value);
                }else{
                    MyTree InsertTree = new MyTree((K) key,(T) value, this);
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
        if(!this.isEmpty()){
            int currentCompare = this.getParentKey().compareTo((K) key);
            if(currentCompare == 0){
                Boolean master = (this.root == null);   //0 - Ermitteln ob wir die Oberste Wurzel sind
                int childPos = (master == false ? this.compareTo((K) this.root.getLeftchild()) : null); //1 - Ermitteln ob wir rechtes oder linkes Kind sind
                
                if(this.getLeftchild() == null){    //2a - Ich habe kein Linkes Kind                   
                    if(this.getRightchild() == null){ //3a - Ich habe keine Kinder
                        if(childPos > 0 && master == false){ 
                            this.root.setRightchild(null); //4a - Beim Vater Rechtes Kind löschen
                        }else{
                            this.root.setLeftchild(null); //4b - Beim Vater Linkes Kind löschen
                        }
                        this.setRoot(null); //4c - Wurzel löschen 
                        return this.getParentValue();
                    }else{ // 3b ich habe ein Rechtes Kind
                        this.getRightchild().setRoot(this.getRoot()); //4 - Wurzel neu Setzen     
                        if(childPos > 0 && master == false){ 
                            this.root.setRightchild(this.getRightchild()); //5a - Beim Vater mein rechtes Kind als neues Rechtes Kind setzten
                        }else{
                            this.root.setLeftchild(this.getRightchild()); //5b - Beim Vater mein rechtes Kind als neues Linkes Kind setzten
                        }
                        return this.getParentValue();
                    }
                }else{ //2b - Ich habe ein Linkes Kind
                    if(this.getRightchild() == null){ //3a - Ich habe kein Rechtes Kind
                       this.getLeftchild().setRoot(this.getRoot()); //4 - Wurzel neu Setzen                   
                       if(childPos > 0 && master == false){ 
                            this.root.setRightchild(this.getLeftchild()); //5a - Beim Vater mein linkes Kind als neues Rechtes Kind setzten
                        }else{
                            this.root.setLeftchild(this.getLeftchild()); //5b - Beim Vater mein linkes Kind als neues Linkes Kind setzten
                        } 
                        return this.getParentValue();                       
                    }else{ // 3b ich habe ein Rechtes und ein Linkes Kind
                        this.getLeftchild().setRoot(this.getRoot()); //4 - Wurzel neu Setzen                   
                        if(childPos > 0 && master == false){ 
                            this.root.setRightchild(this.getLeftchild()); //5a - Beim Vater mein linkes Kind als neues Rechtes Kind setzten
                        }else{
                            this.root.setLeftchild(this.getLeftchild()); //5b - Beim Vater mein linkes Kind als neues Linkes Kind setzten
                        }
                        this.getLeftchild().getBiggestChild().setRightchild(this.getRightchild()); //6 - Rechtes Kind des größten Linken Kindes setzten
                        this.getRightchild().setRoot(this.getLeftchild().getBiggestChild()); //7 - Wurzel vom Rechten Kind auf größtes Linkes Kind setzten                       
                        return this.getParentValue();
                    }
                }                
            }else if(currentCompare > 0){
                return (this.getLeftchild() != null ? this.getLeftchild().remove((K) key) : null);
            }else{
                return (this.getRightchild() != null ? this.getRightchild().remove((K) key) : null);
            }
        }else{
            return null;
        }
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
    public String toString(){
        if(!this.isEmpty()){
            return "Tree is not Empty";
        }else{
            return "Tree is Empty";
        }       
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