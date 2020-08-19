public class PalindromeTester {


    public static void testPalindromeChecker() {

        System.out.println("Is 'Hannah' palindrome?: " + Palindrome.palindromeChecker("Hannah"));
        System.out.println("Is 'PiP' palindrome? " + Palindrome.palindromeChecker("PiP"));
        System.out.println("Is 'Michael' palindrome?: " + Palindrome.palindromeChecker("Michael"));

    }

    public static void testPalindromeSentence() {

        System.out.println("Checking sentence 'I have a mouse': " + Printer.stringArrayToString(Palindrome.palindromeSentence("I have a mouse")));
        System.out.println("Checking sentence 'Hannah and Betteb': " + Printer.stringArrayToString(Palindrome.palindromeSentence("Hannah and Betteb")));
        System.out.println("Checking sentence 'Hippity hoppity, this string is now my property': " + Printer.stringArrayToString(Palindrome.palindromeSentence("Hippity hoppity, this string is now my property")));
        String test = "";
        System.out.println("Checking sentence '"+test+"': " + Printer.stringArrayToString(Palindrome.palindromeSentence(test)));

    }



}
