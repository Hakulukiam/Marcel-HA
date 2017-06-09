/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
    private MyTree masterRoot;
    private de.tu_bs.ips.MyList Branches;

    public MyTree(){
        this.parentKey = null;
        this.parentValue = null;
        this.root = null;
        this.masterRoot = this;
        this.Branches = new de.tu_bs.ips.MyList();
    }
    
    public MyTree(K Key, T Value){
        this.parentKey = Key;
        this.parentValue = Value;
        this.root = null;
        this.masterRoot = this;
        this.Branches = new de.tu_bs.ips.MyList();
    }
    
    public MyTree(K Key, T Value, MyTree root){
        this.parentKey = Key;
        this.parentValue = Value;
        this.root = root;
    }
    
   /* public de.tu_bs.ips.MyList getBranches(){
        return this.Branches;
    }*/
    
   /* public MyTree getmasterRoot() {
        return this.masterRoot;
    }*/

    public void setmasterRoot(MyTree root) {
        this.masterRoot = root;
    }
    
   /* public MyTree getRoot() {
        return this.root;
    }*/

    public void setRoot(MyTree root) {
        this.root = root;
    }
    
    /*public K getParentKey() {
        return this.parentKey;
    }*/

    public void setParentKey(K parentKey) {
        this.parentKey = parentKey;
    }

    /*public T getParentValue() {
        return this.parentValue;
    }*/

    public void setParentValue(T parentValue) {
        this.parentValue = parentValue;
    }
    
    /*public MyTree getLeftchild() {
        return this.leftchild;
    }*/
    
    public void setLeftchild(MyTree leftchild) {
        this.leftchild = leftchild;
    }

    /*public MyTree getRightchild() {
        return this.rightchild;
    }*/

    public void setRightchild(MyTree rightchild) {
        this.rightchild = rightchild;
    }
    
    public MyTree getElement(Comparable key) {
        if(!this.isEmpty()){
            int currentCompare = this.parentKey.compareTo((K) key);
            if(currentCompare == 0){
                return this;
            }else if(currentCompare > 0){
                return (this.leftchild != null ? this.leftchild.getElement((K) key) : null);
            }else{
                return (this.rightchild != null ? this.rightchild.getElement((K) key) : null);
            }
        }else{
            return null;
        }
    }
    
    public MyTree getBiggestChild(){
        if(!this.isEmpty()){            
            return (this.rightchild != null ? this.rightchild.getBiggestChild() : this);
        }else{
            return null;
        }
    }
    
    public MyTree getSmallestChild() {
        if (!this.isEmpty()){            
            return (this.leftchild != null ? this.leftchild.getSmallestChild() : this);
        } else {
            return null;
        }
    }
    
    public String printSortedKeys(MyTree currentElement, MyTree lastElement, String SortedKeys) {
        if (!this.isEmpty()) {                                               
                if (this.getBiggestChild().compareTo(currentElement) == 0) { //Letztes Element
                    return SortedKeys + currentElement.parentKey + " -> " + currentElement.parentValue + "\n";
                }    
                    
                if (currentElement.compareTo(lastElement) >= 0) { // Element ist das nächste
                    SortedKeys = SortedKeys + currentElement.parentKey + " -> " + currentElement.parentValue + "\n";
                }                    
                    
                if (currentElement.rightchild != null && currentElement.rightchild.compareTo(lastElement) > 0) { //2 - Wenn rechtes Kind 
                    return this.printSortedKeys(currentElement.rightchild.getSmallestChild(), currentElement, SortedKeys); //JA -> getSmallest am rechten Kind ist nächstes element                     
                } else {
                    return this.printSortedKeys(currentElement.root,currentElement,SortedKeys); //Nein -> geh die Wurzel Rauf
                }      
            } else {
                return "Tree is Empty";
        }
    }
                
    @Override
    public boolean isEmpty() {
        return this.parentKey == null;
    }

    @Override
    public int size() {
        if (!this.isEmpty()) {
            return 1 + (this.leftchild != null ? this.leftchild.size() : 0) + (this.rightchild != null ? this.rightchild.size() : 0);
        }else{
            return 0;
        }
    }

    @Override
    public Object get(Comparable key) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                return this.parentValue;
            } else if(currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.get((K) key) : null);
            } else {
                return (this.rightchild != null ? this.rightchild.get((K) key) : null);
            }
        } else {
            return null;
        }
    }
    
    @Override
    public boolean containsKey(Comparable key) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                return true;
            } else if(currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.containsKey((K) key) : false);
            } else {
                return (this.rightchild != null ? this.rightchild.containsKey((K) key) : false);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        if (!this.isEmpty()) {
            if (this.parentValue.equals(value)) {
                return true;
            } else {
                Boolean existsInLeft = (this.leftchild != null ? this.leftchild.containsValue(value) : false);
                Boolean existsInRight = (this.rightchild != null ? this.rightchild.containsValue(value) : false);
                return (existsInLeft != false || existsInRight != false);
            }
        } else {
            return false;
            }
    }

    @Override
    public Object put(Comparable key, Object value) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                return null;
            } else if (currentCompare > 0) {
                if (this.leftchild != null) {
                    return this.leftchild.put(key, value);
                } else {
                    MyTree InsertTree = new MyTree((K) key,(T) value, this);
                    InsertTree.setmasterRoot(this.masterRoot);
                    if (this.masterRoot.parentKey.compareTo(key) < 0) {
                        this.masterRoot.Branches.append(key);
                    } else {
                        this.masterRoot.Branches.getNext().insert(key);
                    }    
                    this.setLeftchild(InsertTree);
                    return value;
                }
            } else {
                if (this.rightchild != null) {
                    return this.rightchild.put(key, value);
                } else {
                    MyTree InsertTree = new MyTree((K) key,(T) value, this);
                    InsertTree.setmasterRoot(this.masterRoot);
                    if (this.masterRoot.parentKey.compareTo(key) < 0) {
                        this.masterRoot.Branches.append(key);
                    } else {
                        this.masterRoot.Branches.getNext().insert(key);
                    }                    
                    this.setRightchild(InsertTree);
                    return value;
                }
            }
        } else {
            this.setParentKey((K) key);
            this.setParentValue((T) value);
            return value;
        }
    }

    @Override
    public Object remove(Comparable key) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);           
            if (currentCompare == 0) {     
                T ret = this.parentValue;
                if (this.leftchild != null || this.rightchild != null) { //Ich habe ein rechts oder ein Linkes Kind
                    if (this.root != null) { // Ich habe einen Vater
                        int childPos = (this.root.leftchild != null ? this.compareTo((K) this.root.leftchild) : 1); //Ermitteln ob wir rechtes oder linkes Kind sind 0 - Links | 1 - Rechts
                        if (this.leftchild != null && this.rightchild != null) { //Ich habe zwei Kinder
                            MyTree Biggest = this.leftchild.getBiggestChild();
                            this.rightchild.root = Biggest; //Wurzel des Rechten Kindes an das Großte Linke Kind Hängen
                            this.leftchild.root = this.root; //Wirzel des Linken Kindes auf meine Wurzel Setzen
                            Biggest.rightchild = this.rightchild;
                            if (childPos > 0) { //Ich bin ein Rechtes Kind
                                this.root.rightchild = this.leftchild;  //Das Rechte Kind meiner Wurzel auf mein linkes kind setzen               
                            } else { //Ich bin ein Linkes Kind                            
                                this.root.leftchild = this.leftchild;   //Das Linke Kind meiner Wurzel auf mein linkes kind setzen
                            }                            
                        } else {
                            if(this.leftchild != null) { // Ich habe nur ein Linkes Kind  
                                this.leftchild.root = this.root;
                                if (childPos > 0) { //Ich bin ein Rechtes Kind
                                    this.root.rightchild = this.leftchild;  //Das Rechte Kind meiner Wurzel auf mein linkes kind setzen               
                                } else { //Ich bin ein Linkes Kind                            
                                    this.root.leftchild = this.leftchild;   //Das Linke Kind meiner Wurzel auf mein linkes kind setzen
                                }                              
                            }                        
                            if(this.rightchild != null) { //Ich habe nur ein Rechtes Kind
                                this.rightchild.root = this.root;
                                if (childPos > 0) { //Ich bin ein Rechtes Kind
                                    this.root.rightchild = this.rightchild;  //Das Rechte Kind meiner Wurzel auf mein rechtes kind setzen               
                                } else { //Ich bin ein Linkes Kind                            
                                    this.root.leftchild = this.rightchild;   //Das Linke Kind meiner Wurzel auf mein rechtes kind setzen
                                }                 
                            }
                        }
                        return ret;
                    } else { //Ich bin die Oberste Wurzel                          
                        if (this.leftchild != null && this.rightchild != null) { //Ich habe zwei Kinder                            
                            MyTree Biggest = this.leftchild.getBiggestChild();
                            this.rightchild.root = Biggest; //Wurzel des Rechten Kindes an das Großte Linke Kind Hängen
                            Biggest.rightchild = this.rightchild;
                            this.rightchild = null;
                            this.parentKey = (K) this.leftchild.parentKey;
                            this.parentValue = (T) this.leftchild.parentValue;   
                            if(this.leftchild.rightchild != null) {//Rechte Kinder meines Linken Kindes Übernehmen
                                this.rightchild = this.leftchild.rightchild; 
                                this.rightchild.root = this;
                            } else {
                                this.rightchild = null;
                            }  
                            if (this.leftchild.leftchild != null) {//Linke Kinder meines Linken Kindes Übernehmen
                                this.leftchild = this.leftchild.leftchild;        
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }  
                        } else if(this.leftchild != null) { //Ich habe nur ein Linkes Kind
                            this.parentKey = (K) this.leftchild.parentKey;
                            this.parentValue = (T) this.leftchild.parentValue; 
                            if (this.leftchild.rightchild != null) {//Rechte Kinder meines Linken Kindes Übernehmen
                                this.rightchild = this.leftchild.rightchild; 
                                this.rightchild.root = this;
                            } else {
                                this.rightchild = null;
                            }
                            if (this.leftchild.leftchild != null) {//Linke Kinder meines Linken Kindes Übernehmen
                                this.leftchild = this.leftchild.leftchild;        
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }                                                      
                        } else { //Ich habe nur ein Rechtes Kind
                            this.parentKey = (K) this.rightchild.parentKey;
                            this.parentValue = (T) this.rightchild.parentValue;
                            if (this.rightchild.leftchild != null) {//Rechte Kinder meines Rechten Kindes Übernehmen
                                this.leftchild = this.rightchild.leftchild;    
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }     
                            if (this.rightchild.rightchild != null) {//Linke Kinder meines Rechten Kindes Übernehmen
                                this.rightchild = this.rightchild.rightchild;
                                this.rightchild.root = this;
                            } else {
                                this.rightchild = null;
                            }                                                          
                        }    
                        return ret;
                    }                                            
                } else { //Ich habe keine Kinder
                    if (this.root != null) { // Ich habe einen Vater
                        int childPos = (this.root.leftchild != null ? this.compareTo((K) this.root.leftchild) : 1); //Ermitteln ob wir rechtes oder linkes Kind sind 0 - Links | 1 - Rechts
                        if (childPos > 0) { //Ich bin ein Rechtes Kind
                            this.root.rightchild = null;
                        } else { //Ich bin ein Linkes Kind
                            this.root.leftchild = null;
                        }          
                    } else { // Ich habe keinen Vater -> Ich bin alleine im Baum
                        this.parentKey = null;
                        this.parentValue = null;
                        this.masterRoot = null;
                    }
                    return ret;
                }               
            } else if (currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.remove((K) key) : null);
            } else {
                return (this.rightchild != null ? this.rightchild.remove((K) key) : null);
            }
        } else {
            return null;
        }
    }

    @Override
    public Object replace(Comparable key, Object value) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                Object ret = this.parentValue;
                this.setParentValue((T) value);
                return ret;
            } else if (currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.replace(key,value) : null);
            } else {
                return (this.rightchild != null ? this.rightchild.replace(key,value) : null);
            }
        } else {
            return null;
        }
    }
    
    @Override
    public String toString() {
        if (!this.isEmpty()) {
            return this.printSortedKeys(this.getSmallestChild(),this.getSmallestChild(), "");                  
        } else {
            return "Tree is Empty";
        }       
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            MyTree current;
            MyTree root = MyTree.this;       
            Iterator Branches = root.Branches.iterator();
            
            @Override
            public boolean hasNext() {
                return Branches.hasNext();   
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (current == null) {
                   current = root.masterRoot; 
                   return (T) root.parentKey;
                }              
               
                T e = (T) Branches.next();                
                current = root.getElement((Comparable) e);                
                return e;        
            }
        };
    }    

    /**
     * Compare Trees' Parent Keys
     * @param t
     * @return 
     */
    @Override
    public int compareTo(K t) {
        MyTree tree = (MyTree) t;
        return this.parentKey.compareTo((K) tree.parentKey);
    }    
}