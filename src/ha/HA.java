package ha;

import de.tu_bs.ips.NextFunction;
import java.util.Scanner;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class HA {
        
    public static void main(String[] args) {
        /*
        int a = 30;
        int b = 20;
        int c = 22;
        int d = 40;
        int e = 33;
        int f = 34;
        int g = 21;
        */
        
        int a = 30;
        int b = 20;
        int c = 22;
        int d = 40;
        int e = 33;
        int f = 42;
        int g = 50;
        
        Integer[] values = {1,1,1};
        Integer[] values1 = {2,2,2};
        Integer[] values2 = {3,3,3};
        Integer[] values3 = {4,4,4};
        Integer[] values4 = {5,5,5};
        Integer[] values5 = {6,6,6};
        Integer[] values6 = {7,7,7};
        Integer[] search = {1,1,1};
        Integer[] replace = {100,100,100};
        
        de.tu_bs.ips.Entry value = new de.tu_bs.ips.Entry(values);
        de.tu_bs.ips.Entry value1 = new de.tu_bs.ips.Entry(values1);
        de.tu_bs.ips.Entry value2 = new de.tu_bs.ips.Entry(values2);
        de.tu_bs.ips.Entry value3 = new de.tu_bs.ips.Entry(values3);
        de.tu_bs.ips.Entry value4 = new de.tu_bs.ips.Entry(values4);
        de.tu_bs.ips.Entry value5 = new de.tu_bs.ips.Entry(values5);
        de.tu_bs.ips.Entry value6 = new de.tu_bs.ips.Entry(values6);
        de.tu_bs.ips.Entry searchentry = new de.tu_bs.ips.Entry(search);
        de.tu_bs.ips.Entry replaceentry = new de.tu_bs.ips.Entry(replace);
        
        MyTree test = new MyTree();
        
        test.put(a,value);
        test.put(b,value1);
        test.put(c,value2);
        test.put(d,value3);
        test.put(e,value4);
        test.put(f,value5);
        test.put(g,value6);
        System.out.println("\nSize:");
        System.out.println(test.size());
        
        System.out.println("\nElement " + a + ":");
        System.out.println(test.getElement(a).getParentKey());
        System.out.println(test.getElement(a).getParentValue());
        System.out.println(test.getElement(a).getRoot());
        System.out.println("\nElement " + b + ":");
        System.out.println(test.getElement(b).getParentKey());
        System.out.println(test.getElement(b).getParentValue());
        System.out.println(test.getElement(b).getRoot().getParentKey());
        System.out.println("\nElement " + c + ":");
        System.out.println(test.getElement(c).getParentKey());
        System.out.println(test.getElement(c).getParentValue());
        System.out.println(test.getElement(c).getRoot().getParentKey());
        System.out.println("\nElement " + d + ":");
        System.out.println(test.getElement(d).getParentKey());
        System.out.println(test.getElement(d).getParentValue());
        System.out.println(test.getElement(d).getRoot().getParentKey());
        System.out.println("\nElement " + e + ":");
        System.out.println(test.getElement(e).getParentKey());
        System.out.println(test.getElement(e).getParentValue());
        System.out.println(test.getElement(e).getRoot().getParentKey());
        System.out.println("\nElement " + f + ":");
        System.out.println(test.getElement(f).getParentKey());
        System.out.println(test.getElement(f).getParentValue());
        System.out.println(test.getElement(f).getRoot().getParentKey());
        System.out.println("\nElement " + g + ":");
        System.out.println(test.getElement(g).getParentKey());
        System.out.println(test.getElement(g).getParentValue());
        System.out.println(test.getElement(g).getRoot().getParentKey());
        
        System.out.println("\nPrint Tree Asc:");  
        System.out.println(test); 

        System.out.println("\nElement " + c + ":");
        System.out.println(test.getElement(c).getParentKey());
        System.out.println(test.getElement(c).getParentValue());
        System.out.println(test.getElement(c).getRoot().getParentKey());
        System.out.println("\nElement " + e + ":");
        System.out.println(test.getElement(e).getParentKey());
        System.out.println(test.getElement(e).getParentValue());
        System.out.println(test.getElement(e).getRoot().getParentKey());
        System.out.println("\nElement " + g + ":");
        System.out.println(test.getElement(g).getParentKey());
        System.out.println(test.getElement(g).getParentValue());
        System.out.println(test.getElement(g).getRoot().getParentKey());
                
        System.out.println("\nReplace Element " + a + ":");        
        System.out.println(test.replace(a, replaceentry));
        System.out.println("\nNew Element " + a + ":");
        System.out.println(test.getElement(a).getParentKey());
        System.out.println(test.getElement(a).getParentValue());
                
        System.out.println("\nIterator:");
        Iterable testiterator = test;                            
        for (Object tree : testiterator) {
            System.out.println(tree);
        }
        
        System.out.println("\nRemove Element " + c + ":");
        System.out.println(test.remove(c));
        test.getBranches().delete(c);
        System.out.println("\nNew Size:");
        System.out.println(test.size());      
        
        
        System.out.println("\nIterator2:");
        Iterable testiterator2 = test;                            
        for (Object tree : testiterator2) {
            System.out.println(tree);
        }


        

        
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