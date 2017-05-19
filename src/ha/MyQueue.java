/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

/**
 *
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class MyQueue extends MyList {

    /**
     * Fügt das Element e ans Ende der Warteschlange ein. 
     * @param e
     */
    public void add(MyListElement e){
        this.append(e);
    } 
            
    /**
     * Löscht das vorderste Element und gibt dies zurück. Wenn die Warteschlange leer ist, wird null zurückgegeben.
     * @return
     */
    public MyListElement remove(){
        if(this.length() > 0){
            MyListElement ret = new MyListElement(this.firstElement.getMyElement());
            this.delete(this.firstElement);    
            return ret;            
        }else{
            return null;
        }        
    } 
                    
    /**
     * Gibt das vorderste Element zurück. Wenn die Warteschlange leer ist, wird null zurückgegeben.
     * @return
     */
    public MyListElement element(){
        if(this.length() > 0){
            return this.firstElement;            
        }else{
            return null;
        }    
    }            
}