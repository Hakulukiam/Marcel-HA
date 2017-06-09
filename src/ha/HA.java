package ha;

import de.tu_bs.ips.StringDataSource;
import java.util.Iterator;
/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        MyTree testTree = new MyTree();        
        Iterable<Integer> ints = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
        Iterable<String> strings = new StringDataSource(EntryDataSoure.Mode.A);
        Iterator<String> stringIterator = strings.iterator();
        System.out.println("Insert Into Tree [put()]:");
        for (Integer key : ints) {
            String next = stringIterator.next();
            Object input = testTree.put(key, next);
            if (input == null) {
                System.out.println("Key '" + key + "' Exists!");
            } else {
                System.out.println("Key: " + key + " -> Value: " + next); 
            }
        }
       
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Size:");
        int size = testTree.size();
        System.out.println(size);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("System Out [toString()]:");
        System.out.println(testTree);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Keys [get()]:");
        int o = 0;
        for (Integer key : ints) {
            System.out.println("Search: " + key);
            Object found = testTree.get(key);
            if (found == null) {                
                System.out.println("Not Found");
            } else {
                o++;
                System.out.println("Found: " + found);
            }            
        }
        System.out.println("\n" + o + " Keys Found.");        
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Values [containsValue()]:");
        int m = 0;
        for (String value : strings) {
            System.out.println("Search: " + value);
            Boolean found = testTree.containsValue(value);
            if (found) {
                m++;
                System.out.println("Found: " + found);           
            } else {
                System.out.println("Not Found");
            }    
        }
        System.out.println("\n" + m + " Values Found.");
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Iterate and Delete Elements from Tree [iterator() + remove()]:");
        for (Object key : testTree) {
            System.out.println("Deleted Key " + key + ": " + testTree.remove((Comparable) key));
        }        
        System.out.println("\nOld Size: " + size);
        System.out.println("New Size: " + testTree.size());               
    }  
}