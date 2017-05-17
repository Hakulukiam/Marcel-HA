/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 * @param <T>
 */
public class MyListElement<T> implements Comparable<T> {
    
    private T object;
    private MyListElement nextMyElement;
    private MyListElement prevMyElement;
    
    /**
     * 
     * @param element 
     */
    public MyListElement(T element) {
        this.object = element;
        prevMyElement = null;
        nextMyElement = null;
    }
    /**
     * 
     * @param element 
     */
    public void setnextMyElement(MyListElement element) {
        this.nextMyElement = element;
    }
    /**
     * 
     * @param element 
     */
    public void setprevMyElement(MyListElement element) {
        this.prevMyElement = element;
    }
    /**
     * 
     * @return nextMyElement
     */
    public MyListElement getnextMyElement() {
        return nextMyElement;
    }
    /**
     * 
     * @return prevMyElement
     */
    public MyListElement getprevMyElement() {
        return prevMyElement;
    }
    /**
     * 
     * @return this
     */
    public Comparable getMyListElement() {
        return this;
    }
    /**
     * 
     * @return this.object
     */
    public T getMyElement() {
        return this.object;
    }
    /**
     * 
     * @param t wird uebergeben
     * @return Arrays.equals(this.getMyElement(), t.getMyElement())
     */
    public boolean equals(MyListElement t) {
        //return Arrays.equals(this.getMyElement(), t.getMyElement());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @return  object[0] + object[1] + object[2]
     */
    public int arraySum() {
        //return object[0] + object[1] + object[2];
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
    
    @Override
    public String toString() {
        //return object[0] + " " + object[1] + " " + object[2];
        return this.object.toString();
    }
    
    @Override
    public int compareTo(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}