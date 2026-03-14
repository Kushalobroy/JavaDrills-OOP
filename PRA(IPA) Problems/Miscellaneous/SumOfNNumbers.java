/*
Write a Java program that takes a user input integer n and calculates the sum of the first n natural numbers.

The program should use a for loop to calculate the sum.

Sample Input:
---------------------
5

Sample Output:
---------------------
The sum of first 5 natural numbers is 15.

Explanation:
---------------------
The first 5 natural numbers are: 1, 2, 3, 4, 5
Their sum is: 1 + 2 + 3 + 4 + 5 = 15

*/
import java.util.*;
public class SumOfNNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("The sum of first "+n+" natural number is "+(n*(n+1))/2);
        sc.close();
    }
}
