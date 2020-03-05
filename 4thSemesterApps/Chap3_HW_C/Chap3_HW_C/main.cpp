/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on January 23, 2020, 8:12 AM
 */

#include <iostream>
#include <cmath>
#include <string>
#include <iomanip>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    //---------------------------------------------------------------
    /*Question 12: Celsius to fahrenheit 
     * formula: f = 9/5C + 32
     */

//        double celsius, fahrenheit;
//        cout << "Input a celsius: "<< endl;
//        cin >> celsius;
//        fahrenheit = ((9/5) * celsius) + 32;
//        cout << "The fahrenheit of " << celsius << "*C is " << fahrenheit << "*F." << endl << endl;
        


    //-----------------------------------------------end
    /*Qestion 13: Dollars to Yen
     * formula: 1 usd = 109.4856 yn
     */
    
//    double dollars;
//    
//
//    cout << "Enter a dollar amount: " << endl;
//    cin >> dollars;
//
//    const double YEN = dollars * 109.4856;
//
//    cout << "The converted amount is: " << fixed << setprecision(2) << showpoint << YEN << endl << endl;


    /*Question 20: Divide pizza pies
     * 1) ask user for diameter of pizza in inches
     * 2) calculate the number of slices that can be taken from a pizza of that size
     * 3) display number of slices
     * 
     * formula: area of pizza is 14.125 in.
     * formula: divide area of pizza by 14.125 in.
     * Area = pie * r * r
     * 
     * display with fixed point notation rounded to one decimal place
     */
    
//    const double SLICE = 14.125;
//    const double PI = 3.14159;
//    double diameter;
//    
//    cout << "Enter the diameter of your pizza dude! " << endl;
//    cin >> diameter;
//    
//    double radius = diameter / 2;
//    double area = PI * radius * radius;
//    double areaOfEachSlice = area / SLICE;
//    
//    cout << "The area of each slice is: " << fixed << setprecision(1) << areaOfEachSlice << " in." << endl << endl;
    
//-----------------------------------------------------------------------
    /*Question 24 Word Game
     * inputs from user:
     * 1) name
     * 2) age
     * 3) city
     * 4) college
     * 5) profession
     * 6) type of animal
     * 7)a pet's name
     * 
     * display a madlibs:
     * There once was a person named NAME who lived in CITY . At the age of
        AGE , NAME went to college at COLLEGE . NAME graduated and went to work
        as a PROFESSION . Then, NAME adopted a(n) ANIMAL named PETNAME . They
        both lived happily ever after!
     */
    string name, age, city, college, profession, animal, petname;
    
    cout << "Enter these 7 topics: " << endl << "Your name: ";
    getline(cin, name);
    
    cout << endl << "Your age: ";
    getline(cin, age);
    
    cout << endl << "The city from wench you came: ";
    getline(cin, city);
    
    cout << endl << "Your college or High School: " ;
    getline(cin, college);
    
    cout << endl << "Your job or profession: ";
    getline(cin, profession);
    
    cout << endl << "Your animal or sign: ";
    getline(cin, animal);
    
    cout << endl << "Your pet's name: ";
    getline(cin, petname);
    
    cout << endl << "There once was a person named " << name ;
     cout <<  " who lived in " << city << ".  ";
     cout << "At the age of " << age << "," << endl;
     cout << name << " went to college at " << college << "." << endl ;
     cout << name << " graduated and went to work as a " << profession << "." << endl;
     cout << "Then, " << name << " adopted a(n) " << animal << " named ";
     cout << petname << "." << endl << "They both lived happily ever after!" << endl;


    return 0;
}

