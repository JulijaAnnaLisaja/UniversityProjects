import java.util.Random;
import java.util.Scanner;

public class Ld3171rdb226 {
	
	public static void main(String[] args) {
		
		int A[] = new int[10];
		int B[] = new int[10];
		int C[] = new int[20];
		int K, i=0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Julija-Anna Lisaja IRDBD01 171RDB226");	
		System.out.print("K=");
		if (sc.hasNextInt())
			K = sc.nextInt();
		
		else {
			System.out.println("input-output error");
			sc.close();
			return;
		}
		sc.close();

		// ========= 1. uzd. - for		
		
		if (K==0) {
			Random r = new Random();
			for (i=0; i<10; i++) {
				A[i] = r.nextInt(20);
				B[i] = (r.nextInt(50)+50);
			}			
		}
		
		else {
			for (i=0; i<10; i++) {
				A[i] = i+K;
				B[i] = (i+10)*K;
			}	
		} 
		
		// ========= 2. uzd. - for
		
		System.out.println("A:");
		
		
		for(i=0; i<10; i++) {
			System.out.printf("%5d",  A[i]);
			if (i==9) System.out.println();
		}	
		
		System.out.println(" ");
		System.out.println("B:");
		
		i=0;
		while (i<10){
			System.out.printf("%5d",  B[i]);
			if (i==9) System.out.println();
			i++;
		} 
		
	// ========= 3.uzd. - while
		
		int m=0;
		int j = 0;
		while (j<10) {
			C[m]=A[j];
			m++;
			C[m]=B[j];
			m++;
			j++;
			}
		System.out.println();
		
	// ========= 4.uzd. - do while
		
		System.out.println("C:");
		j=0;
		do {
			System.out.printf("%5d",  C[j]);
			if (j==9) System.out.println();
			j++;
		} while (j<20);
				
			}
	}

	