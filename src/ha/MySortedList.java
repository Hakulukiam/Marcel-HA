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
    public void append(Object e) {
        throw new UnsupportedOperationException("Append ist nicht zugelassen für Sortierte Listen.");
    }
    
    @Override
    public int compareTo(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
