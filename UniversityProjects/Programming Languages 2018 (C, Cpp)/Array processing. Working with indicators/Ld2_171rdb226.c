#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// Random Function
void MyRandom(float **arr1, int row1, int col1) {
	int i, j;
	
	srand((unsigned)time(NULL));
	for (i = 0; i < row1; i++) {
	for (j = 0; j < col1; j++) {
			
			// Random from -50 to 50
			arr1[i][j] = (rand() % 10000 - 10000 / 2) / 100.0; 
		} } }

// Create Array Function
void MyArray(float ** arr2, int row2, int col2) {
	int i, j;
	float res;
	
	for (i = 0; i < row2; i++) {
		for (j = 0; j < col2; j++) {
			printf("Input element : ");
		do {	
		res = scanf("%f", & arr2[i][j]);
		while (getchar() != '\n');
		if (res == 1) { printf("%s", "Good input!\n");
		} else { printf("%s", "Wrong input!\n");  
		    exit(0); }
		} while (res != 1);
		} } }

// Display Array Function
void MyDisplay(float **arr3, int row3, int col3) {
	int i, j;
	printf("*****************************************\n");
	printf("Final Array:\n");
	for (i = 0; i < row3; i++) {
		for (j = 0; j < col3; j++) printf("%.2f \t", arr3[i][j]); printf("\n");
	} }

// Array Elements
int MyOneDimArr(float *arr4, int row4) {
	int num;
	printf("*****************************************\n");
	printf("Largest array elements:\n");
	for (num = 0; num < row4; num++) printf("%.2f \t", *(arr4 + num));
	free(arr4);
	return *arr4;
}

// Find Max Element
void CreateMyArray(float **arr5, int row5, int col5) {
	int i, j;
	float maxNum;
	float *newArr = (float*)malloc(sizeof(int)*row5);
	for (i = 0; i < row5; i++) {
		maxNum = arr5[i][0];
		for (j = 1; j < col5; j++) {
			if (arr5[i][j]> maxNum) maxNum = arr5[i][j];
		}
		*(newArr + i) = maxNum;
	}
	MyOneDimArr(newArr, row5);
}

int main(int manual, char *random[]) {
	printf("*****************************************\n");
	printf("171RDB226 Julija Anna Lisaja 1. grupa \n");
	printf("6. variants \n");
	printf("*****************************************\n");
	
	int a, b, tmp;
	float **arr;
	printf("Enter the number of rows:     ");
	if ((scanf("%d", &a)) != 1)
		printf("Bad Input! Try again!\n");

	printf("Enter the number of columns:  ");
	if ((scanf("%d", &b)) != 1)
		printf("Bad Input! Try again!\n");
 
	arr = (float**)malloc(sizeof(int*)*a);
	for (tmp = 0; tmp < a; tmp++)
		arr[tmp] = (float*)malloc(sizeof(int)*b);

// Manual Input
	if (manual < 2) {
		printf("*****************************************\n");
		printf("Elements are entered by user manually\n");
		MyArray(arr, a, b);
		MyDisplay(arr, a, b);
		CreateMyArray(arr, a, b);
		
// Random Generation		
	} else {
		if (strcmp(random[1], "-rand") == 0) {
		printf("*****************************************\n");
			printf("Random generation \n");
			MyRandom(arr, a, b);
			MyDisplay(arr, a, b);
			CreateMyArray(arr, a, b);
			
	} else {
		printf("*****************************************\n");
			printf("Elements are entered by user manually\n");
			MyArray(arr, a, b);
			MyDisplay(arr, a, b);
			CreateMyArray(arr, a, b);
		}
	}
	for (tmp = 0; tmp < a; tmp++) free(arr[tmp]);
	printf("\n");
	printf("*****************************************\n");
	printf("Programm Ends Here\n");
	free(arr);
	return 0;
}
