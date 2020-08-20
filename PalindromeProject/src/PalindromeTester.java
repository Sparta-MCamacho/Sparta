public class PalindromeTester {


    public static void testPalindromeChecker() {

        System.out.println("Beginning palindromeChecker() tests...");
        System.out.println("Is 'Hannah' palindrome?: " + Palindrome.palindromeChecker("Hannah"));
        System.out.println("Is 'PiP' palindrome? " + Palindrome.palindromeChecker("PiP"));
        System.out.println("Is 'Michael' palindrome?: " + Palindrome.palindromeChecker("Michael"));
        String testt = "tattarrattat";
        System.out.println("Is '"+testt+"' palindrome?: " + Palindrome.palindromeChecker(testt));
        Printer.printLineBreaker();
    }

    public static void testPalindromeSentence() {

        System.out.println("Beginning palindromeSentence() tests...");
        System.out.println("Checking sentence 'I have a mouse': " + Printer.stringArrayToString(Palindrome.palindromeSentence("I have a mouse")));
        System.out.println("Checking sentence 'Hannah and Betteb': " + Printer.stringArrayToString(Palindrome.palindromeSentence("Hannah and Betteb")));
        System.out.println("Checking sentence 'Hippity hoppity, this string is now my property': " + Printer.stringArrayToString(Palindrome.palindromeSentence("Hippity hoppity, this string is now my property")));
        String test = "";
        System.out.println("Checking sentence '"+test+"': " + Printer.stringArrayToString(Palindrome.palindromeSentence(test)));
        Printer.printLineBreaker();
    }

    public static void testContainsAlphabet() {

        System.out.println("Beginning containsAlphabet() tests...");
        System.out.println("Does 'A quick brown fox jumps over the lazy dog' contain the alphabet'?: " + Palindrome.containsAlphabet("A quick brown fox jumps over the lazy dog"));
        System.out.println("Does 'This is a sentence': " + Palindrome.containsAlphabet("This is a sentence"));
        String test = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Does '"+test+"': " + Palindrome.containsAlphabet(test));
        Printer.printLineBreaker();
    }



}
