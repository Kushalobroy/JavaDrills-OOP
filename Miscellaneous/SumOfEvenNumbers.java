/* Write a Java program to find the sum of all even numbers in an array of integers.

Here's an example of the expected input and output:

Input array: {10, 5, 20, 8, 13}
Output: 
Sum of even numbers: 38

*/
import java.util.*;
public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i] % 2 ==0) sum+=arr[i];
        }
        System.out.println(sum);
        sc.close();
    }
}
