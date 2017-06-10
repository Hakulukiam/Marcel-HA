
package ha;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 * 
 * @param <K> Type of Keys
 * @param <T> Type of Values
 */
public class MyTree<K extends Comparable<K>, T> implements de.tu_bs.ips.Tree, Comparable<K> {
    
    private K parentKey;
    private T parentValue;
    private MyTree leftchild;
    private MyTree rightchild;
    private MyTree root;
    private MyTree masterRoot;
    private de.tu_bs.ips.MyList branches;
   /**
    * 
    */
    public MyTree() {
        this.parentKey = null;
        this.parentValue = null;
        this.root = null;
        this.masterRoot = this;
        this.branches = new de.tu_bs.ips.MyList();
    }
    /**
     * 
     * @param key wird uebergeben
     * @param value wird uebergeben
     */
    public MyTree(K key, T value) {
        this.parentKey = key;
        this.parentValue = value;
        this.root = null;
        this.masterRoot = this;
        this.branches = new de.tu_bs.ips.MyList();
    }
    /**
     * 
     * @param key wird uebergeben
     * @param value wird uebergeben
     * @param root wird uebergeben
     */
    public MyTree(K key, T value, MyTree root) {
        this.parentKey = key;
        this.parentValue = value;
        this.root = root;
    }
   /**
    * 
    * @param key wird uebergeben
    * @return key oder null
    */
    public MyTree getElement(Comparable key) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                return this;
            } else if (currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.getElement((K) key) : null);
            } else {
                return (this.rightchild != null ? this.rightchild.getElement((K) key) : null);
            }
        } else {
            return null;
        }
    }
    /**
     * 
     * @return Biggestchild oder null
     */
    public MyTree getBiggestChild() {
        if (!this.isEmpty()) {            
            return (this.rightchild != null ? this.rightchild.getBiggestChild() : this);
        } else {
            return null;
        }
    }
    /**
     * 
     * @return  smallestchild oder null
     */
    public MyTree getSmallestChild() {
        if (!this.isEmpty()) {            
            return (this.leftchild != null ? this.leftchild.getSmallestChild() : this);
        } else {
            return null;
        }
    }
    /**
     * 
     * @param currentElement wird uebergeben
     * @param lastElement wird uebergeben
     * @param sortedKeys wird uebergeben
     * @return sortierte keys
     */
    public String printSortedKeys(MyTree currentElement, MyTree lastElement, String sortedKeys) {
        if (!this.isEmpty()) {                                               
            if (this.getBiggestChild().compareTo(currentElement) == 0) { //Letztes Element
                return sortedKeys + currentElement.parentKey + " -> " + currentElement.parentValue + "\n";
            }    
                    
            if (currentElement.compareTo(lastElement) >= 0) { // Element ist das nächste
                sortedKeys = sortedKeys + currentElement.parentKey + " -> " + currentElement.parentValue + "\n";
            }                    
                    
            if (currentElement.rightchild != null && currentElement.rightchild.compareTo(lastElement) > 0) { //2 - Wenn rechtes Kind 
                //JA -> getSmallest am rechten Kind ist nächstes element                     
                return this.printSortedKeys(currentElement.rightchild.getSmallestChild(), currentElement, sortedKeys); 
            } else {
                return this.printSortedKeys(currentElement.root, currentElement, sortedKeys); //Nein -> geh die Wurzel Rauf
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
        } else {
            return 0;
        }
    }

    @Override
    public Object get(Comparable key) {
        if (!this.isEmpty()) {
            int currentCompare = this.parentKey.compareTo((K) key);
            if (currentCompare == 0) {
                return this.parentValue;
            } else if (currentCompare > 0) {
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
            } else if (currentCompare > 0) {
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
                    MyTree insertTree = new MyTree((K) key, (T) value, this);
                    insertTree.masterRoot = this.masterRoot;
                    if (this.masterRoot.parentKey.compareTo(key) < 0) {
                        this.masterRoot.branches.append(key);
                    } else {
                        this.masterRoot.branches.getNext().insert(key);
                    }    
                    this.leftchild = insertTree;
                    return value;
                }
            } else {
                if (this.rightchild != null) {
                    return this.rightchild.put(key, value);
                } else {
                    MyTree insertTree = new MyTree((K) key, (T) value, this);
                    insertTree.masterRoot = this.masterRoot;
                    if (this.masterRoot.parentKey.compareTo(key) < 0) {
                        this.masterRoot.branches.append(key);
                    } else {
                        this.masterRoot.branches.getNext().insert(key);
                    }                    
                    this.rightchild = insertTree;
                    return value;
                }
            }
        } else {
            this.parentKey = (K) key;
            this.parentValue = (T) value;
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
                         //Ermitteln ob wir rechtes oder linkes Kind sind 0 - Links | 1 - Rechts
                        int childPos = (this.root.leftchild != null ? this.compareTo((K) this.root.leftchild) : 1);
                        if (this.leftchild != null && this.rightchild != null) { //Ich habe zwei Kinder
                            MyTree biggest = this.leftchild.getBiggestChild();
                            this.rightchild.root = biggest; //Wurzel des Rechten Kindes an das Großte Linke Kind Hängen
                            this.leftchild.root = this.root; //Wirzel des Linken Kindes auf meine Wurzel Setzen
                            biggest.rightchild = this.rightchild;
                            if (childPos > 0) { //Ich bin ein Rechtes Kind
                                this.root.rightchild = this.leftchild;  //Das Rechte Kind meiner Wurzel auf mein linkes kind setzen               
                            } else { //Ich bin ein Linkes Kind                            
                                this.root.leftchild = this.leftchild;   //Das Linke Kind meiner Wurzel auf mein linkes kind setzen
                            }                            
                        } else {
                            if (this.leftchild != null) { // Ich habe nur ein Linkes Kind  
                                this.leftchild.root = this.root;
                                if (childPos > 0) { //Ich bin ein Rechtes Kind
                                    this.root.rightchild = this.leftchild;  //Das Rechte Kind meiner Wurzel auf mein linkes kind setzen               
                                } else { //Ich bin ein Linkes Kind                            
                                    this.root.leftchild = this.leftchild;   //Das Linke Kind meiner Wurzel auf mein linkes kind setzen
                                }                              
                            }                        
                            if (this.rightchild != null) { //Ich habe nur ein Rechtes Kind
                                this.rightchild.root = this.root;
                                if (childPos > 0) { //Ich bin ein Rechtes Kind
                                    this.root.rightchild = this.rightchild; //Das Rechte Kind meiner Wurzel auf mein rechtes kind setzen       
                                } else { //Ich bin ein Linkes Kind                            
                                    this.root.leftchild = this.rightchild;   //Das Linke Kind meiner Wurzel auf mein rechtes kind setzen
                                }                 
                            }
                        }
                        return ret;
                    } else { //Ich bin die Oberste Wurzel                          
                        if (this.leftchild != null && this.rightchild != null) { //Ich habe zwei Kinder                            
                            MyTree biggest = this.leftchild.getBiggestChild();
                            this.rightchild.root = biggest; //Wurzel des Rechten Kindes an das Großte Linke Kind Hängen
                            biggest.rightchild = this.rightchild;
                            this.rightchild = null;
                            this.parentKey = (K) this.leftchild.parentKey;
                            this.parentValue = (T) this.leftchild.parentValue;   
                            if (this.leftchild.rightchild != null) { //Rechte Kinder meines Linken Kindes Übernehmen
                                this.rightchild = this.leftchild.rightchild; 
                                this.rightchild.root = this;
                            } else {
                                this.rightchild = null;
                            }  
                            if (this.leftchild.leftchild != null) { //Linke Kinder meines Linken Kindes Übernehmen
                                this.leftchild = this.leftchild.leftchild;        
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }  
                        } else if (this.leftchild != null) { //Ich habe nur ein Linkes Kind
                            this.parentKey = (K) this.leftchild.parentKey;
                            this.parentValue = (T) this.leftchild.parentValue; 
                            if (this.leftchild.rightchild != null) { //Rechte Kinder meines Linken Kindes Übernehmen
                                this.rightchild = this.leftchild.rightchild; 
                                this.rightchild.root = this;
                            } else {
                                this.rightchild = null;
                            }
                            if (this.leftchild.leftchild != null) { //Linke Kinder meines Linken Kindes Übernehmen
                                this.leftchild = this.leftchild.leftchild;        
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }                                                      
                        } else { //Ich habe nur ein Rechtes Kind
                            this.parentKey = (K) this.rightchild.parentKey;
                            this.parentValue = (T) this.rightchild.parentValue;
                            if (this.rightchild.leftchild != null) { //Rechte Kinder meines Rechten Kindes Übernehmen
                                this.leftchild = this.rightchild.leftchild;    
                                this.leftchild.root = this;
                            } else {
                                this.leftchild = null;
                            }     
                            if (this.rightchild.rightchild != null) { //Linke Kinder meines Rechten Kindes Übernehmen
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
                        //Ermitteln ob wir rechtes oder linkes Kind sind 0 - Links | 1 - Rechts
                        int childPos = (this.root.leftchild != null ? this.compareTo((K) this.root.leftchild) : 1); 
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
                this.parentValue = (T) value;
                return ret;
            } else if (currentCompare > 0) {
                return (this.leftchild != null ? this.leftchild.replace(key, value) : null);
            } else {
                return (this.rightchild != null ? this.rightchild.replace(key, value) : null);
            }
        } else {
            return null;
        }
    }
    
    @Override
    public String toString() {
        if (!this.isEmpty()) {
            return this.printSortedKeys(this.getSmallestChild(), this.getSmallestChild(), "");                  
        } else {
            return "Tree is Empty";
        }       
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            private MyTree current;
            private MyTree root = MyTree.this;       
            private Iterator branches = root.branches.iterator();
            
            @Override
            public boolean hasNext() {
                return branches.hasNext();   
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
               
                T e = (T) branches.next();                
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