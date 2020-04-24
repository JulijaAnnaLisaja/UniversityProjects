#include <stdio.h> 
#include <math.h>

int main() {

	float x, y;
	float res;
	
	printf("Julija Anna Lisaja - 17rdb226\n");
	
	do {
		printf("Enter value for x\n");
		do {	
		
		res = scanf("%f", &x);
		if ((0<= x) && (x!=2) && (x<=10)) {

		while (getchar() != '\n');
		
		if (res == 1) { printf("%s", "Good input!\n");
		} else { printf("%s", "Wrong input! Try again!\n"); } 
		} else {
		    printf("%s", "Bad input for x!\n");
			printf("%s", "OPERATION BREAK\n");
		    return 0; }
		} while (res != 1);
		
		printf("You enter value:  %f\n", x);
	
		float a = sqrt(10*x-powf(x,2));
		float b = (10*x-4)/(2*x-4);
	
		printf("a:  %f\n", a);
		printf("b:  %f\n", b);
	
			if (a>=b) {
			printf("Condition a>=b is TRUE\n");
			float f1 = ((a+powf(b,2))/5);
			printf("y:  %.3f\n", f1);
			} else {
			printf("Condition a>=b is FALSE\n");
			float f2 = (((powf(a,2))/2) + (b/10));			
			printf("y:  %.3f\n", f2);	}	

	} while (restart());
	//return 0;
	} 	
	int restart() {
	printf("Input y if you want to continue\n");
	char c;
	scanf("%c", &c);
	if(c == 'y') { //getchar();
	return 1; }
	else { 
	printf("Goodbye!\n");
	return 0; } }