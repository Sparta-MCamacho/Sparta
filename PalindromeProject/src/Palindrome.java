public class Palindrome {

    public static boolean containsAlphabet(String stringParameter) {

        //Convert to lower case to ignore case
        String lowerCaseString = stringParameter.toLowerCase();

        //Use char in loop to go through the alphabet using String.contains()
        for (char alphaChar = 'a';alphaChar <= 'z';alphaChar++) {
            if (lowerCaseString.contains(Character.toString(alphaChar))) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static String[] palindromeSentence(String sentence) {
        //Getting an array of each word
        String[] words = sentence.split(" ");
        String[] palindromes = new String[words.length];

        //Picking out which word is palindrome
        for (int i = 0;i < words.length;i++) {
            if (Palindrome.palindromeChecker(words[i])) {
                palindromes[i] = words[i];
            }
        }

        //Remove null Strings
        palindromes = Palindrome.removeNull(palindromes);

        //Find longest length of palindrome
        int longestLength = 0;
        for (int i = 0;i < palindromes.length;i++) {
            if (palindromes[i].length() > longestLength) {
                longestLength = palindromes[i].length();
            }
        }

        //Find number of palindromes of that length
        int palindromeCount = 0;
        for (String s : palindromes) {
            if (s.length() == longestLength) {
                palindromeCount++;
            }
        }

        //Pick out all palindromes of that length
        String[] returnPalindromes = new String[palindromeCount];
        int counter = 0;
        for (String s : palindromes) {
            if (s.length() == longestLength) {
                returnPalindromes[counter] = s;
                counter++;
            }
        }

        return returnPalindromes;
    }

    public static boolean palindromeChecker(String word) {

        //Initialise an iterable array with lower case
        char[] wordArray = word.toLowerCase().toCharArray();

        for (int i = 0;i < wordArray.length;i++) {

            //Make the palindrome check
            if (wordArray[i] == wordArray[wordArray.length-i-1]) {
            } else {

                //Return false if at any point the palindrome property is not satisfied
                return false;
            }
        }
        return true;
    }

    //Helper method which removes all null entries
    public static String[] removeNull(String[] stringArray) {
        int numberOfStrings = 0;

        for (String s : stringArray) {
            if (s != null) {
                numberOfStrings++;
            }
        }

        String[] returnArray = new String[numberOfStrings];
        int counter = 0;
        for (String s : stringArray) {
            if (s != null) {
                returnArray[counter] = s;
                counter++;
            }
        }
        return returnArray;
    }

}
