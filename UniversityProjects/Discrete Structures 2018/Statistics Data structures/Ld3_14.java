import java.util.*;

         class arrayQueue {

            protected int Queue[] ;
            protected int front, rear, size, len;

            public arrayQueue(int lenght) {
            	
                size = lenght;
                len = 0;
                Queue = new int[size];
                front = -1;
                rear = -1;
            }    

            // EMPTY
            public boolean isEmpty() {
                return front == -1;
            }    

            // FULL
            public boolean isFull() {
                return front==0 && rear == size -1 ;
            }    

            // GET SIZE
            public int getSize() {
                return len ;
            }    

            // FRONT ELEMENT
            public int peek() {
                if (isEmpty())
                   throw new NoSuchElementException("Elementu skaits ir parsniegts");
                return Queue[front];
            }    
            
            // INPUT NEW ELENENT
            public void insert(int i) {

                if (rear == -1) {
                    front = 0;
                    rear = 0;
                    Queue[rear] = i;

                } else if (rear + 1 >= size)
                    throw new IndexOutOfBoundsException("Elementu skaits ir parsniegts");

                else if ( rear + 1 < size)
                    Queue[++rear] = i;    
                len++ ;    
            }    

            // REMOVE
            public int remove() {

                if (isEmpty())
                   throw new NoSuchElementException("Rinda ir tuksa, nav ko dzest!");
                else {

                    len-- ;
                    int ele = Queue[front];
                    if ( front == rear) {
                        front = -1;
                        rear = -1;

                    } else
                        front++;                

                    return ele;
                }        
            }

            public void display() {

                System.out.print("Rinda = ");
                if (len == 0) {

                    System.out.println("Tuksa");
                    return ;
                }

                for (int i = front; i <= rear; i++)
                    System.out.print(Queue[i]+ " ");
                System.out.println();        

            }
            
            // NEGATIVE ELEMENTS
            public int negative() {
                if (len == 0) {
                    return 0;
                }
                int k = 0;
                for (int i = front; i <= rear; i++) if(Queue[i]<0) k++;
    			return k;
            }
        } 

        public class Ld3_14 {

            public static void main(String[] args) {
            	
            	System.out.println("Julija Anna Lisaja, RDBIO 1, 171rdb226");
            	System.out.println(" ");
            	System.out.println("Pieprasījums lietotājiem :");
            	System.out.println("1 - Ievadit tikai skaitli. Burtiem (Y/N/y/n) jaievada, kad programma pieprasa atļauju turpināt darbu");
            	System.out.println("2 - Ir atlauta ievadit ne vairak, ka 10 elementus");
            	System.out.println("3 - True = patiess; False = aplams");
            	System.out.println(" ");
            	System.out.println("Patikamu darbu!");
            	System.out.println(" ");

                Scanner sc = new Scanner(System.in);
                
                boolean isNumber = false; 
                int lenght = 0;
                
               
                
                System.out.println("Ievadit elementa velamo daudzumu (mak. daudzums - 10) : ");
                while(!isNumber) {
                	
                if (sc.hasNextInt()){ 
    				lenght = sc.nextInt();

    				if ((lenght <= 0) || (lenght > 10)){
    					System.err.println(" Kluda! Nav iespējams izveidot rindu! ");
    					
    				} else {
    					isNumber = true;
    				}
    				
    			} else {
    				System.out.println("Ludzu, ievadit CIPARUS no 1 lidz 10!");
    				System.out.println();  
    				sc.next();
    			}
          }
                arrayQueue q = new arrayQueue(lenght);  
                
                char option;

                do {
                	System.out.println(" ");
                	System.out.println("Vektoriala forma attelota rinda 1, 2b, 3b, 4, 5b");
                	System.out.println("********************************OPCIJAS**************************************");
                    System.out.println("1. pievienot jaunu elementu ( add )");
                    System.out.println("2. nonemt elementu ( remove )");
                    System.out.println("3. peek");
                    System.out.println("4. tuksumas parbaude ( check empty )");
                    System.out.println("5. pilnibas parbaude ( check full )");
                    System.out.println("6. izmers ( Size )");
                    System.out.println("7. izvadit negativus elementus");
                    System.out.println("*****************************************************************************");
                    
                    System.out.println("Izvelieties vajadzigo darbibu");

                    int choice = 0;
                    
                    if (sc.hasNextInt()) {
                    	choice = sc.nextInt();  	
                    } else {
                    	System.err.println("");
                    }
                    switch (choice) {

                    case 1 : 
                    	System.out.println("Ievadit velamo elementu : ");
                        try {
                            q.insert( sc.nextInt() );
                        } catch(Exception e) { System.out.println("Error : " + e.getMessage()); 
                        System.exit(1);
                        }    
                        System.out.println(" ");
                        break;                                                 

                    case 2 : 
                        try {
                            System.out.println("Removed Element = "+ q.remove());
                        } catch(Exception e) { System.out.println("Kluda : " + e.getMessage());
                        }
                        System.out.println(" ");
                        break;                         

                    case 3 : 
                        try {
                            System.out.println("Pirmais Elements ( Peek Element ) = " + q.peek());
                        } catch(Exception e) { System.out.println("Kluda : " +e.getMessage()); 
                        System.exit(1);
                        }
                        System.out.println(" ");
                        break;                            

                    case 4 : 
                        System.out.println("Tuksuma statuss ( Empty ) = " + q.isEmpty());
                        System.out.println(" ");
                        break;                

                    case 5 : 
                        System.out.println("Pilnibas statuss ( Full ) = " + q.isFull());
                        System.out.println(" ");
                        break;                          

                    case 6 : 
                        System.out.println("Izmers ( Size ) = " + q.getSize());
                        System.out.println(" ");
                        break;             
                        
                    case 7 : 
                        System.out.println("Negativi elementi = " + q.negative());
                        System.out.println(" ");
                        break; 

                    default : System.err.println("Nepareizi ievaddati! ");
                        break;
                    }

                    q.display();            
                    System.out.println("\nVai velaties turpinat lietot programmu? (Type y (yes) or n (no))\n");
                    
                    option = sc.next().charAt(0);

                } while (option == 'Y'|| option == 'y');      
                
                if (option == 'N'|| option == 'n') {
                	System.out.println("PALDIES PAR PROGRAMMAS IZMANTOSANU!");
                } else {
                	System.err.println("Programma nevar turpinat stradat! Ludzu, atjaunot programmu (Ctrl + F11)");
                }
                sc.close();
            }    
        }