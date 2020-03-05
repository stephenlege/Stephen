/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: LEGE
 *
 * Created on March 3, 2020, 7:40 AM
 */

#include <cstdlib>
#include <iostream>
#include <cstring>
#include <string> 
#include <iomanip> 



using namespace std;

void writeMorse(char *, const string []);
int convertASCIItoMorse(char);

//---------------------------------------------------------------Q 1

int charCount(char *ptr) {
    int counter = 0;

    while (*ptr != '\0') {
        counter++;
        ptr++;
    }
    return counter;
}

//----------------------------------------------------------------Q 2

void displayString(char *ptr) {
    for (int i = strlen(ptr) - 1; i >= 0; i--)
        cout << ptr[i];

    cout << endl;
}

//----------------------------------------------------------------Q3

int wordCount(const char *ptr) {
    int wordCounter = 0;
    while (*(ptr) != '\0') {
        if (isalnum(*ptr) && (*(ptr + 1) == ' ' || *(ptr + 1) == '\0'))
            wordCounter++;
        ptr++;
    }
    return wordCounter;
}

int wordCount(string input) {
    const char *ptr = input.c_str();
    return wordCount(ptr);
}


//------------------------------------------------------------------Q4

void wordCount4(const char *ptr, const char *ptr1) {
    int wordCounter = 0;
    int letterCounter = 0;
    while (*(ptr) != '\0') {
        if (isalnum(*ptr) && (*(ptr + 1) == ' ' || *(ptr + 1) == '\0'))
            wordCounter++;
        ptr++;
    }
    while (*(ptr1) != '\0') {
        if (isalnum(*ptr1))
            letterCounter++;
        ptr1++;
    }
    cout << "There are " << wordCounter << " words in this string!\n";
    cout << "There is an average of " << letterCounter / (wordCounter * 1.00) << endl;
    cout << " letters per word!\n\n";
}

void wordCount4(string input) {
    const char *ptr = input.c_str();
    return wordCount4(ptr, ptr);
}


//-----------------------------------------------------------------------Q 5

void capitalize5(const char *ptr) {
    cout << (char) toupper(ptr[0]);
    ptr++;

    while (*(ptr) != '\0') {
        if (ispunct(*(ptr - 2)) && *(ptr - 1) == ' ' && isalnum(*ptr))
            cout << (char) toupper(*ptr);
        else
            cout << *ptr;

        ptr++;
    }
    cout << endl;
}

void capitalize5(string input) {
    const char *ptr = input.c_str();
    capitalize5(ptr);
}

//=======================================================================Q 6

int countVowels(const char *ptr) {
    int vowelCounter = 0;

    while (*(ptr) != '\0') {
        if (toupper(*ptr) == 'A' || toupper(*ptr) == 'E' ||
                toupper(*ptr) == 'I' || toupper(*ptr) == 'O' ||
                toupper(*ptr) == 'U' || toupper(*ptr) == 'Y')
            vowelCounter++;
        ptr++;
    }
    return vowelCounter;
}

int countConsonants(const char *ptr) {
    int consonantCounter = 0;

    while (*(ptr) != '\0') {
        if (toupper(*ptr) != 'A' && toupper(*ptr) != 'E' &&
                toupper(*ptr) != 'I' && toupper(*ptr) != 'O' &&
                toupper(*ptr) != 'U' && toupper(*ptr) != 'Y' &&
                isalpha(*ptr))
            consonantCounter++;
        ptr++;
    }
    return consonantCounter;
}

//======================================================================Q 7

void displayFull(const char *first, const char *middle,
        const char *last, char *full) {
    strncpy(full, last, strlen(last));

    strcat(full, ", ");

    strncat(full, first, strlen(first));

    strcat(full, " ");

    strncat(full, middle, strlen(middle));

    cout << "\nYour full formatted name is:\n";
    cout << full;
}

//=======================================================================Q 8

void calcSum(char *ptr) {
    int highest = 0;
    int lowest = 9;

    int sum = 0;

    long int number = atol(ptr);

    while (number > 0) {
        sum += number % 10;

        if (number % 10 > highest)
            highest = number % 10;

        if (number % 10 < lowest)
            lowest = number % 10;

        number /= 10;
    }
    cout << "The highest digit is: " << highest << endl;
    cout << "The lowest digit is: " << lowest << endl;
    cout << "The sum of all digits is: " << sum << endl;
}

//==========================================================================Q 9

void highOccurring(char *ptr) {
    int currentCharCount;
    int maxCount = 0;

    char highestOccChar;

    for (int counter = 0; counter < strlen(ptr); counter++) {
        currentCharCount = 0;
        for (int index = counter; index < strlen(ptr); index++) {
            if (ptr[counter] == ptr[index])
                currentCharCount++;
            if (currentCharCount > maxCount) {
                maxCount = currentCharCount;
                highestOccChar = ptr[counter];
            }
        }
    }

    cout << "The highest occurring character is '" << highestOccChar;
    cout << "' with " << maxCount << " occurrences.";
}

//===========================================================================Q 10

string replaceSubstring(const char *st1, const char *st2, const char *st3) {
    char *occurrence = strstr(st1, st2);
    string output = "";

    while (occurrence) {
        output.append(st1, (occurrence - st1));

        output.append(st3, strlen(st3));

        st1 = st1 + (occurrence - st1) + strlen(st2);

        occurrence = strstr(st1, st2);
    }

    output.append(st1, strlen(st1));

    return output;
}

string replaceSubstring(string st1, string st2, string st3) {
    const char *ptr1 = st1.c_str();
    const char *ptr2 = st2.c_str();
    const char *ptr3 = st3.c_str();

    replaceSubstring(ptr1, ptr2, ptr3);
}




//===========================================================================Q 17
const string morseCodes[40] = {" ",
    "--..--",
    ".-.-.-",
    "..--..",
    "-----",
    ".----",
    "..---",
    "...--",
    "....-",
    ".....",
    "-....",
    "--...",
    "---..",
    "----.",
    ".-",
    "-...",
    "-.-.",
    "-..",
    ".",
    "..-.",
    "--.",
    "....",
    "..",
    ".---",
    "-.-",
    ".-..",
    "--",
    "-.",
    "---",
    ".--.",
    "--.-",
    ".-.",
    "...",
    "-",
    "..-",
    "...-",
    ".--",
    "-..-",
    "-.--",
    "--.."};

void writeMorse(char *ptr, const string morse[]) {
    cout << endl;
    //loop on each character of the string
    //the user entered until null terminator
    //is encountered
    while (*ptr != '\0') {
        //for each character, print its
        //morse equivalent
        cout << morse[convertASCIItoMorse(toupper(*ptr))];

        //increment pointer to point to next byte
        ptr++;
    }
}

int convertASCIItoMorse(char input) {
    //the morse codes are written in the array
    //in the order that they appear in the book
    //so for each special input, we convert it to the
    //relevant index. Space for example is index 0
    if (input == ' ')
        return 0;
    else if (input == ',')
        return 1;
    else if (input == '.')
        return 2;
    else if (input == '?')
        return 3;
        //in string array, numbers 0-9 correspond to
        //index 4-13, and to index 48-57 in ASCII
        //convert their ASCII to array index
    else if (input >= 48 && input <= 57)
        return input - 44;
        //in string array letter A-Z correspond to
        //index 14-39, and to index 65-90 in ASCII
        //convert their ASCII to array index
    else if (input >= 65 && input <= 90)
        return input - 51;
}

int main(int argc, char** argv) {
        //--------------------------------------------------------------------Q 1
        char inputString[21];
    
        cout << "Enter a string, 20 chars max: \n";
    
        cin.getline(inputString, 21);
    
        cout << "The string has " << charCount(inputString) << " caracters." << endl;
    
        //should work to clear cin??
        cin.sync();
    
//        //-------------------------------------------------------------------Q 2
//    
//        char inputString2[21];
//    
//        cout << "Enter a string, 20 chars max: \n";
//    
//        cin.getline(inputString2, 21);
//    
//        displayString(inputString2);
//        //should work to clear cin??
//        cin.sync();
//        //--------------------------------------------------------------------Q 3
//    
//        char inputString3[101];
//    
//        string input3;
//    
//        cout << "Enter a C-string with a maximum of 100 characters\n";
//        cin.getline(inputString3, 101);
//    
//        cout << "\nEnter a string with a maximum of 100 characters\n";
//        getline(cin, input3);
//    
//        cout << "\nThere are " << wordCount(inputString3)
//                << " words in the String." << endl;
//        cout << "There are " << wordCount(input3)
//                << " words in the string object." << endl;
//        //should work to clear cin??
//        cin.sync();
//        //----------------------------------------------------------------Q4
//    
//        char inputString4[101];
//    
//        string input4;
//    
//        cout << "Enter a string with a maximum of 100 characters\n";
//        cout << "(including spaces) and I will tell you how many words\n";
//        cout << "there are!\n";
//        cin.getline(inputString4, 101);
//    
//        cout << "\nEnter a string with a maximum of 100 characters\n";
//        cout << "(including spaces) and I will tell you how many words\n";
//        cout << "there are!\n";
//        getline(cin, input4);
//    
//        cout << fixed << setprecision(2);
//    
//        wordCount4(inputString4);
//        wordCount4(input4);
//    
//        //should work to clear cin??
//        cin.sync();
//        //---------------------------------------------------------------------Q5
//        char inputString5[101];
//    
//        string input5;
//    
//        cout << "\nEnter a string with a maximum of 100 characters\n";
//        cout << "(including spaces) and I will capitalize first word\n";
//        cout << "of every sentence!\n";
//        cin.getline(inputString5, 101);
//    
//        cout << "\nEnter a string with a maximum of 100 characters\n";
//        cout << "(including spaces) and I will capitalize first word\n";
//        cout << "of every sentence!\n";
//        getline(cin, input5);
//    
//        capitalize5(inputString5);
//        capitalize5(input5);
//    
//        //should work to clear cin??
//        cin.sync();
//        //-------------------------------------------------------------------Q6
//        char inputString6[101];
//    
//        cout << "Enter a string with a maximum of 100 characters:\n";
//        cin.getline(inputString6, 101);
//    
//        char choice;
//    
//        do {
//            cout << "\nPlease enter a choice according to menu:\n";
//            cout << "A) Count the number of vowels in the string\n";
//            cout << "B) Count the number of consonants in the string\n";
//            cout << "C) Count both the vowels and consonants in the string\n";
//            cout << "D) Enter another string\n";
//            cout << "E) Exit the program\n";
//    
//            cout << "\nPlease enter choice:\n";
//            cin >> choice;
//            while (choice != 'A' && choice != 'B' && choice != 'C' &&
//                    choice != 'D' && choice != 'E') {
//                cout << "Please enter a valid choice (A, B, C, D or E)!\n";
//                cin >> choice;
//            }
//    
//            switch (choice) {
//                case 'A':
//                    cout << "There are " << countVowels(inputString6);
//                    cout << " vowels in the string!\n";
//                    break;
//                case 'B':
//                    cout << "There are " << countConsonants(inputString6);
//                    cout << " consonants in the string!\n";
//                    break;
//                case 'C':
//                    cout << "There are " << countVowels(inputString6) + countConsonants(inputString6);
//                    cout << " vowels and consonants in the string!\n";
//                    break;
//                case 'D':
//                    cout << "Enter your new string:\n";
//                    cin.ignore();
//                    cin.getline(inputString6, 101);
//                    break;
//                case 'E':
//                    break;
//            }
//        } while (choice != 'E');
//    
//        //should work to clear cin??
//        cin.sync();
//    
//        //=======================================================================Q7
//    
//        char firstName[21], middleName[21], lastName[21];
//        char fullName[64];
//    
//        cout << "Enter your full name separated by spaces:\n";
//        cin >> firstName >> middleName >> lastName;
//    
//        displayFull(firstName, middleName, lastName, fullName);
//    
//    
//        //should work to clear cin??
//        cin.sync();
//    
//        //----------------------------------------------------------------------Q 8
//        char digitString[10];
//    
//    
//        cout << "Enter a string of digits with nothing separating them (max 9 digits):\n";
//        cin >> digitString;
//    
//        calcSum(digitString);
//    
//    
//    
//        //should work to clear cin??
//        cin.sync();
//    
//        //------------------------------------------------------------------------Q9
//        char inputString9[101];
//    
//    
//        cout << "Enter a string (with max 100 characters including spaces):\n";
//        cin.getline(inputString9, 101);
//    
//        highOccurring(inputString9);
//    
//        //should work to clear cin??
//        cin.sync();
//    
//        //--------------------------------------------------------------------------Q 10
//        char string1[101];
//        char string2[101];
//        char string3[101];
//    
//        cout << "Enter string to search:\n";
//        cin.getline(string1, 101);
//    
//        cout << "Enter the string you want to replace:\n";
//        cin.getline(string2, 101);
//    
//        cout << "What do you want to replace it with?\n";
//        cin.getline(string3, 101);
//    
//        cout << "Your updated string is:\n";
//        cout << replaceSubstring(string1, string2, string3);
//    
//        cin.sync();
//
//    //-------------------------------------------------------------------Q 17
//
//    char inputString17[101];
//
//    cout << "Enter your string and I will convert it to Morse Code!\n";
//    cout << "(Max 100 characters including spaces):\n";
//    cin.getline(inputString17, 101);
//
//    writeMorse(inputString17, morseCodes);
//
//
//    cin.sync();


    return 0;
}

