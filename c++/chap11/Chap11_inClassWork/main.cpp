/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on March 2, 2020, 10:39 AM
 */

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cstring>
#include <string>
#include <limits>

using namespace std;
#include "structures.h"

void clear_input() {

    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

void deleteArray(Employee* ar[], int size){
    for(int i = 0; i < size; i++){
        //ar[i]->pAddress = 0;
        ar[i]->~Employee();
    }
}

//Employee(int id, string name,int zip, char street[], char* pCity, string state )

void loadArrayOfStructurePointers(Employee* ar[], int size) {
    int id;
    char name[80];
    int zip;
    char street[80];
    char* pCity[80];
    char state[80];
    for (int i = 0; i < size; i++) {
        cout << "Enter id: ";
        cin >> id;
        cin.ignore();
        cout << "\nEnter name: ";
        cin.getline(name, 80);

        cout << "\nEnter zip: ";
        cin >> zip;
        cin.ignore();
        cout << "\nEnter street: ";
        cin.getline(street, 80);

        cout << "\nEnter city: ";
        cin.getline(*pCity, 80);

        cout << "\nEnter state: ";
        cin.getline(state, 80);

        ar[i] = new Employee(id, name, zip, street, *pCity, state);
        cout << endl;
        //clear_input();
    }
}

void printEmployeePointer(Employee * e) {
    cout << (*e).toString() << endl;
}

void printEmployee(Employee e) {
    cout << e.toString() << endl;
}

void loadArrayOfStructures(Employee arr[], int size) {
    int id;
    char name[80];
    int zip;
    char street[80];
    char* pCity[80];
    char state[80];
    for (int i = 0; i < size; i++) {
        cout << "Enter id: ";
        cin >> id;
        cin.ignore();
        cout << "\nEnter name: ";
        cin.getline(name, 80);

        cout << "\nEnter zip: ";
        cin >> zip;
        cin.ignore();
        cout << "\nEnter street: ";
        cin.getline(street, 80);
        
        cout << "\nEnter city: ";
        cin.getline(*pCity, 80);

        cout << "\nEnter state: ";
        cin.getline(state, 80);

        arr[i] = *(new Employee(id, name, zip, street, *pCity, state));
//        Employee e;
//        e.id = id;
//        e.name = name;
//        e.pAddress = new Address(street,zip, *pCity,state);
//        arr[i]=e;
//        cout << endl;
        //clear_input();
    }
    

}

void printArrayPointers(Employee* ar[], int size) {
    for (int i = 0; i < size; i++) {
        printEmployeePointer(ar[i]);
    }
}

void printArray(Employee ar[], int size) {
    for (int i = 0; i < size; i++) {
       cout << ar[i].toString() << endl; 
    }
    //delete [] ar;
}


int main(int argc, char** argv) {
    //    Employee e1;
    //    Employee* pE1 = new Employee();
    //    
    //    
    //    e1.id = 1;
    //    e1.name = "Jam Jam";
    //    e1.pAddress = new Address();
    //    
    //    pE1->id = 2;
    //    pE1->name = "Merry Plopper";
    //    pE1->pAddress = new Address();
    //    
    //    pE1->pAddress->pCity= "Abbeville";
    //    pE1->pAddress->state = "LA";
    //    strcpy(pE1->pAddress->street,"Grime Blvd.");
    //    //pE1->pAddress->street = new char*[80]{"Grime Blvd."};
    //    pE1->pAddress->zip = 77777;
    //    
    //    
    //    
    //    (* e1.pAddress).pCity = new char[80]; 
    //    strcpy(e1.pAddress -> pCity, "Lafayette"); //-> dereferences the pointer pCity
    //    (*e1.pAddress).state = "LA";
    //    e1.pAddress->zip = 70520;
    //    
    //   //(* e1.pAddress).street = new char[80];
    //   strcpy(e1.pAddress->street, "Hell");
    //            
    //    //printEmployee(e1);
    //    
    //    printEmployee(*pE1);


    //Employee(int id, string name,int zip, char street[], char* pCity, string state )
    //    Employee* e1 = new Employee(1, "Marley Bob", 70510, "Main Street", "Jamin", "LA");
    //    Employee* e2 = new Employee(2, "Merry Plopper", 77777, "Main Street", "London", "LA");
    //    Employee* e3 = new Employee(3, "Marley Blopter", 70511, "Main Street", "Yorkervershire", "LA");
    //    
    //      Employee* empAr[3];
    //    empAr[0]=e1;
    //    empAr[1]=e2;
    //    empAr[2]=e3;
    //    
    //    printArray(empAr,3);



    //-------------------------------------------------------implement 4 methods and test them
    //wants to create an Array of pointers and pass it to the method to load it




    Employee * ar[3];

    loadArrayOfStructurePointers(ar, 3);

    printArrayPointers(ar, 3);

//    Employee arr[3];
//    
//    loadArrayOfStructures(arr,3);
//    
//    printArray(arr, 3);
  
    //clear_input();
    //delete [] arr;
    return 0;
}

