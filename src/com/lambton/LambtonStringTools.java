package com.lambton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LambtonStringTools {

    public static String reverse(String string) {
        String reversed = "";
        int i = length(string) - 1;
        for (; i >= 0; i --) {
            reversed += string.charAt(i);
        }
        return reversed;
    }

    public static int binaryToDecimal(String string) {
        // Can be directly done this way - Integer.parseInt(string, 2);
        int n = Integer.parseInt(string);
        int decimal=0, p=0;
        while(n!=0) {
            decimal+=((n%10)*pow(2, p));
            n=n/10;
            p++;
        }
        return decimal;
    }

    /* Using Split
    public static String initials(String string) {
        String[] words = string.split(" ");
        if (words.length < 3) return null;
        String name = "";
        for (int i = 0 ; i < words.length ; i++) {
            char c = words[i].charAt(0);
            char capitalizedChar = findUppercaseFirstLetterInString(words[i]) ? c : (char)(c - 32);
            if (i != words.length - 1) {
                name += capitalizedChar + ".";
            } else {
                name += words[i].replace(c, capitalizedChar);
            }
            name += " ";
        }
        return name;
    }*/

    public static String initials(String string) {
        int words = calculateTotalWords(string);
        if (words < 3) return null;
        String name = "";
        int lastWordIndex = lastWordInitialIndex(string);
        int length = length(string);
        boolean isFirst = true;
        for (int i = 0 ; i < length ; i++) {
            char c = string.charAt(i);
            if (c == ' ') {
                isFirst = true;
                name += (i == length - 1 ? " " : ". ");
                continue;
            }
            if (isFirst) {
                c = Character.isLowerCase(c) ? (char)(c - 32) : c;
                name += c;
            } else {
                if (lastWordIndex < i) {
                    name += c;
                }
                continue;
            }
            isFirst = false;
        }
        return name;
    }

    private static boolean findUppercaseFirstLetterInString(String content) {
        Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(content);
        while (m.find()) {
            if (m.group(1).equals(m.group(1).toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static char mostFrequent(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("input word must have non-empty value.");
        }
        char maxchar = ' ';
        int maxcnt = 0;
        // if you are confident that your input will be only ascii, then this array can be size 128.
        int[] charcnt = new int[Character.MAX_VALUE + 1];
        int i = length(word) - 1;
        for (; i >= 0; i--) {
            char ch = word.charAt(i);
            // increment this character's cnt and compare it to our max.
            if (++charcnt[ch] >= maxcnt) {
                maxcnt = charcnt[ch];
                maxchar = ch;
            }
        }
        return maxchar;
    }

/* Using Split
public static String replaceSubString(String s1, String s2, String s3) {
        String str[] = s1.split(" ");
        String finalString = "";
        for (String string: str) {
            if (string.equalsIgnoreCase(s2)) {
                finalString += s3;
            } else {
                finalString += string;
            }
            finalString += " ";
        }
        return finalString;
    }*/

    public static String replaceSubString(String s1, String s2, String s3) {
        String finalString = "";
        int i = 0;
        int length = length(s1);
        while (true) {
            String word = null;
            for (; i < length; i ++) {
                char c = s1.charAt(i);
                if (c == ' ') {
                    i++;
                    break;
                } else {
                    word = word == null ? c+"" : (word + c);
                }
            }
            if (word == null) break;
            if (word.equalsIgnoreCase(s2)) {
                finalString += s3;
            } else {
                finalString += word;
            }
            finalString += " ";
        }
        return finalString;
    }

    private static int length(String string) {
        return string.toCharArray().length;
    }

    private static int pow(int base, int power){
        if(power == 0) return 1;
        return base * pow(base, --power);
    }

    private static int calculateTotalWords(String str) {
        int length = length(str);
        int count = 1;
        for (int i = 0 ; i < length; i ++ ) {
            if (str.charAt(i) == ' ') {
                count ++;
            }
        }
        return  count;
    }

    private static int lastWordInitialIndex(String str) {
        int length = length(str);
        int i = length - 1;
        for (; i > 0; i -- ) {
            if (str.charAt(i) == ' ') {
                return i - 1;
            }
        }
        return i;
    }
}
