/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on February 16, 2020, 10:48 AM
 */

#include <iostream>
#include <iomanip>
#include <cmath> 
#include<limits>
#include <string>

using namespace std;

//variables:
int numTests;
double *testScores = new double[numTests];
string *studentNames = new string[numTests];

void clear_input() {

    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}
//------------------------------------------1

int *arraySize(int numElements) {

    if (numElements <= 0) {
        return nullptr;
    }
    int *ptr = new int[numElements];
    *ptr = 10;
    return ptr;
}
//----------------------------------------2

void sortArray(double *ptr, int arraySize) {
    double temp;
    bool swapped = true;

    while (swapped) {
        swapped = false;
        for (int i = 0; i < arraySize - 1; i++) {
            if (*(ptr + i) > *(ptr + i + 1)) {
                temp = *(ptr + i + 1);
                *(ptr + i + 1) = *(ptr + i);
                *(ptr + i) = temp;

                swapped = true;

            }
        }
    }
}

void validateArray(double *testScores, int size) {
    for (int counter = 0; counter < size; counter++) {
        cout << "Test " << counter + 1 << ": ";

        cin >> *(testScores + counter);

        while (*(testScores + counter) < 0) {
            cout << "Negative values not allowed!";
            cout << " Enter again!\n";
            cin >> *(testScores + counter);
        }
    }
}

double getAverage(double *ptr, int arraySize) {
    double total = 0.0;
    for (int i = 0; i < arraySize; i++) {
        total += *(ptr + i);
    }
    return (double) total / arraySize;
}

void printArray(double * testScores, int size) {
    for (int i = 0; i < size; i++) {
        cout << *(testScores + i) << " ";
    }
}

//-----------------------------------------------------------------------3

double getAverage2(double *ptr, int arraySize) {

    double totals = 0.0;
    for (int counter = 1; counter < arraySize; counter++) {
        totals += *(ptr + counter);
    }
    return (double) totals / (arraySize - 1);
}

//----------------------------------------------------------------------4

void sortArray(double *doublePtr, string *strPtr, int arraySize) {

    double temp;
    string tempName;

    bool swapped = true;

    while (swapped) {
        swapped = false;

        for (int i = 0; i < arraySize - 1; i++) {
            if (*(doublePtr + i) > *(doublePtr + i + 1)) {
                temp = *(doublePtr + i + 1);
                tempName = *(strPtr + i + 1);

                *(doublePtr + i + 1) = *(doublePtr + i);
                *(strPtr + i + 1) = *(strPtr + i);

                *(doublePtr + i) = temp;
                *(strPtr + i) = tempName;
                swapped = true;

            }
        }
    }
}
//-----------------------------------------------------------------5

int deRef(int *x, int *y) {
    //temp has to take value of x,
    //so first dereference it
    int temp = *x;

    //dereference them both
    *x = *y * 10;

    //temp is not a pointer
    *y = temp * 10;

    return *x + *y;
}

//----------------------------------------------------------------------6modified

void arrSelectSort(int *arr[], int size) {
    int startScan, minIndex;
    int *minElem;

    for (startScan = 0; startScan < (size - 1); startScan++) {
        minIndex = startScan;
        minElem = arr[startScan];
        for (int index = startScan + 1; index < size; index++) {
            if (*(arr[index]) < *minElem) {
                minElem = arr[index];
                minIndex = index;
            }
        }
        arr[minIndex] = arr[startScan];
        arr[startScan] = minElem;
    }
}

void showArray(const int arr[], int size) {
    for (int count = 0; count < size; count++)
        cout << arr[count] << " ";
    cout << endl;
}

void showArrPtr(int *arr[], int size) {
    for (int count = 0; count < size; count++)
        cout << *(arr[count]) << " ";
    cout << endl;
}



//----------------------------------------------------------------7

void showArrPtr2(int *arr[], int size) {
    for (int count = size - 1; count >= 0; count--)
        cout << *(arr[count]) << " ";
    cout << endl;
}
//========================================================================8

int getMode(int *arr, int numElements) {
    int amount = 0;
    int number;
    int *mode;

    for (int i = 0; i < numElements; i++) {
        number = 0;
        for (int j = i; j < numElements; j++) {
            if (*(arr + i) == *(arr + j))
                number++;
        }
        if (number > amount) {
            amount = number;
            mode = arr + i;
        }
    }
    if (amount == 1)
        return -1;

    return *mode;
}

//-----------------------------------------------------------------------9

double getMedian(int *arr, int numElements){
    if(numElements % 2 == 1){
        return *(arr + (numElements / 2));
    }
    else{
        int mid = numElements / 2;
        double median = (*(arr + mid) + *(arr + mid - 1)) / 2.0;
        return median;
    }
}
 //------------------------------------------------------------------------10

int* reverseArray(int *arr, int SIZE){
    int *ptr = new int[SIZE];
    for(int i = 0; i < SIZE; i++){
        *(ptr + SIZE - 1 - i) = *(arr + i);
    }

    return ptr;
}

//-------------------------------------------------------------------------11

int* expandArray(int *arr, int SIZE){
    //dynamically allocate an array twice the size
    int *expPtr = new int[2*SIZE];

    //initialize elements of new array
    for(int i = 0; i < 2*SIZE; i++){
        //first add elements of old array
        if(i < SIZE){
            *(expPtr + i) = *(arr + i);
        }
        //all next elements should be 0
        else{
            *(expPtr + i) = 0;
        }
    }

    return expPtr;
}

//----------------------------------------------------------------------------12

int* shiftArray(int *arr, int SIZE){
    int *shiftPtr = new int[SIZE+1];

    *shiftPtr = 0;

    for(int i = 1; i <= SIZE; i++){
        *(shiftPtr + i) = *(arr + i - 1);
    }
    return shiftPtr;
}

  




//main

int main(int argc, char** argv) {
        //----------------------------------------------------------------------1
        int * num = arraySize(3);
    
        cout << *num << endl;
        //----------------------------------------------------------------------2
    
    
        cout << "Please enter number of test scores:  " << endl;
    
        cin >> numTests;
    
    
    
        validateArray(testScores, numTests);
    
        cout << endl;
        sortArray(testScores, numTests);
        cout << "Sorted test scores: " << endl;
        printArray(testScores, numTests);
        cout << endl;
    
        cout << "Average of " << numTests << " tests are: ";
        cout << getAverage(testScores, numTests) << endl << endl;
    
        //---------------------------------------------------------------3
    
        cout << "(Drop Lowest Score) Average of " << numTests - 1 << " tests are: ";
        cout << getAverage2(testScores, numTests) << endl;
    
        //--------------------------------------------------------------4
    
        clear_input();
        int numTests2;
    
        cout << "Please enter number: " << endl;
    
        cin >> numTests2;
    
    
        double *testScores2 = new double[numTests];
        string *studentNames2 = new string[numTests];
    
        //validateArray(testScores2, numTests2);
    
        cout << endl;
    
        for (int j = 0; j < numTests2; j++) {
            cout << "Student " << j + 1 << " name: ";
            cin >> *(studentNames2 + j);
    
            cout << "Test score: ";
            cin >> *(testScores2 + j);
    
            while (*(testScores2 + j) < 0) {
                cout << "Negative values not allowed!";
                cout << " Enter again!\n";
                cin >> *(testScores2 + j);
            }
        }
    
        sortArray(testScores2, studentNames2, numTests2);
    
        cout << fixed << setprecision(1);
    
        cout << endl;
        cout << "Sorted test scores: " << endl;
        cout << "Name \t\t Score\n";
        for (int counter = 0; counter < numTests2; counter++) {
            cout << *(studentNames2 + counter) << " \t\t ";
            cout << *(testScores2 + counter) << endl;
        }
    
        //-------------------------------------------------------------------5
        int *num01 = new int;
        int *num02 = new int;
        
        cout << "Enter two numbers: "<< endl;
        cin >> *num01 >> *num02;
        
        int deReferencedValue = deRef(num01, num02);
        cout << deReferencedValue << endl;
        delete num01;
        delete num02;

    //------------------------------------------------------------------------6modified
    int numElements;
    cout << "Enter number of donations: ";
    cin >> numElements;

    //validate input
    while (numElements < 1) {
        cout << "Please enter a number not less than 1: ";
        cin >> numElements;
    }

    int *donations = new int[numElements];

    for (int count = 0; count < numElements; count++) {
        cout << "Donation " << count + 1 << ": ";
        cin >> *(donations + count);
    }

    int *arrPtr[numElements];

    for (int count = 0; count < numElements; count++)
        arrPtr[count] = &donations[count];

    arrSelectSort(arrPtr, numElements);
    cout << "The donations, sorted in ascending orders are: " << endl;
    showArrPtr(arrPtr, numElements);

    cout << "The donations, in their original orders are: " << endl;
    showArray(donations, numElements);

    //------------------------------------------------------------------------7

    cout << "The donations, sorted in descending order are: \n";
    showArrPtr2(arrPtr, numElements);
    cout  << endl;
    //========================================================================8

    int numElem = 11;
    //int *ar1[numElem] = {1,1,1,1,1,2,3,4,5,6};
    
    int * pAr = new int[numElem]{10,2,2,2,20,25,30,40,50,60, 66};
    //int *ptrAr1 = &ar1;
    
    cout <<"Number that appears most is: " <<  getMode(pAr, numElem) << endl;
    
    //========================================================================9
    cout << "Median is: " << getMedian(pAr, numElem) << endl;
    
    
    //-----------------------------------------------------------------------10
    
    
    int inArray[numElem] ={10,2,2,2,20,25,30,40,50,60, 66};
    
    int *rev = reverseArray(inArray, numElem);
    
    cout << "Array in Reverse: " << endl;
    
    showArray(rev, numElem);

    delete rev;
    
    //----------------------------------------------------------------------11
    int *pAr11 = new int[numElem]{10,2,2,2,20,25,30,40,50,60, 66} ;
    int numEx = numElem * 2;
    
    int * ex = expandArray(pAr11, numElem);
    
    showArray(ex, numEx);
    
    delete pAr11;
    delete ex;
    //----------------------------------------------------------------------12
    int *pAr12 = new int[numElem]{10,2,2,2,20,25,30,40,50,60, 66} ;
    int numShift = numElem + 1;
    
    int * shifted = shiftArray(pAr12, numElem);
    
    showArray(shifted, numShift);
    delete pAr12;
    delete shifted;
    
    return 0;
}

