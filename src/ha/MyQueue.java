
package ha;

/**
 *
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class MyQueue extends MyList {

    /**
     * Fügt das Element e ans Ende der Warteschlange ein. 
     * @param e wird uebergeben
     */
    public void add(MyListElement e) {
        this.append(e);
    } 
            
    /**
     * Löscht das vorderste Element und gibt dies zurück. Wenn die Warteschlange leer ist, wird null zurückgegeben.
     * @return ret oder null
     */
    public MyListElement remove() {
        if (this.length() > 0) {
            MyListElement ret = new MyListElement(this.getfirstElement().getMyElement());
            this.delete(this.getfirstElement());    
            return ret;            
        } else {
            return null;
        }        
    } 
                    
    /**
     * Gibt das vorderste Element zurück. Wenn die Warteschlange leer ist, wird null zurückgegeben.
     * @return getfirstElement oder null
     */
    public MyListElement element() {
        if (this.length() > 0) {
            return this.getfirstElement();            
        } else {
            return null;
        }    
    }            
}