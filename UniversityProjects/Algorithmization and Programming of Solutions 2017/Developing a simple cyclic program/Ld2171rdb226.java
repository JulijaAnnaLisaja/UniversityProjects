import java.util.Scanner;

//--------Pirma--Posma--------//

public class Ld2171rdb226 {

	public static void main(String[] args) {
		double v0, x,y;
		double al = 50 , g = 23.95 , t = 0;
		
		System.out.println("Julija Anna Lisaja IRDBD01 171RDB226");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("v0=");
		if(sc.hasNextDouble()) {
			v0 = sc.nextDouble();
		} else {
			System.out.println("input-output error");
			sc.close();
			return;
			
		}
		
		sc.close();

//--------Otra--Posma--------//		
		
		System.out.println("t  \t  x \t  y");
		
		while(true) {
			t = t + 0.05;
			x= v0*t*Math.cos(Math.toRadians(al));
			y = ((v0*t*Math.sin(Math.toRadians(al)))- ((g* (t*t) )/2));
			System.out.printf("%3.2f\t%7.3f\t%7.3f\n", t, x, y);
			
			//kaujas lauks - C
					
				if((x >= 17) && (x <= 20) && (y <= 3) && (y >= 0)) {
					System.out.println("the target was destroyed");
					break;
				}
				if (  (y<0) || ((x>=7) && (y<=4) && (x<=10) && (y>0)) ){
					System.out.println("shot off the target");
					break;
				}
			}
		}
	}
