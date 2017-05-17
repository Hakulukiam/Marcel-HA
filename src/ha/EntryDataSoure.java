/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

import de.tu_bs.ips.NextFunction;

/**
 *
 * @author Markus
 * @param <T>
 */
public class EntryDataSoure<T> extends de.tu_bs.ips.DataSource {
       
    public EntryDataSoure(Mode mode, NextFunction<T> nextFunction) {
        super(mode, nextFunction);
    }
    
    public MyListElement<T> next() { 
        return new MyListElement(this.iterator().next());
    }
}