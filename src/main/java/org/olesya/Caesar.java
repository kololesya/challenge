package org.olesya;

public class Caesar {

    //I don't understand why the capital letter is wrong in cipher
    public static String StringChallenge(String str, int num) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            if (character != ' ') {
                int newPosition = ((int) character + num) % 26;
                char newCharacter = (char) ( newPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main (String[] args) {

        System.out.print(StringChallenge("Caesar Cipher", 2));
    }
}
