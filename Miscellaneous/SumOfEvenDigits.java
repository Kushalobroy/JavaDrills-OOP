import java.util.*;
public class SumOfEvenDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int sum=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'0') % 2 ==0) sum+=(s.charAt(i)-'0');
        }
        System.out.println(sum);
    }
}
