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
        
        /*
        //TEST 5 MyStack
        System.out.println("Integer[] SortedList:");
        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MyStack liste = new MyStack();
              
        //push
        for (Integer[] element : a) {
            liste.push(new MyListElement(element));  
            System.out.println(Arrays.toString(element));
        }                
        System.out.println("\nLänge beträgt:");
        System.out.println(liste.length());
               
        //peek
        System.out.println("\nDas Element vom Kopf Lautet:");
        System.out.println(liste.peek());
        
        //pop
        System.out.println("\nDas Element am Kopf wird gelöscht.");
        liste.pop();
        System.out.println("Das Neue Erste Element Lautet:");
        System.out.println(liste.peek());
        System.out.println("\nNeue Länge beträgt:");
        System.out.println(liste.length());
        */
        
        /*
        //TEST 4 MyQueue
        System.out.println("Integer[] SortedList:");
        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MyQueue liste = new MyQueue();
              
        //Add
        for (Integer[] element : a) {
            liste.add(new MyListElement(element));  
            System.out.println(Arrays.toString(element));
        }                
        System.out.println("\nLänge beträgt:");
        System.out.println(liste.length());
        
        //Element
        System.out.println("\nDas Erste Element Lautet:");
        System.out.println(liste.element());
        
        //Remove
        System.out.println("\nDas Erste Element wird gelöscht.");
        liste.remove();
        System.out.println("Das Neue Erste Element Lautet:");
        System.out.println(liste.element());
        System.out.println("\nNeue Länge beträgt:");
        System.out.println(liste.length());
        */       
        
        /*
        //TEST 3 SortedList    
        System.out.println("Integer[] SortedList:");
        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
            @Override
            public Integer[] apply(final Integer[] integers) {
                return integers;
            }
        });
        MySortedList liste = new MySortedList();
                       
        for (Integer[] element : a) {
            liste.insert(new MyListElement(element));  
            //System.out.println(Arrays.toString(element));
        }                
        System.out.println("\nLänge beträgt:");
        System.out.println(liste.length());
        
        for (Object element : liste) {
            MyListElement listelement = (MyListElement) element; 
            System.out.println("Summe:"+listelement.arraySum(listelement.getMyElement()));
        }  
        */
        
        /*
        //TEST 2 Compare To
        Integer[] s = {1,1,1};
        MyListElement a = new MyListElement(s);
        
        Integer[] g = {2,2,2};
        MyListElement b = new MyListElement(g);
        
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        */
        
        /*
        //TEST1 Liste mit unterschiedlichen Object Typen
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