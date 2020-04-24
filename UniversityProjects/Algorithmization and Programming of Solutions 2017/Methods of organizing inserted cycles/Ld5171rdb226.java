import java.util.Scanner;

public class Ld5171rdb226 {

	public static void main(String[] args) {
		int A[][] = new int[10][10];
		int i = 0, j, k, C;

		System.out.println("Julija-Anna Lisaja IRDBD01 171RDB226");
		System.out.print("Uzdevums (1/2): ");

		Scanner sc = new Scanner((System.in));
		if (sc.hasNextInt())
			k = sc.nextInt();

		else {
			System.out.println("input-output error");
			sc.close();
			return;
		}
		sc.close();

// ======================================================================

		if (k==1) {
			        
			C = 27;
			for (j=0; j<=9; j++)
			    for (i=j; i<=j+2; i++) 
			         if (i<=9) {
			            A[i][j] = C; 
			C--;
			        
				}
			         
		}
			
// ======================================================================

		else if (k == 2) {
			
			for (i = 0; i < 10; i++) {
				C = 10;
				for (j = 9 - i; j >=0; j--) 
					if (j >= 0) {
					A[i][j] = C;
					C--;
					
					}
				}	
			}		

// ======================================================================

		else {
			System.out.println("input-output error");
			return;
		}
		
// ======================================================================

		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
	}
}
