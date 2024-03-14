#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
#include<stdbool.h>

int readConstants() {
	FILE* ptr;
	ptr = fopen("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt", "r");
	if (NULL == ptr) {
		printf("can't open file \n");
	}
	char line[20], ch;
	bool ok = false;
	strcpy(line, "");
	do {
		ch = fgetc(ptr);
		while (ch != '\n' && ch != EOF) {
			strncat(line, &ch, 1);
			ch = fgetc(ptr);
		}
		if (strcmp(line, "Memory Access") == 0) {
			ok = true;
			strcpy(line, "");
			ch = fgetc(ptr);
			while (strchr("0123456789", ch) != NULL) {
				strncat(line, &ch, 1);
				ch = fgetc(ptr);
			}
			break;
		}
		strcpy(line, "");
	} while (ch != EOF);
	fclose(ptr);
	return atoi(line);
}

int NUMBER_OF_INTEGERS;

int main()
{
	NUMBER_OF_INTEGERS = readConstants();
	FILE* fPtr;
	char filePath[100] = "C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_c.txt";
	fPtr = fopen(filePath, "w");
	if (fPtr == NULL)
	{
		printf("\nUnable to open '%s' file.\n", filePath);
		exit(EXIT_FAILURE);
	}
	fprintf(fPtr, "C\n");
	fprintf(fPtr, " Masurarea accesului la memorie a unui sir cu %d intregi \n\n", NUMBER_OF_INTEGERS);
	fprintf(fPtr, "Sir static\n");
	clock_t startTime, endTime;
	int v[100000];
	double total_time_static = 0.0;
	for (int mes = 0; mes < 10; mes++) 
	{
		startTime = clock();
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
				v[i] = i;
		}
		endTime = clock();
		double mes_duration = (double)(endTime - startTime) / (double)(CLOCKS_PER_SEC * 100);
		total_time_static += mes_duration;
	}
	double mean_static = total_time_static / 10;
	fprintf(fPtr, "Media %.6f secunde\n\n", mean_static);
	fprintf(fPtr, "\nSir dinamic\n");
	int* v2 = (int*)malloc(NUMBER_OF_INTEGERS * sizeof(int));
	double total_time_dynamic = 0.0;
	for (int mes = 0; mes < 10; mes++) {
		startTime = clock();
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
				v2[i] = i;
		}
		endTime = clock();
		double mes_duration = (double)(endTime - startTime) / (double)(CLOCKS_PER_SEC * 100);
		total_time_dynamic += mes_duration;
	}
	double mean_dynamic = total_time_dynamic / 10;
	fprintf(fPtr, "Media %.6f secunde\n", mean_dynamic);

	free(v2);
	fclose(fPtr);

	return 0;
}