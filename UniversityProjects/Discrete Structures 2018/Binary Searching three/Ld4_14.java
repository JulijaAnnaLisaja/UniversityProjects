 import java.util.Scanner;
 
 class BSTNode {
     BSTNode left, right;
     int data;
 
     public BSTNode() {
         left = null;
         right = null;
         data = 0;
     }
     
     public BSTNode(int n) {
         left = null;
         right = null;
         data = n;
     }
     
     public void setLeft(BSTNode n) {
         left = n;
     }
     
     public void setRight(BSTNode n) {
         right = n;
     }
     
     public BSTNode getLeft() {
         return left;
     }
     
     public BSTNode getRight() {
         return right;
     }
     
     public void setData(int d) {
         data = d;
     }
     
     public int getData() {
         return data;
     }     
 }
 
 class BST {
     private BSTNode root;
 
     // Constructor
     public BST() {
         root = null;
     }
     
     // EMPTY
     public boolean isEmpty() {
         return root == null;
     }
     
     // INDERT DATA
     public void insert(int data) {
         root = insert(root, data);
     }
     
     private BSTNode insert(BSTNode node, int data) {
         if (node == null)
             node = new BSTNode(data);
         else {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     
     // UMBER OF NODES
     public int countNodes() {
         return countNodes(root);
     }
     
     //  NUMBER OF NODES
     private int countNodes(BSTNode r) {
         if (r == null)
             return 0;
         else {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     
     // POSTORDER
     public void postorder() {
         postorder(root);
     }
     
     private void postorder(BSTNode r) {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }
     
     public int countEven() {
         return countEven(root);
     }
     
     private int countEven(BSTNode r) {
    	 if (r == null)
    		 return 0;

    	 int n = countEven(r.left) + countEven(r.right);
    	 if(r.data % 2 == 0)
    		 return n + 1;
    	 else
    		 return n;
     }

     public int countTwoChildren() {
         return countTwoChildren(root);
     }
     
     private int countTwoChildren(BSTNode node) {
         if(node == null) {
             return 0;
         }
         if(node.left != null && node.right != null) {
             return 1 + countTwoChildren(node.left) + countTwoChildren(node.right);
         }
         return countTwoChildren(node.left) + countTwoChildren(node.right);
     }
 }
 
 /* Class BinarySearchTree */
 public class Ld4_14 {
     public static void main(String[] args) {                 
        
    	Scanner sc = new Scanner(System.in);
    	
        BST bst = new BST();      
        char option = 0;
        
        // MAIN MENU
        do  {
        	System.out.println("Julija-Anna Lisaja, RDBIO 1, 171rdb226");
        	System.out.println("**********************MAIN-MENU********************************");
            System.out.println("Binary Search Tree Operations: 1, 2, 3d, 4b\n");
            System.out.println("1. Pievienot jaunu elementu ( insert ) ");
            System.out.println("2. Virsotnes, kuram ir divi berni; ");
            System.out.println("3. Para elementu skaits"); 
            System.out.println("***************************************************************");
            
            int choice;
            
            if(sc.hasNextInt()) {
				choice = sc.nextInt();
				
			} else {
				System.out.println();
				break;
			}
            
            switch (choice) {
            
            case 1 : 
            	if ( bst.countNodes() < 15) {
                System.out.println("Enter integer element to insert");
                
                if(sc.hasNextInt()) {
                	bst.insert(sc.nextInt() );
    				
    			} else {
    				break; 
    			}
                
            	} else {
	        		System.err.println("Binarai kokai ir maksimalais elementu skaits!");	
	        	}
                break;      
                
            case 2 : 
                System.out.println("Izvadit virsotnes, kuram ir divi berni = " + bst.countTwoChildren());
                break; 
                
            case 3 :  
                System.out.println("Para elementu skaits = "+ bst.countEven());
                break;
                
            default : 
                System.out.println("Ievadisanas kluda \n ");
                break;   
            }
            
            // INPUT TREE
            System.out.print("\nPostorderālais : ");
            bst.postorder();
            
            System.out.println(" ");
            System.out.println("Vai velaties turpinat lietot programmu? (Type y (yes) or n (no))");
            option = sc.next().charAt(0);                        
        
        } while (option == 'Y'|| option == 'y');   
      
        if (option == 'N'|| option == 'n') {
        	System.out.println("Paldies pār programmas izmantosanu!");
        	
        } else {
        	System.err.println("Ievadisanas kluda. Ludzu, atjaunot programmu (Ctrl + F11)");
        }
        sc.close();
    }
}