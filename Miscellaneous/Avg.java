/* Find average of a number array between two limit numbers (except the two numbers)
 * Input
 * ---------------
 *  5
    1 
    2
    3
    4
    5
 *  1
 *  4
 * 
 * Output
 * ---------------
 * 2
 */
import java.util.*;
public class Avg{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == a || arr[i] == b)continue;
            else sum+=arr[i];
        }
        sc.close();
        System.out.println(sum/n);
        
    }        
}