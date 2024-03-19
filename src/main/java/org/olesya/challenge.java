package org.olesya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class challenge {
    public static List<String> convertStringToList(String str) {
        List<String> list = new ArrayList<>();

        int left, right,  i = 0;
        int n = str.length();

        while (i < n) {

            if (str.charAt(i) == '<') {
                right = i;
                while (str.charAt(right) != '>') {
                    right++;
                }
                right++;
                list.add(str.substring(i, right));
            }

            if (i > 0 && str.charAt(i - 1) == '>' && str.charAt(i) != '<') {
                left = i;
                while (str.charAt(left) != '<') {
                    left++;
                }
                list.add(str.substring(i, left));
            }

            i++;
        }

        return list;
    }

    public static String htmlElements (String str) {
        List<String> list = convertStringToList(str);
        Stack<String> stack = new Stack<>();
        String[] openTags = {"<br>", "<i>", "<div>", "<a>", "<p>", "<em>", "<b>"};
        String[] closeTags = {"</br>", "</i>", "</div>", "</a>", "</p>", "</em>", "</b>"};
        String res = "";

        for (String s : list) {
            if (Arrays.asList(openTags).contains(s)) {
                stack.push(s);
            } else if (
                    Arrays.asList(closeTags).contains(s) &&
                            Arrays.asList(openTags).indexOf(stack.peek()) ==
                                    Arrays.asList(closeTags).indexOf(s)
            ) {
                stack.pop();
            } else if (
                    Arrays.asList(closeTags).contains(s) &&
                            Arrays.asList(openTags).indexOf(stack.peek()) !=
                                    Arrays.asList(closeTags).indexOf(s)
            ) {
                res = stack.peek();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String newString = "<div><b><p>hello world</i></b></div>";
        System.out.println(htmlElements(newString));
    }
}
