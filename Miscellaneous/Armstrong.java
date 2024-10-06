/*Write a Java program to check if a given number is an Armstrong number or not.

Here's an example of the expected input and output:

Input number: 153
Output: "Yes, the number is an Armstrong number."

*/
import java.util.*;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int sum=0;
        for(int i=0;i<n.length();i++){
            int digit = Character.getNumericValue(n.charAt(i));
            sum+=Math.pow(digit, 3);
        }
        if(sum==Integer.parseInt(n)) System.out.println("Yes, the number is an Armstrong number");
        else System.out.println("No, the number is not an armstrong number");
        sc.close();
    }
}
