/* 
Problem Statement
Write a Java program to print the unique characters present in the given string in the same sequence as they appear(the first occurrence) in the input.

Note:
All the characters should be in lowercase only.

i/p -> 
xperience

o/p -> 
xperinc
*/
import java.util.*;
public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        sc.close();
        System.out.println(sb.toString());
    }
}

