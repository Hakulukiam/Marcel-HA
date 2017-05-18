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
    /**     * 
     * @param t wird uebergeben
     * @return Arrays.equals(this.getMyElement(), t.getMyElement())
     */
    public boolean equals(MyListElement t) {
        return this.object == t.object;        
    }
    /**
     * 
     * @param t
     * @return  object[0] + object[1] + object[2]
     */
    public int arraySum(T t) {
        Integer[] intarr = (Integer[]) t;
        return intarr[0] + intarr[1] + intarr[2];
    }        
    
    @Override
    public String toString() {
        return this.object.toString();
    }
    
    @Override
    public int compareTo(T t) {
        //java.lang.String
        //java.lang.Integer
        //[Ljava.lang.Integer;

        MyListElement element = (MyListElement) t;      
               
        if (t == this) {
            return 0;
        }
        
        if(element.getMyElement().getClass().equals(this.object.getClass())){   
        
            if(element.getMyElement() instanceof Integer){
                if((Integer) element.getMyElement() > (Integer) this.object)return -1;
                if((Integer) element.getMyElement() < (Integer) this.object)return 1;
                return 0;
            }

            if(element.getMyElement() instanceof Integer[]){
                if(this.arraySum((T) element.getMyElement()) > this.arraySum((T) this.object))return -1;
                if(this.arraySum((T) element.getMyElement()) < this.arraySum((T) this.object))return 1;
                return 0;
            }

            if(element.getMyElement() instanceof String){
                String a = (String) element.getMyElement();
                String b = (String) this.object;
                return a.compareTo(b);
            }
            
            
        }
        throw new UnsupportedOperationException();      
    }
}