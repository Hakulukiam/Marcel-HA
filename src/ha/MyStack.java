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
public class MyStack extends MyList{

    /**
     * Legt das Element e auf den Kopf des Stacks. 
     * @param e
     */
    public void push(MyListElement e){
        this.insert(e);
    }
    
    /**
     * Löscht das Element vom Kopf und gibt es zurück. Wenn der Stack leer ist, wird null zurückgegeben. 
     * @return
     */
    public MyListElement pop(){
        if(this.length() > 0){
            MyListElement ret = new MyListElement(this.getfirstElement().getMyElement());
            this.delete(this.getfirstElement());    
            return ret;            
        }else{
            return null;
        }      
    }
    
    /**
     * Gibt das Element auf dem Kopf zurück. Wenn der Stack leer ist, wird null zurückgegeben.
     * @return
     */
    public MyListElement peek(){
        if(this.length() > 0){
            return this.getfirstElement();            
        }else{
            return null;
        }    
    }
}
