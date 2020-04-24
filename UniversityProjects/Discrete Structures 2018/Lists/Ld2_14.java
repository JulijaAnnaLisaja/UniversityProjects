import java.util.Scanner;
     
    
    class linkedList{
        protected Node first, last;
        public int size;
        
        public linkedList(){
            first = null;
            last = null;
            size = 0;
        }

        // Case 1:
        public void insert(int val){
            Node nptr, print, tmp = null;
            nptr = new Node(val, null);
            boolean ins = false;
            if (first == null){
                first = nptr;
                nptr.setLink(first);
                last = first;
            }
            else if (val <= first.getData()){
                nptr.setLink(first);
                last.setLink(nptr);
                first = nptr;
            }
            else if (val >= last.getData()){
                last.setLink(nptr);
                nptr.setLink(first);
                last = nptr;
                
            } else {
                tmp = first;
                print = first.getLink();
                while (tmp != last){
                    if (val >= tmp.getData() && val <= print.getData()){
                        tmp.setLink(nptr);
                        nptr.setLink(print);
                        ins = true;
                        break;
                        
                    } else {
                        tmp = print;
                        print = print.getLink();
                    }
                }
                if (ins == false){
                    tmp.setLink(nptr);
                }
            }
            size++;
        }

        // Case 2:
        public void deleteAtPos(int position){
            if (position == 1 && size == 1){
                first = null;
                last = null;
                size = 0;
                return;
            }
            
            if (position == 1){
                first = first.getLink();
                last.setLink(first);
                size--; 
                return ;
            }
            
            if (position == size){
                Node print = first;
                for (int i = 1; i < size - 1; i++)
                    print = print.getLink();
                print.setLink(first);
                last = print;            
                size --;
                return;
            }
            
            Node print = first;
            position = position - 1 ;
            for (int i = 1; i < size - 1; i++){
                if (i == position){
                    Node tmp = print.getLink();
                    tmp = tmp.getLink();
                    print.setLink(tmp);
                    break;
                }
                print = print.getLink();
            }
            size-- ;
        }    
           
        
        // Case 3:
        public boolean isEmpty(){
            return first == null;
        }
        
        // Case 4:
        public int getSize(){
            return size;
        } 
        
     // Case 5:
        public int getF(){
            return size;
        } 
        

        /*  Function to display elements  */
        public void display(){
        	
            System.out.println("Saraksta esošo elementu skaits : ");
            
            Node print = first;
            if (size == 0){
                System.out.print("Saraksts ir tukss");
                return;
                
            }
            
            if (first.getLink() == first){
                System.out.print(first.getData() + " ==> "+print.getData()+ "\n");
                return;
            }
            
            System.out.print(first.getData() + " ==> ");
            print = first.getLink();
            while (print.getLink() != first){
                System.out.print(print.getData( ) + " ==> ");
                print = print.getLink();
                
            }
            
            System.out.print(print.getData() + " ==> ");
            print = print.getLink();
            System.out.print(print.getData() + "\n");
            
        }  
        
        
        // Case 6
        public int equalNull(){
        	int i = 0;
            Node print = first;
            if (size == 0){
                System.out.print("Saraksts ir tukss");
                return i;
            }
            print = first;
            while (print.getLink() != first){
                if(print.getData() == 0){
                	System.out.println("Parbaude: "+ print.getData() );
                	i++;

            }
                print = print.getLink();
            }
            if (print.getLink() == first){
                if(print.getData() == 0) i++;
            }
            return i;
        }
    }
    
//-------------The--Body--Of--The--Class------------------------------------------------------------------
    
    public class Ld2_14{
        public static void main(String[] args){ 
        	
        	System.out.println("Julija Anna Lisaja, RDBIO 1, 171rdb226");
        	System.out.println("********************************************************************************");
        	System.out.println("Pieprasījums lietotājiem :");
        	System.out.println("1 - Ievadit tikai skaitli. Burtiem (Y/N/y/n) jaievada, kad programma pieprasa atļauju turpināt darbu");
        	System.out.println("2 - Ir atlauta ievadit ne vairak, ka 10 elementus");
        	System.out.println("3 - True = patiess; False = aplams");
        	System.out.println("-");
        	System.out.println("Patikamu darbu!");
        	System.out.println("-");
            Scanner sc = new Scanner(System.in);
            
            linkedList list = new linkedList();         
            char option = 0;
            int choice = 6;
            
            do{
            	System.out.println(" ");
            	System.out.println("Sakartotais vienkarssaistīts cirkulars saraksts, 1, 2b, 3, 4, 5b");
            	System.out.println("***************************INTERFACE*****************************");
            	
                System.out.println("1. Pievienot elementu");
                System.out.println("2. Nonemt elementu pozīcijā");
                System.out.println("3. Parbaudiet tuksumu");
                System.out.println("4. Iegust saraksta lielumu");
                System.out.println("5. Parbaudiet vai saraksta ir 10 elementus");
                System.out.println("6. Izvadit elementus, kuri ir vienādi ar 0");
                
                System.out.println("*****************************INPUT******************************");
                

                System.out.print("Izvelieties opciju :                         ");
                        
                if(sc.hasNextInt()) {
    				choice = sc.nextInt();
    				
    			} else {
    				System.out.println("-");
    				break;
    			}
                          
                switch (choice) {
                case 1 : 
    				if(list.getSize() < 10){
	                    System.out.print("Ievadit elementu:                            ");                   
	                    if(sc.hasNextInt()) {
		                	list.insert( sc.nextInt() );
			        	} else {
			        		System.out.println(" ");
			        		break;
			        	}
	                    
                	} else {
                		System.err.println("Saraksts ir pilns");
                	}
    				
                    break;   
                case 2 : 
                	
                	System.out.println("-");
                	
                	
                	if(list.isEmpty()) {
    					System.out.println("Saraksts nav izveidots");
    				} else {
    					System.out.print("Ievadiet poziciju :                          ");
    					int p = 0;
    					if(sc.hasNextInt()) {
    						p = sc.nextInt(); 
    					} else {
    						System.out.println("-");
    						break;
    					}
    					if (p < 1 || p > list.getSize() )
    						System.out.println("Ievadisanas kluda");
    					else
    						list.deleteAtPos(p);
    				}
                	break;
                	
                case 3 : 
                	System.out.println("-");
                    System.out.println("Tuksuma statuss :                          " + list.isEmpty());
                    System.out.println(" ");
                    break;       
                    
                case 4 : 
                	System.out.println("-");
                    System.out.print("Izmers :                                     " + list.getSize());
                    System.out.println(" ");
                    break;
                    
                case 5 :
                	
                	if(list.isEmpty()) {
    					System.out.println("Saraksts nav izveidots");
    				} else {
    					if(list.getSize() < 10) System.out.println("Saraksts NAV pilns");
    					else System.out.println("Saraksts IR pilns");
    				}
                	System.out.println(" ");
                	break;
                	
                case 6 :
                	System.out.print("Elementus vienads ar 0 :                     " + list.equalNull() );
                	System.out.println(" ");
                	break;
                    
                default : 
                    System.err.println("Ievadisanas kļūda");
                    break;   
                }
                
                list.display();
                System.out.println("");
                System.out.println("Vai vēlaties turpināt lietot programmu? (Type y (yes) or n (no))");
                System.out.println("-");
                
                option = sc.next().charAt(0);            
                
            } while (option == 'Y'|| option == 'y'); 
     
            
            if (option == 'N'|| option == 'n') {
            	System.out.println("Paldies pār programmas izmantošanu!");
            } else {
            	System.err.println("Ievadisanas kluda. Ludzu, atjaunot programmu (Ctrl + F11)");
            }
            
            sc.close();
        }
    }
    
//-------GETTERS--AND--SETTERS---------------------------------------------------------------------------------------   
    

    class Node{
        protected int data;
        protected Node link;
     

        public Node(){
            link = null;
            data = 0;
        }    


        public Node(int d,Node n){
            data = d;
            link = n;
        }    


        public void setLink(Node n){
            link = n;
        }    


        public void setData(int d){
            data = d;
        }    


        public Node getLink(){
            return link;
        }    


        public int getData(){
            return data;
        }
    }