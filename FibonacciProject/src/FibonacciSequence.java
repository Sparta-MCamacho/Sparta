import java.math.BigInteger;

public class FibonacciSequence {

    //Method using primitive type int is valid up until the 48th Fibonacci number
    public void fibonacci(int max) {

        //Checking if values are zero or negative
        if (max <= 0) {
            System.out.println("The parameter max must be greater than zero");
        } else if (max == 1) {
            //Simple case where int parameter is one
            System.out.println("First value of the Fibonacci sequence is: ");
            System.out.print(0);
        } else {
            //Initialise holder variables for the Fibonacci numbers
            BigInteger firstFibNum = BigInteger.ZERO;
            BigInteger secondFibNum = BigInteger.ONE;
            BigInteger tempFibNum;

            //Manually print first two numbers to start cycle
            System.out.println("The first " + max + " Fibonacci numbers are:");
            printSingleFibNumber(firstFibNum);
            printSingleFibNumber(secondFibNum);

            //Now start loop at position 3 (int i = 2) and end before last cycle (max-1)
            for (int i = 2;i < max-1;i++) {
                //Calculate the next fibNum and print it
                tempFibNum = firstFibNum.add(secondFibNum);
                printSingleFibNumber(tempFibNum);

                //Set up the next cycle
                firstFibNum = secondFibNum;
                secondFibNum = tempFibNum;
            }
            //Finishing the last cycle manually for aesthetics
            tempFibNum = firstFibNum.add(secondFibNum);
            System.out.println(tempFibNum.toString());
        }

    }

    private void printSingleFibNumber(BigInteger fibonacciNumber) {
        System.out.print(fibonacciNumber.toString() + ", ");
    }

    public void testIntPrimitive() {
        int zero = 0;
        int one = 1;
        int temp;

        for (int i = 1; i < 100;i++) {
            temp = zero + one;
            System.out.print(temp + ", ");
            if (temp < 0) {
                System.out.println("");
                System.out.println("Valid before the " + (i+2) + " Fibonacci number");
                break;
            }

            zero = one;
            one = temp;
        }
    }

}
