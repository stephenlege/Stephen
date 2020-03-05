/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on February 28, 2020, 11:00 AM
 */

#include <iostream>
#include <fstream>
#include <cstring>

#include <string>
#include<cstdlib>

using namespace std;
void Increment(int*);

void calc(int a, int& b);

void doSomething(int&);

void dynamicArrayOfPointer(char* ar[], int size) {
    char word[80];
    for (int i = 0; i < size; ++i) {
        cout << "Please type a word: ";
        cin >> word;

        ar[i] = new char[strlen(word) + 1];
        if (ar[i] = nullptr)
            exit(-1);
        strcpy(ar[i], word);
    }
}

int Add(int* a, int* b) {
    int c = (*a)+ (*b);
    return c;
}

int main() {
    //    char * ar[3];
    //    dynamicArrayOfPointer(ar, 3);
    //    
    //    for(int i = 0; i < 3; ++i){
    //        cout << ar[i] << " ";
    //    }
    //    cout << endl;
    //    
    //    delete [] ar;


    //    int somenumbers[5];
    //    int* ptr = somenumbers; //&somenumbers[0] but array name is a pointer to itself
    //    
    //    int v = 2;
    //    
    //    for(;ptr < &somenumbers[5];ptr++){
    //        *ptr = v;
    //        v = v * 2;
    //    }
    //    for (int i = 0; i < 5; i++){
    //        cout << somenumbers[i] << " "; 
    //    }

    //    int box = 5;
    //    int* ptr = &box;
    //    int** dPtr = &ptr;
    //    
    //    cout << "box holds: " << box << endl;
    //    cout << "box lives at: " << &box << endl;
    //    
    //    cout << "ptr points to address: " << ptr << endl;
    //    cout << "The thing that ptr points to has the value: " << *ptr << endl;
    //    cout << "ptr lives at: " << &ptr << endl;
    //    
    //    cout << "dPtr points to " << dPtr << endl;
    //    cout << "The thing that dPtr points to has the value: " << *dPtr << endl;
    //    cout << "The ptr that dPtr points to, points to an int with the value: " << **dPtr << endl;
    //    cout << "dPtr lives at: " << &dPtr << endl;
    //    
    //    cout << "\n\n Thing:            dPtr            ptr         box" << endl;
    //    cout << "Values:        " << dPtr << "     " << ptr << "          " << box<< endl;

    //---------------------------------------------------------- pointing to pointing

    //    int a = 10;
    //    Increment(&a);
    //    cout << "address of vriable a in main = " << &a << endl;
    //    
    //    int* bp = nullptr;
    //    bp = 0;
    //    
    //    cout << bp << endl;

    //    int x = 1;
    //    int y = 2;
    //    int z = 3;
    //
    //    calc(x, y);
    //    cout << x << " " << y << " " << z << endl;




    return 0;
}

void Increment(int* a) {
    *a = *a + 1;
    cout << "Address of var a in inc = " << a << endl;
}

void calc(int a, int& b) {
    int c;

    c = a + 2;
    a = a * 3;
    b = c + a;
}

