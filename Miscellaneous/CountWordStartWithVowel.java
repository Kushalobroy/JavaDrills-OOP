/* Count the words in a sentence which are start with vowel. 
 * 
 * Input: Arijit is student of MCA
 * Output: 3
 * 
 * Input: Sara plays tennis
 * Output: No such words
*/
import java.util.*;
public class CountWordStartWithVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        String[] arr = s.split(" ");
        HashSet<Character> set = new HashSet<>();
        set.add('a');  set.add('e');  set.add('o');  set.add('u');  set.add('i');
        set.add('A');  set.add('E');  set.add('I');  set.add('O');  set.add('U');
        for(String a:arr){
            if(set.contains( a.charAt(0))) count++;
        }
        if(count>0) System.out.println(count);
        else System.out.println("No such words");
        sc.close();
    }
}
