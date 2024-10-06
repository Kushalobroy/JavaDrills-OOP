/* Count the sum of prime digits in a given number
 * 
 * Input: 2345678910
 * Output: 17
 * 
 * Explaination: 2+3+5+7 = 17
 */
import java.util.*;
public class SumOfPrimeDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        set.add('2');set.add('5');
        set.add('3'); set.add('7'); 
        int sum=0;  
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))) sum+=s.charAt(i)-'0';
        }
        System.out.println(sum);
        sc.close();
    }

}
