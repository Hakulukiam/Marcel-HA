/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

/**
 *
 * @author Markus
 * @param <T>
 */
public class MySortedList<T> extends MyList implements Comparable<T>{

    @Override
    public void insert(Object e) {
        this.sortedInsert(e);
    }

    public void sortedInsert(Object e) {
        if (this.length() > 0) {
            MyListElement current = this.firstElement;
            if (current.getMyElement() != null) {               
                while (current.getMyElement() != null) {
                    MyListElement element = (MyListElement) e;
                    if(current.getnextMyElement() == null){
                        current.setnextMyElement(element);
                        element.setprevMyElement(current);
                        break;
                    }else{
                        int compareToCurrent = element.compareTo(current);
                        int compareToNext = element.compareTo(current.getnextMyElement());
                        if(compareToCurrent < 0 && compareToNext > 0){
                            element.setnextMyElement(current.getnextMyElement());
                            element.setprevMyElement(current);                            
                            current.setnextMyElement(element);
                            element.getnextMyElement().setprevMyElement(element);
                            break;                                    
                        }  
                        current = current.getnextMyElement();
                    }    
                }    
            } 
        } else {
            this.currentElement = (MyListElement) e;
            this.firstElement = (MyListElement) e;
            this.lastElement = (MyListElement) e;
        }
    }
    
    @Override
    public void append(Object e) {
        throw new UnsupportedOperationException("Append ist nicht zugelassen für Sortierte Listen.");
    }
    
    @Override
    public int compareTo(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}