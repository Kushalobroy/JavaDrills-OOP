/* Find number of lower case in a string
 * AriJIt = 3
 */
/* Find number of upper case in a string
 * AriJIt = 3
 */
import java.util.*;

public class LowerAndUpperCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int lower=0, upper =0;
        for(int i=0;i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))) lower++;
            else upper++;
        }
        System.out.println("Lower Case: "+lower);
        System.out.println("Upper Case: "+upper);
        sc.close();
    }
}
