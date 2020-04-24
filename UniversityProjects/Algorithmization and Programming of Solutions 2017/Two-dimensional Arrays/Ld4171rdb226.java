import java.util.Random;
import java.util.Scanner;

public class Ld4171rdb226 {

		public static void main(String[] args) {
			
			double A[][] = {{0.5, 0.5, 0.5, 0.5, 0.5},
					 		{0,  1,   0,   1, 	1},
					 		{0.5, 1, 0.5,  0.5, 0},
					 		{0,  0.5,  0,  0.5, 0},
					 		{1,  1,   1,   1, 	1},
					 		{0,  0,   0, 0.5, 0.5},
					 		{0,  0.5,  0,  0,   1}};
			
			int i, j; 
			int s = 0;
			int NullCount;
			String ch = "n";
			
			System.out.println("Jūlija-Anna Lisaja IRDBD01 171RDB226");
			
			System.out.println(
				"Aizpildīt masīvu ar patvaļīgiem skaitļiem (Y vai y - ya/N vai n - ne)? ");
			
			System.out.print("Jusu atbilde:    ");
			Scanner sc = new Scanner(System.in);

			if (sc.hasNext()) {
				ch = sc.next();
			}
			else {
				System.out.println("input-output error");
				sc.close();
				return;
			}
			sc.close();
			
			Random rnd = new Random();
			if (ch.equals("Y") || ch.equals("y")) {
				for (i=0; i<7; i++)
					for (j=0; j<5; j++)
						A[i][j] = rnd.nextInt(3)*0.5;
			}
			else
				if (!ch.equals("N") && !ch.equals("n")) {
					
					System.out.println("input-outpu error");
					return;
				}
			
			for (i = 0; i<7; i++) {
				for (j = 0; j<5; j++)
					System.out.print(A[i][j] + "\t");
				System.out.println();
				
			}
			
			// Izvadit ekrana to sportistu skaitu, kas neuzvareja neviena no partijam.
			
			System.out.println("results:");
			
			for (i=0; i<7; i++) {
				NullCount = 0;
				for (j=0; j<5; j++) {
					if (A[i][j] == 0 || A[i][j] == 0.5 ) NullCount++;
			
					}
				
				if (NullCount==5)
					s=s+1;
			}
					System.out.print(s);					
		}
}
