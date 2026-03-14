/* Remove Vowel From A String 

 * Input : Arijit Ghosh
 * Output : rjt Ghsh
 */
import java.util.*;
public class RemoveVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        String result = removeVowel(str);
        System.out.println( result);
        sc.close();
    }
    public static String removeVowel(String s){
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i'); set.add('o'); set.add('u');  
        set.add('A'); set.add('E'); set.add('I');set.add('O'); set.add('U');
        String ans="";
        for(int i =0;i<s.length();i++){
            if(!set.contains( s.charAt(i))){
                ans+= s.charAt(i);
            }
        }
        return ans;
    } 
}
