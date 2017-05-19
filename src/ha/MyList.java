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
public class MyList implements de.tu_bs.ips.List, Iterable {
    
    public MyListElement firstElement;
    public MyListElement lastElement;
    public MyListElement currentElement;
    /**
     * 
     */
    public MyList() {
        this.firstElement = new MyListElement(null);
        this.lastElement = new MyListElement(null);
        this.currentElement = new MyListElement(null);
    }
    /**
     * 
     * @param element 
     */
    public MyList(Integer[] element) {
        this.firstElement = new MyListElement(element);
        this.lastElement = new MyListElement(null);
        this.currentElement = new MyListElement(element);
    }
    
    @Override
    public boolean isEmpty() {
        return firstElement.getMyElement() == null && this.lastElement.getMyElement() == null;
    }

    @Override
    public int length() {
        int length = 0;
        MyListElement current = this.firstElement;
        if (current.getMyElement() != null) {
            while (current.getMyElement() != null) {
                length++;
                if(current.getnextMyElement() != null){
                    current = current.getnextMyElement();
                }else{
                    break;
                }               
            }
        }
        return length;        
    }
    
    @Override
    public Comparable first() {
        return this.firstElement.getMyListElement();
    }
    
    /**
     * 
     * @return this.lastElement.getMyListElement()
     */
    public Comparable last() {
        return this.lastElement.getMyListElement();
    }

    @Override
    public void insert(Object e) {
        MyListElement element = (MyListElement) e;  
        element.setprevMyElement(null);
        if (this.firstElement.getMyElement() == null) {
            this.firstElement = element;
            element.setnextMyElement(null);
        } else {
            this.firstElement.setprevMyElement(element);
            element.setnextMyElement(this.firstElement);  
        }        
        if (this.lastElement.getMyElement() == null) {
            this.lastElement = element;
        }
          
        this.firstElement = element;
    }

    @Override
    public void append(Object e) {
        MyListElement element = (MyListElement) e;       
        element.setnextMyElement(null);
        if (this.lastElement.getMyElement() == null) {
            this.lastElement = element;
            element.setprevMyElement(null);
        } else {
            this.lastElement.setnextMyElement(element);
            element.setprevMyElement(this.lastElement);
        }        
        if (this.firstElement.getMyElement() == null) {
            this.firstElement = element;
        }
        this.lastElement = element;
    }

    @Override
    public void delete(Object e) {
        MyListElement current = firstElement;
        MyListElement element = (MyListElement) e;
                
        if (current != null && current.getMyElement() != null) {
            while (current != null && current.getMyElement() != null) {
                //System.out.println("1:"+current.getMyListElement()+" 2:"+Element);
                if (current.equals(element)) {
                    if (current.getprevMyElement() == null) {
                        current.getnextMyElement().setprevMyElement(null);
                        this.firstElement = current.getnextMyElement();
                        break;
                    }
                    if (current.getnextMyElement() == null) {
                        current.getprevMyElement().setnextMyElement(null);
                        this.lastElement = current.getprevMyElement();
                        break;
                    }     
                    if (current.getnextMyElement() != null) {
                        current.getnextMyElement().setprevMyElement(current.getprevMyElement());
                    }
                    if (current.getprevMyElement() != null) {
                        current.getprevMyElement().setnextMyElement(current.getnextMyElement());
                    }
                }                  
                    
                current = current.getnextMyElement();
            }
        }      
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {                       
            @Override
            public boolean hasNext() {
               return currentElement.getnextMyElement() != null;
            }

            @Override
            public Object next() {
                currentElement = currentElement.getnextMyElement();
                return currentElement;
            }            
        };        
    }    
}