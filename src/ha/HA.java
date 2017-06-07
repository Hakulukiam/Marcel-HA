package ha;

import de.tu_bs.ips.NextFunction;
import java.util.Scanner;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        
        Integer[] values = {1,1,1};
        Integer[] values1 = {2,2,2};
        Integer[] values2 = {3,3,3};
        Integer[] values3 = {4,4,4};
        Integer[] values4 = {5,5,5};
        Integer[] search = {1,1,1};
        
        de.tu_bs.ips.Entry value = new de.tu_bs.ips.Entry(values);
        de.tu_bs.ips.Entry value1 = new de.tu_bs.ips.Entry(values1);
        de.tu_bs.ips.Entry value2 = new de.tu_bs.ips.Entry(values2);
        de.tu_bs.ips.Entry value3 = new de.tu_bs.ips.Entry(values3);
        de.tu_bs.ips.Entry value4 = new de.tu_bs.ips.Entry(values4);
        de.tu_bs.ips.Entry searchentry = new de.tu_bs.ips.Entry(search);
        
        MyTree test = new MyTree(10,value);
        MyTree test1 = new MyTree(20,value1);
        MyTree test2 = new MyTree(30,value2);
        MyTree test3 = new MyTree(25,value3);
        MyTree test4 = new MyTree(40,value4);
        
        test.setRightchild(test1);
        test1.setRightchild(test2);
        test2.setLeftchild(test3);
        test2.setRightchild(test4);
        
        
        System.out.println(test.size());
        System.out.println(test.get(40));
        System.out.println(test.containsValue(value4));
        System.out.println(test.getParentValue().equals(searchentry));
        
        
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