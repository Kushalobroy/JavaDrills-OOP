/* Last Character of each word of a sentence

 * Input: Rajkiya Engineering College Azamgarh
 * Output: ageh
 */
import java.util.*;
public class LastCharOfWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i].charAt(words[i].length() - 1) + "");
        }
        sc.close();
    }
}
