/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on February 12, 2020, 9:37 AM
 */

#include <iostream>
#include <string.h>
#include <cstddef>

using namespace std;

void f(int * p);

char * dynamicArrayOfPointer() {
    cout << "Type 3 words";
    char word[80];
    char *pAr = new char [3];

    for (int i = 0; i < 3; ++i) {
        cout << "type a word";
        cin >> word;
        int len = strlen(word);

        pAr[i] = *new char[len + 1];

        strcpy(&pAr[i], word);
        cout << pAr[i];

    }
    return pAr;
}

void printArray(int *p, int size) {
    int * /*const - will not allow you to increment the pointer, or re-point with another*/ p1 = p;
    for (int i = 0; i < size; ++i) {
        cout << p[i] << endl; // << *p1++ << " " << *(p + i) << endl;
    }
}

int * memoryAllocationArray() {
    int * pAr = new int[3] {
        100, 200, 300
    };
    return pAr;
}

int* memoryAllocation() {
    int * p = new int;
    *p = 10;
    return p;
}

void printArray(const int *p, int size) {
    const int * p1 = p;

    for (int i = 0; i < size; ++i) {
        cout << p[i] << " " << *p1++ << " " << *(p + i) << endl;
    }
}

void triplePointer() {
    int ar[3] = {1, 2, 3};
    int *pAr = &ar[0];
    int *pArMoving = pAr;
    int *pWithIndexStable = &ar[0];

    for (int i = 0; i < 3; ++i) {
        cout << (ar + i) << endl;
        cout << *(pAr + i) << endl;
        cout << *pArMoving++ << endl;

        cout << pWithIndexStable[i] << endl;
        cout << ar[i] << endl;
    }
    cout << endl;
}

void showValues(int values[], int size) {
    for (int count = 0; count < size; count++)
        cout << values[count] << endl;
}

int main(int argc, char** argv) {
    //    int x = 25;
    //    x = 100000000000000;
    //    
    //    int *p = &x;
    //    
    //    *p = 20;
    //    
    //    cout << "the address of x is " << p << endl;
    //    cout << "the sizeof *p is " << sizeof(*p) << " bytes\n";
    //    cout << "the value in x is " << x << endl;
    //    

    //    int x =10;
    //    int *p;
    //    int **pp;
    //    
    //    p = &x;
    //    
    //    pp = &p;
    //    
    //    *p = 20;
    //    //**pp = 30;
    //    cout << "x: " << &x << endl;
    //    //even pointers have address, but their values are that of the addresses of what they are pointing to
    //    cout << "pointer: " << p << endl;
    //    cout << "pointer to a pointer: " <<  *pp << endl;

    //    int x = 10, y = 20;
    //
    //    int *p1 = &x;
    //    int *p2 = p1;

    //    cout << "p1: " << *p1 << endl;
    //    cout << "p2: " << *p2 << endl;
    //    
    //    p2 += 6;
    //    
    //    cout << *p2 << endl;
    //    
    //    *p1 += 100;
    //    cout << x << endl;

    //create pointer of a pointer of a pointer
    //    int *p = &y;
    //    int **pp = &p;
    //    int ***ppp = &pp;
    //    
    //    ***ppp += 180;
    //    
    //    cout << y << endl;
    //    

    //       //array pointing
    //    const int SIZE = 5;
    //    int numbers[SIZE] = {1,2,3,4,5};
    //    showValues(numbers, SIZE);

    //    const int ar[3] = {1,2,3};
    //    
    //    printArray(ar, 3);
    //    
    //    cout << "----------------------------------------------------\n";
    //    int * p = memoryAllocation();
    //    //makes sure you don't have a null pointer
    //    if (p = nullptr)
    //        return -1;
    //    
    //    cout << * p << endl;
    //    delete p; //would cause memory leak if you didn't delete p
    //
    //    cout << "--------------------------------------------array\n";
    //    int * pAr = memoryAllocationArray();
    //    //makes sure you dont de-reference something that is not there
    //    if (pAr = nullptr)
    //        return -1;
    //    
    //    printArray(pAr, 3);
    //    delete[] pAr;
    //    
    //    
    //    int x = 10;
    //    int & rInt = x;
    //    
    //    int *p = &x;
    //    int *& rp = p;
    //char ar = new char[3];


    //dynamicArrayOfPointer();

    
}

