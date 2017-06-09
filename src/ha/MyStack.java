
package ha;

/**
 *
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class MyStack extends MyList {

    /**
     * Legt das Element e auf den Kopf des Stacks. 
     * @param e wird uebergeben
     */
    public void push(MyListElement e) {
        this.insert(e);
    }
    
    /**
     * Löscht das Element vom Kopf und gibt es zurück. Wenn der Stack leer ist, wird null zurückgegeben. 
     * @return ret oder null
     */
    public MyListElement pop() {
        if (this.length() > 0) {
            MyListElement ret = new MyListElement(this.getfirstElement().getMyElement());
            this.delete(this.getfirstElement());    
            return ret;            
        } else {
            return null;
        }      
    }
    
    /**
     * Gibt das Element auf dem Kopf zurück. Wenn der Stack leer ist, wird null zurückgegeben.
     * @return getfirstElement oder null
     */
    public MyListElement peek() {
        if (this.length() > 0) {
            return this.getfirstElement();            
        } else {
            return null;
        }    
    }
}
