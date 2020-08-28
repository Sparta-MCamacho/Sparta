[![Downloads](https://media-exp1.licdn.com/dms/image/C4D0BAQGUUbYm7AI-Ug/company-logo_200_200/0?e=1606953600&v=beta&t=ElBiRi0gbFgBUh22ShVN1GCKM4qZtjcqiYKyYjAwaIk)](https://media-exp1.licdn.com/dms/image/C4D0BAQGUUbYm7AI-Ug/company-logo_200_200/0?e=1606953600&v=beta&t=ElBiRi0gbFgBUh22ShVN1GCKM4qZtjcqiYKyYjAwaIk)
---

**Overview**
---
SortManager is a program designed to be able to test your implementations 
of any sort algorithm which can sort a primitive `int[]` array from Java. 
The SortManager used here comes with 7 implementations of different sorting 
algorithms, and an explanation of adding your own is shown below.

**Usage**
---
Upon compiling the Java files into class files, the program can be started
by using the main method found in the App class. This will set-up all 
required values for the program to run and start the console menu system 
which welcomes the user and prompts them for their input.

From a choice of options, with their labelling, the user can decide which
algorithm they would like to use and will them be prompted for the length
(or size) of the array to sort. Once these two inputs are given by the 
user, the application will generate a random array between -999 and 999
inclusive and show the un-sorted array and then the array after sorting
with the time taken to sort that array.

[![Downloads](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Menu%20example.png)](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Menu%20example.png)

The menu will then prompt the user with the same menu options, as from 
start-up.

**Adding Own Sort Algorithm**
---
Any new sorting implementation the user would like to add would need to
implement the Sorter interface, depicted below.

[![Downloads](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Sorter%20Interface.png)](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Sorter%20Interface.png)

Once you have a Java class which implements the only method from Sorter,
there are  steps which will need to be taken to add the implementation
to the menu.

    1. Add the new Java file to the SortAlgorithm directory
    
    2. Within the MENU_OPTIONS `String[]`, add the name of the class
    at the desired point, but before "Compare All" and "Exit Application"
    
    3. Within the SortFactory, add a case for the new class, using the same 
    name from the menu, returning an instantiated object from that class

With these steps completed, your new implementation should appear in the 
menu, and you can go through the menu options as normal.








