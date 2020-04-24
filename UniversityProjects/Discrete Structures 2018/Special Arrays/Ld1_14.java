import java.util.*;

public class Ld1_14 {
		
		//Linear Search
		public static void MyLinearSearch(int b[]) {
			int i;
			int temp = -1;
			boolean liner = false;
			Scanner sc = new Scanner(System.in);
	
			System.out.println("Ievadiet elementa numuru: ");
			
			if(sc.hasNextInt()) {
				temp = sc.nextInt();
			} else {
				System.out.println("Ievadisanas kluda");
				sc.close();
				return;
			}
			
			for(i = 0;i<b.length;i++) {
				if (temp==b[i]) {
					if(liner == false) {
						System.out.println("Elements " + temp + " pozicija(-s): ");
						liner = true;
					}	
					System.out.println((i + 1) + " ");
				}
			} 
			if(liner) {
				System.out.print("");
				
			}else{
				System.out.println("So elementu nav vektora!");
			}
			sc.close();
		}
		
		//Insertion Sort
		public static int[] InsertionSort(int []b) {
			int temp;
			int k = b.length;
			for(int i = 1; i < k ; i++) {
				for(int j = i; j > 0; j--) {
					if(b [j-1] < b [j]) {
						temp = b [j];
						b [j] = b [j-1];
						b [j-1] = temp;
					}
				}
			}
			return b;
		}
		
		public static void main (String[]args) {
		
			System.out.println("Julija Anna Lisaja RDBIO 1 171rdb226");
			System.out.println("********************************************************************************");
			// 1, 2, 3a, 4b, 5
			int[][] a = new int[10][10];
			int[] b = new int [55];
			int i;
			int j;
			int g = 0;
			Random rand = new Random();
			
			// 1 - apakseja trijsturakreisa matrica
			System.out.println("Apakseja kreisa trijsturmatrica:");
			
			for (i = 0; i < 10; i++)
				for (j = 0; j < 10; j++)
					if (i<j) {
			            a[i][j] = 0;
					}else{
			            a[i][j] = rand.nextInt(99) + 1;
					}
			
			for(i = 0; i<10; i++) {
				for(j =0; j<10; j++) 
			
				System.out.printf(a[i][j] + "\t ");
				System.out.println();
				
			}
			// 2 - Vektora elementus
			System.out.println("********************************************************************************");
			System.out.println("Vektora elementus:");
			for (i = 0; i <= 9; i++) {
				for (j = 0; j <= i; j++) {
					
					b[g] = a[i][j];
					g++;}
			}
				for (g = 0; g < 55; g++)
					System.out.print(b[g] + " ");
			
			
			// 3a - Linear Search
			System.out.println(" ");
			System.out.println("********************************************************************************");
			MyLinearSearch(b);
				
			// 4b - Insertion Sort
			System.out.println("********************************************************************************");
			InsertionSort(b);
			System.out.println("Elementu dilstosa kartosana (sakartota ar Insertion Sort): ");
			
			// 5 - sakārtotā vektora izvade uz ekrāna
			for (g = 0; g < 55; g++) {
			System.out.print(b[g] + "   ");
			
			}
		}
	}