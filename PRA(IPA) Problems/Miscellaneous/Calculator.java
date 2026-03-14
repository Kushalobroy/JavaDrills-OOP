/*
Write a Java program to implement a simple calculator. The program should prompt the user to enter two numbers and an 
operator (+, -, *, or /) and then perform the corresponding operation and display the result.

For example, if the user enters 4, 5, and +, the program should display 9 as the result. Similarly, if the user enters 10, 3, 
and *, the program should display 30 as the result.

Your program should handle invalid inputs gracefully, for example, if the user enters an operator that is not one of the four 
allowed operators or if the user enters non-numeric inputs. 
*/
import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int a = sc.nextInt();
        System.out.println("Enter second Number: ");
        int b = sc.nextInt();
        System.out.println("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);
        sc.close();
        if(op=='+') System.out.println(a+b);
        else if(op=='-') System.out.println(a-b);
        else if(op == '*') System.out.println(a*b);
        else if(op == '/') System.out.println(a/b);
        else System.out.println("Please choose correct operator");
    }
}
