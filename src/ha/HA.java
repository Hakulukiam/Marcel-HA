package ha;

import de.tu_bs.ips.NextFunction;
import java.util.Iterator;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        EntryDataSoure b = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MyList liste = new MyList();
        Iterator iterator = b.iterator();
        
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println("\nFüge ein:");
            System.out.println("\n"+b.next());
            liste.append(b.next());   
            i++;
            if(i > 1000)break;
        }
        
        System.out.println("Länge beträgt:");
        System.out.println(liste.length());
        
        /*
        MyListElement todelete = new MyListElement(null);      
        while (b.hasNext()) {
            MyListElement insert = new MyListElement(b.next());
            System.out.println("\nFüge ein:");
            System.out.println(insert.toString());
            liste.append(insert);          
            todelete = insert;
        }       
        System.out.println("\nLänge beträgt:");
        System.out.println(liste.length());
       
        System.out.println("\nLösche letztes Element:");
        System.out.println(todelete);
        liste.delete(todelete);
        System.out.println("Neue Länge beträgt:");
        System.out.println(liste.length());
       */
       
    }
    
}
