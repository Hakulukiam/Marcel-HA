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
        for (Integer key : ints) {
            TestTree.put(key, stringIterator.next());
        }
        
        System.out.println("Size:");
        System.out.println(TestTree.size());
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("System Out [toString()]:");
        System.out.println(TestTree);
        
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Keys [get()]:");
        for (Integer key : ints) {
            System.out.println("Search: "+key);
            System.out.println("Found: "+TestTree.get(key));
        }
        
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("Search with Values [containsValue()]:");
        for (String value : strings) {
            System.out.println("Search: "+value);
            System.out.println("Found: "+TestTree.containsValue(value));
        }
                
        System.out.println("\n-----------------------------------------------------------------------------");
        int i = 5;
        System.out.println("Delete "+i+" Elements from Tree [remove()]:");        
        for (Integer key : ints) {            
            if(i == 0)break;          
            System.out.println("Delete: "+key);
            System.out.println("Deleted: "+TestTree.remove(key));
            System.out.println("Search Key: "+key+" -> Found: "+TestTree.get(key));             
            i--;
        }
        System.out.println("\nElements Deleted!");
        System.out.println("New Size:");
        System.out.println(TestTree.size());
               
        System.out.println(TestTree);
        
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