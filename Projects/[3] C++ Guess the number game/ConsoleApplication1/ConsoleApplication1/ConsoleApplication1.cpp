// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>


using namespace std;

int main()
{
	int number = (rand() % 100) + 1; // I used the modulo 100 ( % 100 ) operator to always get the last 2 digits of every number.The numbers that remains after the modulo operation is done,  
								   //are in range 0 - 99, for them to be in range 1 - 100 we need to add one unit.
	int guess = 0;

	do {
		cout << "Enter guess (1 - 100): ";
		cin >> guess;
		
		if (guess > number) {
			cout << "Guess lower!" << endl;
		}
		else if (guess < number) {
			cout << "Guess higher!" << endl;
		}
		else {
			cout << "Congratulations! You won!";
		}

	} while (guess != number);



	return 0;
}

