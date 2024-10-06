/* Input : 123Arijit1998Arijit10

 * Process :
 * -----------
 * Array : [123, Arijit, 1998, Arijit, 10]
 * Now you should sum up the position of that array where numbers are stored.
 * 123 + 1998 = 2121
 * 
 * Output :
 * --------------
 * 2131
 */
import java.util.*;
public class SumOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> ls = new ArrayList<>();
        String num="";
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num+=s.charAt(i);
            }else{
                if (!num.isEmpty()) {  // Add only non-empty numbers
                    ls.add(num);
                    num = "";  // Reset the number accumulator
                }
            }
        }
        if (!num.isEmpty()) {
            ls.add(num);
        }
        int sum=0;
        for(int i=0;i<ls.size();i++){
            sum+=Integer.parseInt(ls.get(i));
            // System.out.println(ls.get(i));
        }
        System.out.println(sum);
        sc.close();
    }
}
