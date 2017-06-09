
package ha;

import de.tu_bs.ips.NextFunction;

/**
 *
 * @author Marcel Clemeur 4840095 Gruppe 2C
 * @param <T>
 */
public class EntryDataSoure<T> extends de.tu_bs.ips.DataSource {
    /**
     * 
     * @param mode wird uebergeben
     * @param nextFunction wird uebergeben
     */   
    public EntryDataSoure(Mode mode, NextFunction<T> nextFunction) {
        super(mode, nextFunction);
    }
    /**
     * 
     * @return MyListElement
     */
    public MyListElement<T> next() { 
        return new MyListElement(this.iterator().next());
    }
}