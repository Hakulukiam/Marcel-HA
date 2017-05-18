package ha;

import de.tu_bs.ips.NextFunction;
import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        
        Integer[] s = {7,2,3};
        Integer[] g = {3,4,5};
        MyListElement a = new MyListElement(s);
        MyListElement b = new MyListElement(g);
        
        System.out.println(a.compareTo(b));
        
        
        /*
        System.out.println("Int[] Liste:");
        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MyList liste = new MyList();
                       
        for (Integer[] element : a) {
            liste.append(new MyListElement(element));  
            System.out.println(Arrays.toString(element));
        }
                
        System.out.println("\nLänge 1 beträgt:");
        System.out.println(liste.length());
        System.out.println("\n================================================================================\n");
        
        
        
        
        
        System.out.println("\nString[] Liste:");
        Iterable<String> b = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<String>() {
            @Override
            public String apply(final Integer[] integers) {
                Checksum checksum = new Adler32();
                checksum.update(integers[0]);
                checksum.update(integers[1]);
                checksum.update(integers[2]);
                char[] chars = String.valueOf(checksum.getValue()).toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = (char) (chars[i] + 17);
                }
                return String.valueOf(chars);
            }
        });
        MyList liste2 = new MyList();
                       
        for (String element : b) {
            liste2.append(new MyListElement(element));  
            System.out.println(element);
        }
                
        System.out.println("\nLänge 2 beträgt:");
        System.out.println(liste.length());
           */    
    }
}