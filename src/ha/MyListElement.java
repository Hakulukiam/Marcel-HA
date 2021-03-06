
package ha;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 * @param <T>
 */
public class MyListElement<T> implements Comparable {
    
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
        return this.compareTo((T) t) == 0;
    }
    /**
     * 
     * @param t wird uebergeben
     * @return  object[0] + object[1] + object[2]
     */
    public int arraySum(T t) {
        Integer[] intarr = (Integer[]) t;
        return intarr[0] + intarr[1] + intarr[2];
    }        
    
    @Override
    public String toString() {
        if (this.object instanceof Integer) {
            return this.object.toString();
        }

        if (this.object instanceof Integer[]) {
            Integer[] intarr = (Integer[]) this.object;
            return intarr[0] + " " + intarr[1] + " " + intarr[2];
        }

        if (this.object instanceof String) {
            return this.object.toString();
        }
        
        if (this.object == null) {
            return "null";
        }
        
        throw new UnsupportedOperationException();  
    }

    @Override
    public int compareTo(Object t) {
        MyListElement element = (MyListElement) t;      
               
        if (t == this) {
            return 0;
        }
        
        if (element.getMyElement().getClass().equals(this.object.getClass())) {
        
            if (element.getMyElement() instanceof Integer) {
                Integer a = (Integer) element.getMyElement();
                Integer b = (Integer) this.object;
                return b.compareTo(a);
            }

            if (element.getMyElement() instanceof Integer[]) {
                if (this.arraySum((T) element.getMyElement()) > this.arraySum((T) this.object)) {
                    return -1;
                }
                if (this.arraySum((T) element.getMyElement()) < this.arraySum((T) this.object)) {
                    return 1;
                }
                return 0;
            }

            if (element.getMyElement() instanceof String) {
                String a = (String) element.getMyElement();
                String b = (String) this.object;
                return b.compareTo(a);
            }

        }
        throw new UnsupportedOperationException();      
    }
}