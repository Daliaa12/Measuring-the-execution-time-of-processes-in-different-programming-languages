#define _CRT_SECURE_NO_WARNINGS
#define HAVE_STRUCT_TIMESPEC
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include <pthread.h>
#include<string.h>
#include<stdbool.h>

int readConstants() {
	FILE* ptr;
	ptr = fopen("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt", "r");
	if (NULL == ptr) {
		printf("file can't be opened \n");
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
		if (strcmp(line, "Thread Creation") == 0) {
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

int NUMBER_OF_THREADS;

int main() {
	NUMBER_OF_THREADS = readConstants();
	FILE* fPtr;
	char filePath[100] = "C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduri_c.txt";
	fPtr = fopen(filePath, "w");
	if (fPtr == NULL)
	{
		printf("\nUnable to open '%s' file.\n", filePath);
		printf("Please check whether file exists and you have write privilege.\n");
		exit(EXIT_FAILURE);
	}
	fprintf(fPtr, "C\n");
	fprintf(fPtr, "- Masurarea alocarii unui sir cu %d thread-uri -\n\n", NUMBER_OF_THREADS);

	clock_t startTime, endTime;
	pthread_t threads[NUMBER_OF_THREADS];
    double total_time=0.0;
	for (int j = 0; j < 10; j++) {
		startTime = clock();
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			pthread_create(&threads[i], NULL, NULL, NULL);
		}
		endTime = clock();
		double mes_duration = (double)(endTime - startTime) / (double)(CLOCKS_PER_SEC * 100);
		total_time += mes_duration;
	}
	double mean = total_time / 10;
	fprintf(fPtr, "Media %.6f secunde\n\n", mean);
	fclose(fPtr);

	return 0;
}
