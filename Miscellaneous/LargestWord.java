/* Find largest word from a given sentence
 * 
 Input: He is so funny boy
 Output: funny
 */

import java.util.*;
public class LargestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split(" ");
        String max = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > max.length()) {
                max = words[i];
            }
        }
        System.out.println(max);
        sc.close();
    }
}
