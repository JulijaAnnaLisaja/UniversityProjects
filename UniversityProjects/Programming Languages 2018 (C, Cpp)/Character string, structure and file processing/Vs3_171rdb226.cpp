
#include "pch.h"
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>	
#include <fstream>

const  int SIZE = 50;
using namespace std;

// STRUCTURE
struct num {
	char Prieks[50];		// Priekšmets
	char Pasn[50];			// Pasniedzējs
	char GruppNr[25];		// Grupas numurs 
	char NedDien[4];		// Nedēļas dienas
	int Aud;				// Auditorija
};

// WRITE ARRAY RESULT
void ArrayResult(num *arr, int arr_size) {
	int a;
	cout << "\n" << " ________________________________________________________________________________________";
	cout << "\n" << "||" << "\t" << "Prieksmets" << "\t" << "||" << "\t" << "Pasn.   " << "||" << "\t" << "Gr. Nr  " << "||" << "  Ned. Dien   " << "||" << "\t" << "Aud" << "\t" << "||";
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	
	for (a = 0; a < arr_size; a++) {

		cout << "\n" << "||" << "\t" << arr[a].Prieks << "\t" << "||" << "\t" << arr[a].Pasn << "\t" << "||" << "\t" << arr[a].GruppNr << "\t" << "||" << "\t" << arr[a].NedDien << "\t" << "||" << "\t" << arr[a].Aud << "\t" << "||";
	}

	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	cout << endl;
	return;
}

// CHECK THE DATA
bool DataChecker(char *dotw) {
	if (strlen(dotw) == 2) {
		if (!strcmp(dotw, "Pr")) return 0;
		if (!strcmp(dotw, "Ot")) return 0;
		if (!strcmp(dotw, "Tr")) return 0;
		if (!strcmp(dotw, "Ce")) return 0;
		if (!strcmp(dotw, "Pt")) return 0;
		if (!strcmp(dotw, "St")) return 0;
		if (!strcmp(dotw, "Sv")) return 0;
		return 1;
	} return 1;
}
bool IsItAudit(char *audit) {
	int i;
	for (i = 0; i < strlen(audit); i++) {
		if ((audit[i] < '0') || (audit[i] > '9')) return 0;
	}
	return 1;
}

// CHECK THE BUFFER
bool BufferChecker(char *buffer) {
	char *i1, *i2;
	bool data = false;;
	bool aud = false;

	int a = 0;

	i1 = strtok_s(buffer, ";", &i2);
	if (i1 == NULL || strlen(i1) < 1) return 0;
	a++;
	while (i1 != NULL)
	{
		a++;
		if (strlen(i1) < 1) return 0;
		if ((a == 5) && (strlen(i1) == 2)) data = !DataChecker(i1);
		if (a == 6) aud = IsItAudit(i1);
		i1 = strtok_s(NULL, ";", &i2);
	}
	data = data & aud;
	return data;
}

// CHECK IF IT IS A NUMBER
int EnterNum() {
	int num;
	do {
		cin >> num;
		cin.ignore(32767, '\n');
		if (cin.fail()) {
			printf_s("BAD INPUT! TRY AGAIN! \n");
			cin.clear();
			cin.ignore(32767, '\n');
		} else if (num >= 0) {
			return num;
		} else {
			printf_s("BAD INPUT! TRY AGAIN! \n");
		}
	} while (true);
}

// CHECK IF IT IS A SPACE
void SpaceChecker(char *tmp) {
	int i = 0;
	int j = 0;
	char newurl[50];
	bool spase = false;
	for (i = 0; i <= strlen(tmp); i++) {
		if (tmp[i] != ' ') {
			newurl[j] = tmp[i];
			j++;
		}
	} strcpy_s(tmp, 50, newurl);
}

// WRITE NEW INFORMATION INTO ARRAY
void ArrayWriter(char *tmp, num *arr, int a, int b) {
	switch (a) {
	case 1: strcpy_s(arr[b].Prieks, tmp);  break;
	case 2: strcpy_s(arr[b].Pasn, tmp);    break;
	case 3: strcpy_s(arr[b].GruppNr, tmp); break;
	case 4: strcpy_s(arr[b].NedDien, tmp); break;
	case 5: arr[b].Aud = atoi(tmp);        break;
	default:                               break;
	}
}

// INPUT INFORMATION INTO PROGRAM
void InputInformation(char *tmp, num *arr, int b) {
	char *one;
	char *two;
	int a = 1;
	if (tmp == NULL) return;
	one = strtok_s(tmp, ";", &two);
	ArrayWriter(one, arr, a, b);
	while (one != NULL) {
		one = strtok_s(NULL, ";", &two);
		a++;
		ArrayWriter(one, arr, a, b);
	}
}

// FILL ARRAY WITH INFORMATION
int FillMyArrayByFile(char *txt, num *arr) {

	char *buffer = new char[50];
	char stream[50];
	int b = 0;
	ifstream file(txt);
	ofstream fileerr("err.txt");
	while (file.getline(buffer, 50)) {
		SpaceChecker(buffer);
		strcpy_s(stream, buffer);
		if (BufferChecker(buffer)) {
			strcpy_s(buffer, 50, stream);
			InputInformation(buffer, arr, b);
			b++;
		} else { fileerr << stream << endl;
		}
	}
	fileerr.close();
	file.close();
	delete buffer;
	return b;
}

// READ MY TXT FILE
bool FileReaderTXT(char *txt) {
	bool exit = 1;
	ifstream file;
	int i;
	do {
		printf_s("Please enter prefered file name (for example: test.txt): ");
		cin >> txt;
		cin.ignore(32767, '\n');
		for (i = strlen(txt); i > 0; i--) {
			if (txt[i] == '.') {
				file.open(txt);
				if (!file)
					printf_s("File not exist!\n");
				else
					exit = 0;
				file.close();
			}
		}
		if (exit)
			printf_s("You need to input file name with .txt format!\n");
	} while (exit);
	return exit;
}

// ENTER THE NUMBER OF THE GROUP
void EnterGroupNumber(char *grupNr) {
	bool out = false;
	do {
		printf_s("Enter prefered number of the group(For example : RDB-11) :    ");
		cin >> grupNr;
		cin.ignore(32767, '\n');
		out = true;
	} while (!out);
}

// CHOOSE PREFERED NUMBER OF THE GROUP - 1.UZD
void ChooseYourGroup(num *arr, int arr_size) {
	char *groupname = new char[10];
	int a;
	EnterGroupNumber(groupname);
	cout << "\n" << " ________________________________________________________________________________________";
	cout << "\n" << "||" << "\t" << "Prieksmets" << "\t" << "||" << "\t" << "Pasn.   " << "||" << "\t" << "Gr. Nr  " << "||" << "  Ned. Dien   " << "||" << "\t" << "Aud" << "\t" << "||";
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	for (a = 0; a < arr_size; a++) {
		if (!strcmp(groupname, arr[a].GruppNr))
			cout << "\n" << "||" << "\t" << arr[a].Prieks << "\t" << "||" << "\t" << arr[a].Pasn << "\t" << "||" << "\t" << arr[a].GruppNr << "\t" << "||" << "\t" << arr[a].NedDien << "\t" << "||" << "\t" << arr[a].Aud << "\t" << "||";
	}
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	printf_s("\n");
}

// INPUT THE DAY OF THE WEEK
void TheDayOfTheWeek(char *data) {
	bool exit = true;
	do {
		printf_s("ATTENTION! Enter only first letters of the day (Pr, Ot, Tr, Ce, Pt, St, Sv)\n");
		printf_s("Enter prefered day:    ");
		cin >> data;
		cin.ignore(32767, '\n');
		exit = DataChecker(data);
		if (exit)
			printf_s("BAD INPUT! TRY AGAIN!\n");
	} while (exit);
}

// CHOOSE PREFERED NUMBER OF THE DAY - 2.UZD
void ChooseYourDay(num *arr, int arr_size) {
	char *data = new char[30];
	TheDayOfTheWeek(data);
	int a;
	cout << "\n" << " ________________________________________________________________________________________";
	cout << "\n" << "||" << "\t" << "Prieksmets" << "\t" << "||" << "\t" << "Pasn.   " << "||" << "\t" << "Gr. Nr  " << "||" << "  Ned. Dien   " << "||" << "\t" << "Aud" << "\t" << "||";
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	for (a = 0; a < arr_size; a++) {
		if (!strcmp(data, arr[a].NedDien))
			cout << "\n" << "||" << "\t" << arr[a].Prieks << "\t" << "||" << "\t" << arr[a].Pasn << "\t" << "||" << "\t" << arr[a].GruppNr << "\t" << "||" << "\t" << arr[a].NedDien << "\t" << "||" << "\t" << arr[a].Aud << "\t" << "||";
	}
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	printf_s("\n");
	delete data;
}

// CHOOSE PREFERED NUMBER OF THE AUDITORY - 3.UZD
void ChooseYourAuditory(num *arr, int arr_size) {
	printf_s("Enter prefered number of the Auditory (For Example: 123):   ");
	int choiсe = EnterNum();
	int a;
	cout << "\n" << " ________________________________________________________________________________________";
	cout << "\n" << "||" << "\t" << "Prieksmets" << "\t" << "||" << "\t" << "Pasn.   " << "||" << "\t" << "Gr. Nr  " << "||" << "  Ned. Dien   " << "||" << "\t" << "Aud" << "\t" << "||";
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	for (a = 0; a < arr_size; a++) {
		if (choiсe == arr[a].Aud) {
			cout << "\n" << "||" << "\t" << arr[a].Prieks << "\t" << "||" << "\t" << arr[a].Pasn << "\t" << "||" << "\t" << arr[a].GruppNr << "\t" << "||" << "\t" << arr[a].NedDien << "\t" << "||" << "\t" << arr[a].Aud << "\t" << "||";
		}
	}
	cout << "\n" << "||______________________||______________||______________||______________||______________||";
	printf_s("\n");
}

// MAIN CLASS (FINNALY...)
int main() {
	num *arr = new num[50];
	char *txt = new char[50];
	int arr_size = 0;

	printf_s("Julija Anna Lisaja - 171rdb226\n");
	printf_s("6. variants\n");
	printf_s("*************************************************************************************\n");

	FileReaderTXT(txt);
	arr_size = FillMyArrayByFile(txt, arr);
	bool exit = false;
	int operation;

	ArrayResult(arr, arr_size);

	do {
		printf_s("\n");

		printf_s("1) Choose prefered group number\n");
		printf_s("2) Choose prefered number of the day\n");
		printf_s("3) Choose prefered Auditory\n");
		printf_s("4) Exit\n");

		printf_s("\n");
		printf_s("Your choice:      ");

		operation = EnterNum();

		if (operation == 4) {
			exit = true;
			printf_s("\n");
			printf_s("Thanks for using the program! =>\n");
		} 
		else if (operation == 1) {
			printf_s("\n");
			ChooseYourGroup(arr, arr_size);
		}
		else if (operation == 2) {
			printf_s("\n");
			ChooseYourDay(arr, arr_size);
		}
		else if (operation == 3) {
			printf_s("\n");
			ChooseYourAuditory(arr, arr_size);
		}
		else  printf_s("BAD INPUT! TRY AGAIN!\n");
	} while (!exit);

	delete arr;
	delete txt;
	return 0;
}