package ha;

import de.tu_bs.ips.StringDataSource;
import java.util.Iterator;
/*
import de.tu_bs.ips.NextFunction;
import java.util.Scanner;
*/
/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        MyTree TestTree = new MyTree();        
        Iterable<Integer> ints = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
        Iterable<String> strings = new StringDataSource(EntryDataSoure.Mode.A);
        Iterator<String> stringIterator = strings.iterator();
        System.out.println("Insert Into Tree [put()]:");
        for (Integer key : ints) {
            String next = stringIterator.next();
            Object input = TestTree.put(key, next);
            if(input == null){
                System.out.println("Key '"+key+"' Exists!");
            }else{
                System.out.println("Key: "+key+" -> Value: "+next); 
            }
        }
       
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Size:");
        int size = TestTree.size();
        System.out.println(size);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("System Out [toString()]:");
        System.out.println(TestTree);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Keys [get()]:");
        int o = 0;
        for (Integer key : ints) {
            System.out.println("Search: "+key);
            Object found = TestTree.get(key);
            if(found == null){                
                System.out.println("Not Found");
            }else{
                o++;
                System.out.println("Found: "+found);
            }            
        }
        System.out.println("\n"+o+" Keys Found.");        
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Values [containsValue()]:");
        int m = 0;
        for (String value : strings) {
            System.out.println("Search: "+value);
            Boolean found = TestTree.containsValue(value);
            if(found){
                m++;
                System.out.println("Found: "+found);           
            }else{
                System.out.println("Not Found");
            }    
        }
        System.out.println("\n"+m+" Values Found.");
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Iterate and Delete Elements from Tree [iterator() + remove()]:");
        for (Object key : TestTree) {
            System.out.println("Deleted Key "+key+": "+TestTree.remove((Comparable) key));
        }        
        System.out.println("\nOld Size: "+size);
        System.out.println("New Size: "+TestTree.size());
        
        /*
        String datenstruktur;
        String datasource;
        Scanner scan = new Scanner(System.in);      
        
        System.out.println("Wählen Sie eine Datenstruktur zum Testen:");
        System.out.println("1: MyList");
        System.out.println("2: MySortedList");
        System.out.println("3: MyQueue");
        System.out.println("4: MyStack");
        datenstruktur = scan.next();
                        
        System.out.println("\nWählen Sie eine DataSource:");
        System.out.println("1: Integer[]");
        System.out.println("2: Integer");
        System.out.println("3: String");
        datasource = scan.next();
        
        switch(datenstruktur){
            case "1":
                System.out.println("MyList gewählt\n");
                MyList list = new MyList();
                switch(datasource){
                    case "1":
                        System.out.println("Integer[] gewählt\n");
                        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
                            @Override
                            public Integer[] apply(final Integer[] integers) {
                                return integers;
                            }
                        });
                        for (Integer[] element : a) {
                            list.append(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;
                    case "2":            
                        System.out.println("Integer gewählt\n");
                        Iterable<Integer> b = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
                        for (Integer element : b) {
                            list.append(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;  
                    case "3":
                        System.out.println("String gewählt\n");
                        Iterable<String> c = new de.tu_bs.ips.StringDataSource(EntryDataSoure.Mode.A);                            
                        for (String element : c) {
                            list.append(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;     
                    default:    
                        throw new UnsupportedOperationException();         
                }
                //TODO Löchen alle Elemente             
                
                
                break;
            case "2":
                System.out.println("MySortedList gewählt\n");
                MySortedList listeSorted = new MySortedList();
                switch(datasource){
                    case "1":
                        System.out.println("Integer[] gewählt\n");
                        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
                            @Override
                            public Integer[] apply(final Integer[] integers) {
                                return integers;
                            }
                        });
                        for (Integer[] element : a) {
                            listeSorted.insert(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;
                    case "2":            
                        System.out.println("Integer gewählt\n");
                        Iterable<Integer> b = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
                        for (Integer element : b) {
                            listeSorted.insert(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;  
                    case "3":
                        System.out.println("String gewählt\n");
                        Iterable<String> c = new de.tu_bs.ips.StringDataSource(EntryDataSoure.Mode.A);                            
                        for (String element : c) {
                            listeSorted.insert(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;
                    default:    
                        throw new UnsupportedOperationException();    
                }           
                System.out.println("\nLänge beträgt:");
                System.out.println(listeSorted.length());

                for (Object element : listeSorted) {
                    MyListElement listelement = (MyListElement) element; 
                    System.out.println(listelement);
                }                
                //TODO Löchen alle Elemente
                
                
                break;
            case "3":
                System.out.println("MyQueue gewählt\n");
                MyQueue listeQueue = new MyQueue();
                switch(datasource){
                    case "1":
                        System.out.println("Integer[] gewählt\n");
                        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
                            @Override
                            public Integer[] apply(final Integer[] integers) {
                                return integers;
                            }
                        });
                        for (Integer[] element : a) {
                            listeQueue.add(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;
                    case "2":            
                        System.out.println("Integer gewählt\n");
                        Iterable<Integer> b = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
                        for (Integer element : b) {
                            listeQueue.add(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;  
                    case "3":
                        System.out.println("String gewählt\n");
                        Iterable<String> c = new de.tu_bs.ips.StringDataSource(EntryDataSoure.Mode.A);                            
                        for (String element : c) {
                            listeQueue.add(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;       
                    default:    
                        throw new UnsupportedOperationException();    
                }  
                
                System.out.println("\nLänge beträgt:");
                System.out.println(listeQueue.length());

                //Element
                System.out.println("\nDas Erste Element Lautet:");
                System.out.println(listeQueue.element());

                //Remove
                System.out.println("\nDas Erste Element wird gelöscht.");
                listeQueue.remove();
                System.out.println("Das Neue Erste Element Lautet:");
                System.out.println(listeQueue.element());
                System.out.println("\nNeue Länge beträgt:");
                System.out.println(listeQueue.length());
                
                //TODO Löchen alle Elemente
                
                break;
            case "4":
                System.out.println("MyStack gewählt\n");
                MyStack listeStack = new MyStack();
                switch(datasource){
                    case "1":
                        System.out.println("Integer[] gewählt\n");
                        Iterable<Integer[]> a = new EntryDataSoure(EntryDataSoure.Mode.A, new NextFunction<Integer[]>() {
                            @Override
                            public Integer[] apply(final Integer[] integers) {
                                return integers;
                            }
                        });
                        for (Integer[] element : a) {
                            listeStack.push(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;
                    case "2":            
                        System.out.println("Integer gewählt\n");
                        Iterable<Integer> b = new de.tu_bs.ips.IntegerDataSource(EntryDataSoure.Mode.A);
                        for (Integer element : b) {
                            listeStack.push(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;  
                    case "3":
                        System.out.println("String gewählt\n");
                        Iterable<String> c = new de.tu_bs.ips.StringDataSource(EntryDataSoure.Mode.A);                            
                        for (String element : c) {
                            listeStack.push(new MyListElement(element));  
                            System.out.println(element);
                        }
                        break;    
                    default:    
                        throw new UnsupportedOperationException();
                }  
                System.out.println("\nLänge beträgt:");
                System.out.println(listeStack.length());

                //peek
                System.out.println("\nDas Element vom Kopf Lautet:");
                System.out.println(listeStack.peek());

                //pop
                System.out.println("\nDas Element am Kopf wird gelöscht.");
                listeStack.pop();
                System.out.println("Das Neue Erste Element Lautet:");
                System.out.println(listeStack.peek());
                System.out.println("\nNeue Länge beträgt:");
                System.out.println(listeStack.length());
                
                //TODO Löchen alle Elemente
                
                break;
            default:
                 System.out.println("Falsche Eingabe!");
        }*/
        
    }  
}