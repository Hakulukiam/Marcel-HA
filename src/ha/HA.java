package ha;

import de.tu_bs.ips.NextFunction;
import java.util.Arrays;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        //HALLO
        Iterable<Integer[]> b = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MyList liste = new MyList();
                       
        for (Integer[] element : b) {
            liste.append(new MyListElement(element));  
            System.out.println(Arrays.toString(element));
        }
                
        System.out.println("Länge beträgt:");
        System.out.println(liste.length());
               
    }
}