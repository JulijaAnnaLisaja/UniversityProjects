import java.util.Scanner;

public class Ld1171rdb226 {

	public static void main (String [] args){
			
			System.out.println("Julija-Anna Lisaja IRDBD01 171RDB226");
			
			Scanner sc = new Scanner(System.in);
			float x=0, y=0;
			
			System.out.print("x=");
			if (sc.hasNextFloat())
				x = sc.nextFloat();
			else {
				System.out.println("Input-output error");
				sc.close();
				return;
			}
			
			System.out.print("y=");
			if (sc.hasNextFloat())
				y = sc.nextFloat();
			else {
				System.out.println("Input-output error");
				sc.close();
				return;
			}
			sc.close();

			
			if ((x>=4 && x<6 && y>=3 && y<=5)
				|| (x>=6 && x<=7 && y>= 3 && y <5
				|| (x>=7 && x<=8 && y>=3 && y<=5)
				|| (x>6 && x<=7 && y>5 && y<=11)
	 			|| x>=6 && x<=7 && y>11 && y<=12))  
			System.out.println("red");
			
			else
				if (((x-6)*(x-6)+(y-8)*(y-8)<=9) && x>=3 && x<=6 && y>=5 && y<=11)
				System.out.println("green");
			
				else
					if ((y>=7-x && x>=2 && x<4 && y>=3 && y<=5) || ( x>8 && y>=x-5 && y<=5 && y>=3))
					System.out.println("blue");
			
					else
						System.out.println("white");

			}	
	}

	// • balta un sarkana - sarkana;
	// • balta un zaļa - zaļa;
	// • balta un zila - zila;
	// • sarkana un zaļa (vai sarkana, zaļa un balta) - zaļa;
	// • sarkana un zila(vai sarkana, zila un balta) - sarkana;
	// • zaļa un zila (vai zaļa, zila un balta) - zaļa;
	// • sarkana, zaļa un zila (vai sarkana, zaļa, zila un balta) - zaļa.







