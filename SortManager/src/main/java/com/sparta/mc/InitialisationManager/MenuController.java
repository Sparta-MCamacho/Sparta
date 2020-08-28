package com.sparta.mc.InitialisationManager;

import com.sparta.mc.Printer.FormatPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

//Class concerned with running the Menu
public class MenuController {

    final static Logger logger = LogManager.getLogger(MenuController.class);

    //Static variable holding menu options
    public final static String[] MENU_OPTIONS = {
            "BinarySorter", "BubbleSorter",
            "InsertionSorter", "MergerIterativeSorter",
            "MergeSorter", "SelectionSorter",
            "QuickSorter",
            "Compare All Sorters", "Exit Application"
    };

    public MenuController() {
        logger.info("User has started application");
    }

    //Public method for starting the menu
    public static void startMenu() {
        FormatPrinter.printOpeningMessage();

        Scanner userInput = new Scanner(System.in);

        while (true) {

            //Show menu options and get option from user
            logger.info("Menu has restarted");
            FormatPrinter.printMenuOptions(MENU_OPTIONS);
            int response;

            //Dealing with response exceptions
            try {
                response = userInput.nextInt();
            } catch (InputMismatchException e) {
                logger.warn("User entered a response which could not be read as an int (Exception has been handled)");
                System.err.println("InputMismatchException thrown, please enter a valid menu option.");
                FormatPrinter.printErrorRestartMessage();
                userInput = new Scanner(System.in);
                continue;
            }

            //Validating response from user
            if (applicationShouldExit(response)) {
                logger.info("User has exited the application via the menu");
                //Exit the application
                break;
            } else if (isInvalidMenuOption(response)) {
                logger.warn("User menu option not available");
                //Send error message and re-run menu options
                FormatPrinter.printMenuNumberError();
                continue;
            }

            //Read array length from user
            FormatPrinter.printArrayLengthPromptMessage();
            int arrayLength;

            //Dealing with arrayLength exceptions
            try {
                arrayLength = userInput.nextInt();
            } catch (InputMismatchException e) {
                logger.warn("User entered a array length which could not be read as an int (Exception has been handled)");
                System.err.println("InputMismatchException thrown, please enter a valid array length.");
                FormatPrinter.printErrorRestartMessage();
                userInput = new Scanner(System.in);
                continue;
            }

            //Check for a valid arrayLength
            if (isInvalidArrayLength(arrayLength)) {
                logger.warn("User entered an array length less than or equal to zero");
                FormatPrinter.printArrayLengthErrorMessage();
                continue;
            }

            //Runs the menu option with the validated parameters specified by the user
            logger.info("User has entered menu option "+response+" with an array length of "+arrayLength);
            runMenuOption(response, arrayLength);
        }

        //Exit application stage
        FormatPrinter.printExitMessage();
    }

    //Method responsible for calling the next methods based on the choice and arrayLength from the user
    private static void runMenuOption(int algorithmChoice, int arrayLength) {
        if (algorithmChoice == MENU_OPTIONS.length-1) {
            BenchMarker.runAllTestCases(arrayLength);
        } else if (arrayLength > 200) {
            BenchMarker.runSilentTestCase(algorithmChoice, arrayLength);
        } else {
            BenchMarker.runTestCase(algorithmChoice, arrayLength);
        }
        logger.info("Sorters have run successfully");
    }

    //Returns true if array length is invalid, false otherwise
    private static boolean isInvalidArrayLength(int arrayLength) {
        return arrayLength <= 0;
    }

    //Returns true if menu option is invalid, false otherwise
    private static boolean isInvalidMenuOption(int menuOption) {
        return menuOption > MENU_OPTIONS.length || menuOption < 1;
    }

    //Helper method for checking if application should exit based on the menu choice
    private static boolean applicationShouldExit(int choice) {
        return choice == MENU_OPTIONS.length;
    }

}